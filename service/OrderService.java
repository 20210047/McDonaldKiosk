package service;

import entity.Order;
import repository.OrderRepository;

import java.sql.Timestamp;

public class OrderService {
    private OrderRepository orderRepository;
    public void create(int memberId, Timestamp orderDate, int paymentId) {
        orderRepository = new OrderRepository();
        Order order = new Order(memberId, orderDate, paymentId);
        orderRepository.save(order);
    }

}
