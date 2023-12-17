package panel;

import entity.OrderProduct;
import service.OrderProductService;

import javax.swing.*;
import java.util.List;

public class OrderTablePanel extends JPanel {

    private OrderProductService orderProductService;
    String[] header;
    private JTable orderTable;
    public OrderTablePanel() {
        orderProductService = new OrderProductService();
        header = orderProductService.getColumn();
        orderTable = new JTable();

        this.add(orderTable);
    }

    public JTable getOrderTable() {
        return orderTable;
    }
}
