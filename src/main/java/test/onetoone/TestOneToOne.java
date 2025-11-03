package test.onetoone;

import infra.DAO;
import models.onetoone.Client;
import models.onetoone.Seat;

public class TestOneToOne {
	public static void main(String[] args) {
		//	Seat seat = new Seat("16c");
		//	Client client = new Client("João", seat);
		//		
		//	dao
		//	  .store(seat)
		//	  .store(client)
		//	  .close();

		//	List<Seat> seats = Arrays.asList(new Seat("15c"), new Seat("14c"), new Seat("2f"));
		//
		//	List<Client> clients = Arrays.asList(
		//		new Client("Clara", null),
		//		new Client("Lucas", null),
		//		new Client("Ana", null)
		//	);
		//		
		//		
		//	DAO<Object> dao = new DAO<>();
		//	int i = 0;
		//	for (Client client : clients) {
		//		Seat seat = seats.get(i);
		//		client.setSeat(seat);
		//			
		//		dao
		//		  .store(seat)
		//		  .store(client);
		//		i++;
		//	}
		//	
		
		// Seat seat = new Seat("4D");
		// com cascata posso persistir dois objetos relacionados
		// ao mesmo tempo @OneToOne(cascade = {CascadeType.PERSIST})
		// Client client = new Client("João", seat);
		
		DAO<Client> dao = new DAO<>(Client.class);
		
		Client clientData = dao.fetchOneById(1L);
		
		System.out.println(clientData.getName());
		System.out.println(clientData.getSeat().getName());
		
		System.out.println(clientData.getSeat().getClient().getName());
		
		DAO<Seat> seatDao = new DAO<>(Seat.class);
		
		Seat seat = seatDao.fetchOneById(1L);
		System.out.println(seat.getClient().getName());
	
		dao.close();
	}
}
