package panel;

import entity.Product;
import handler.BurgerHandler;
import service.ProductService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BurgerMenu extends JPanel {
    private List<Product> productList;
    private JButton[] burgerbt;
    private TextArea textArea;

    public BurgerMenu(TextArea textArea) {
        this.textArea = textArea;
        ProductService productService = new ProductService();
        productList = productService.getListByCategory(1);
        burgerbt = new JButton[productList.size()];

        this.setBackground(new Color(204, 204, 051));
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1900, 500));

        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            burgerbt[i] = new JButton(product.getProductName());
            Dimension buttonSize = new Dimension(150, 150);
            burgerbt[i].setPreferredSize(buttonSize);
            burgerbt[i].addActionListener(new ActionListener() {
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
            });
            this.add(burgerbt[i]);
        }
    }
}
