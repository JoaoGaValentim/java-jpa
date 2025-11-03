package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> entity;

    // É executado imediatamente, antes de qualquer construtor. Não sendo executado
    // mais de uma vez
    static {
        try {
            // crio uma única vez
            emf = Persistence.createEntityManagerFactory("java-jpa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DAO() {
        this(null);
        em = emf.createEntityManager();
    }

    public DAO(Class<E> entity) {
        this.entity = entity;
        em = emf.createEntityManager();
    }

    private void raiseNullException(E e) {
        if (entity == null || e == null) {
            throw new UnsupportedOperationException("EntityException: Entity is null, invalid operation");
        }
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> commitTransaction() {
        em.getTransaction().commit();
        return this;
    }

    private DAO<E> save(E entity) {
        em.persist(entity);
        return this;
    }

    public DAO<E> store(E entity) {
        this.openTransaction().save(entity).commitTransaction();
        return this;
    }

    public List<E> fetchWithLimitAndOffset(int limit, int offset) {
        if (entity == null) {
            throw new UnsupportedOperationException("EntityException: Entity is null, invalid operation");
        }

        final String jpql = "SELECT e FROM " + entity.getName() + " e";
        final TypedQuery<E> query = em.createQuery(jpql, entity);

        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public List<E> fetchAll() {
        return this.fetchWithLimitAndOffset(10, 0);
    }

    public E fetchOneById(long id) {
        E e = em.find(entity, id);
        raiseNullException(e);
        return e;
    }

    public DAO<E> update(E e) {
        raiseNullException(e);
        em.merge(e);
        return this;
    }

    public DAO<E> remove(long id) {
        this.openTransaction();
        E e = fetchOneById(id);
        em.remove(e);
        return this;
    }
    
    public List<E> search(String nameSearch, Object... params) {
    	TypedQuery<E> query = em.createNamedQuery(nameSearch, entity);
    	
    	for (int i = 0; i < params.length; i+= 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}
    	
    	return query.getResultList();
    }
    
    public E findOne(String nameSearch, Object... params) {
    	List<E> entities = search(nameSearch, params);
    	return entities.isEmpty() ? null : entities.get(0);
    }

    public void close() {
        em.close(); // não quero fechar a fábrica só o manager
    }
}
