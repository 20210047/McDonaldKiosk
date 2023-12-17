package handler;

import javax.swing.*;

import component.PaymentJOptionPane;
import entity.Payment;
import entity.User;
import panel.SouthOrderPanel;
import service.OrderProductService;
import service.OrderService;
import service.PaymentService;
import service.UserService;
import user.UserContextHolder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class PaymentHandler implements ActionListener {
    private SouthOrderPanel southOrderPanel;
    private OrderProductService orderProductService;
    private UserService userService;
    private OrderService orderService;
    private PaymentService paymentService;
    private Timestamp timestamp;
    private PaymentJOptionPane paymentJOptionPane;

    public PaymentHandler(SouthOrderPanel southOrderPanel) {
        this.southOrderPanel = southOrderPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timestamp = new Timestamp(System.currentTimeMillis());
        if(southOrderPanel != null) {
            String paymentMethod = southOrderPanel.showPaymentOption(1000);
            if(!paymentMethod.isEmpty()) {
                userService = new UserService();
                orderService = new OrderService();
                paymentService = new PaymentService();
                orderProductService = new OrderProductService();

                User user = userService.getUser(UserContextHolder.getInstance().getUsername());
                Payment payment = paymentService.getPayment(convertStringToInt(paymentMethod));
                orderService.create(user.getId() , timestamp, payment.getId());
//                orderProductService.create();
                JOptionPane.showMessageDialog(null, "감사합니다!");
            } else {
                JOptionPane.showMessageDialog(null, "결제가 취소되었습니다.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "주문한 메뉴가 없습니다.");
        }
    }
    private int convertStringToInt(String str) {
        if(str.equals("신용카드")) return 1;
        else if(str.equals("현금")) return 2;
        else if(str.equals("모바일 결제")) return 3;
        return -1;
    }
}