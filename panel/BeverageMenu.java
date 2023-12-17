package panel;

import entity.Product;
import service.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BeverageMenu extends JPanel {
    private List<Product> productList;
    private ProductService productService;
    private JButton[] beverageBt;
    private TextArea textArea; // TextArea 추가

    public BeverageMenu(TextArea textArea) {
        this.textArea = textArea; // TextArea를 받아옴
        productService = new ProductService();
        productList = productService.getListByCategory(2);
        beverageBt = new JButton[productList.size()];

        this.setBackground(new Color(204, 204, 051));
        this.setLayout(new FlowLayout());
        this.setSize(0, 500);
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            beverageBt[i] = new JButton(product.getProductName());
            Dimension buttonSize = new Dimension(150, 150);
            beverageBt[i].setPreferredSize(buttonSize);
            beverageBt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 음료 버튼을 클릭했을 때의 동작
                    textArea.addData(new Object[]{
                            product.getProductName(),
                            product.getPrice(),
                            1, // 임시 수량 1로 설정
                            product.getPrice()
                    });
                }
            });
            this.add(beverageBt[i]);
        }
    }
}
