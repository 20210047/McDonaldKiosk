package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import entity.OrderProduct;

public class RefreshHandler implements ActionListener {
    private List<OrderProduct> orderProductList;
    private JTextArea orderDetailsTextArea;
    @Override
    public void actionPerformed(ActionEvent e) {
        orderProductList = new ArrayList<>();
        StringBuilder details = new StringBuilder("주문번호\t상품\t수량\t가격\n");
        for(OrderProduct orderProduct : orderProductList) {
            details.append(orderProduct.getOrderId()).append("\t")
                    .append(orderProduct.getProductId()).append("\t")
                    .append(orderProduct.getQuantity()).append("\t")
                    .append(orderProduct.getPrice()).append("원\n"); }

        int totalSales =
                orderProductList.stream().mapToInt(OrderProduct::getPrice).sum();
        details.append("...\n총매출: ").append(totalSales).append("원");
        orderDetailsTextArea.setText(details.toString());

    }

}