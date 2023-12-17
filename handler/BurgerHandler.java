package handler;

import entity.Product;
import panel.TextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BurgerHandler implements ActionListener {
    private TextArea textArea;
    private Product product;

    public BurgerHandler(TextArea textArea, Product product) {
        this.textArea = textArea;
        this.product = product;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 버거 버튼을 클릭했을 때의 동작
        textArea.addData(new Object[]{
                product.getProductName(),
                product.getPrice(),
                1, // 임시 수량 1로 설정
                product.getPrice()
        });
    }
}
