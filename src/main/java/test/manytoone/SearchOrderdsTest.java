package test.manytoone;

import infra.DAO;
import models.Order;
import models.OrderItem;

public class SearchOrderdsTest {

	public static void main(String[] args) {
		DAO<Order> orderDao = new DAO<>(Order.class);
		
		Order order = orderDao.fetchOneById(1L);
		
		for (OrderItem item : order.getOrderItems()) {
			System.out.println(item.getProduct().getName());
			System.out.println(item.getPrice() * item.getQuantity());
		}
	}

}
