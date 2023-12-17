package service;

import entity.OrderProduct;
import repository.OrderProductRepository;

import java.util.List;

public class OrderProductService {

    private OrderProductRepository orderProductRepository;

    public String[] getColumn() {
        return orderProductRepository.findColumnName();
    }

    public List<OrderProduct> getOrderProductAll() {
        orderProductRepository = new OrderProductRepository();
        List<OrderProduct> orderProductList = orderProductRepository.findAll();

        return orderProductList;
    }

    public void create(int productId, int orderId, int quantity, int price) {
        orderProductRepository = new OrderProductRepository();

        OrderProduct orderProduct = new OrderProduct(productId, orderId, quantity, price);
        orderProductRepository.save(orderProduct);
    }
}
