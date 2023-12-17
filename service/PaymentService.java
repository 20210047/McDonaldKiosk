package service;

import db.DBManager;
import entity.Payment;
import repository.PaymentRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private PaymentRepository paymentRepository;

    public Payment getPayment(int id) {
        paymentRepository = new PaymentRepository();
        Payment payment = paymentRepository.findById(id);
        return payment;
    }

    public List<Payment> getPaymentAll() {
        paymentRepository = new PaymentRepository();
        List<Payment> paymentList = paymentRepository.findAll();
        return paymentList;
    }
}
