package view;

import panel.ProductAddPanel;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    private ProductAddPanel productAddPanel;
    public AdminView() {
        productAddPanel = new ProductAddPanel();
        setTitle("어드민 패널");
        setSize(480, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(productAddPanel);
        setVisible(true);
    }
}
