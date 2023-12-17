package component;

import entity.Payment;

import javax.swing.*;
import java.util.List;

public class PaymentJOptionPane extends JOptionPane {
    public PaymentJOptionPane(List<Payment> paymentList) {
//        this.options = getPaymentList(paymentList);
        this.messageType = 3;
        this.createDialog(null, "결제 수단 선택");

    }
}
