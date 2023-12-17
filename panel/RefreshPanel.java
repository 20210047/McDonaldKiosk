package panel;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import handler.RefreshHandler;
import service.ProductService;

public class RefreshPanel extends JPanel {
    private ProductService productService;
    private JButton refreshButton;

    public RefreshPanel(){
        this.setBackground(new Color(254,254,254));
        this.setLayout(new FlowLayout());
        refreshButton = new JButton("매출 현황 새로고침");

        this.add(refreshButton);
        RefreshHandler refreshHandler = new RefreshHandler();
        refreshButton.addActionListener(refreshHandler);

    }
}
