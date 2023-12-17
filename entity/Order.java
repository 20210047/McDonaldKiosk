package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Order {
    private int id;
    private int memberId;
    private Timestamp orderDate;
    private int paymentId;

    public Order(int id, int memberId, Timestamp orderDate, int paymentId) {
        this.id = id;
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.paymentId = paymentId;
    }

    public Order(int memberId, int paymentId) {
        this.memberId = memberId;
        this.paymentId = paymentId;
    }

    public Order(int memberId, Timestamp orderDate, int paymentId) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.paymentId = paymentId;
    }

    public int getId() {
        return id;
    }
    public int getMemberId() {
        return memberId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
