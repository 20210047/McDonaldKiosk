package panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.*;

import component.PaymentJOptionPane;
import entity.Payment;
import handler.CloseButtonHandler;
import handler.PaymentHandler;
import service.PaymentService;
import service.ProductService;
import view.PaymentView;

public class SouthOrderPanel extends JPanel {
	private ProductService productService;
	private PaymentService paymentService;
	private JButton paymentButton;
	private JButton closeButton;
	private PaymentJOptionPane paymentJOptionPane;
	private PaymentHandler paymentHandler;
	private CloseButtonHandler closeButtonHandler;

	public SouthOrderPanel(TextArea textArea){
		productService = new ProductService();
		paymentService = new PaymentService();
		this.setBackground(new Color(204,00,000));
		this.setLayout(new FlowLayout());
		paymentHandler = new PaymentHandler(this);
		closeButtonHandler = new CloseButtonHandler(this);

		paymentButton = new JButton("결제");
		closeButton = new JButton("닫기");

		paymentButton.addActionListener(paymentHandler);
		closeButton.addActionListener(closeButtonHandler);

		this.add(paymentButton);
		this.add(closeButton);
	}

	public String showPaymentOption(int amount) {
		paymentService = new PaymentService();
		String options[] = getPaymentList(paymentService.getPaymentAll());
		String selectedOption = (String) JOptionPane.showInputDialog(
				null,
				"총액은 "+amount+"원입니다. 결제 방법을 선택하세요.",
				"결제 수단",
				JOptionPane.PLAIN_MESSAGE,
				null,
				options,
				options[0]);
		if (selectedOption != null && !selectedOption.isEmpty()) {
			return selectedOption;
		}
		return "";
	}

	public JButton getPaymentButton() {
		return paymentButton;
	}


	public JButton getCloseButton() {
		return closeButton;
	}

	private String[] getPaymentList(List<Payment> paymentList) {
		String[] strings = new String[paymentList.size()];
		for(int i=0; i<paymentList.size(); i++) {
			strings[i] = String.valueOf(paymentList.get(i).getPaymentName());
		}
		return strings;
	}
}