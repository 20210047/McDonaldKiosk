package panel;

import handler.AdminMenuHandler;
import handler.RefreshHandler;
import handler.SalesHandler;

import javax.swing.*;
import java.awt.*;

public class ProductAddPanel extends JPanel {
    private AdminMenuHandler adminMenuHandler;
    private SalesHandler salesHandler;
    private JButton salesButton;
    private JButton menuAddButton;
    public ProductAddPanel() {
        adminMenuHandler = new AdminMenuHandler(this);
        salesHandler = new SalesHandler(this);
        menuAddButton = new JButton("메뉴 추가");
        salesButton = new JButton(("매출 현황"));
        this.setLayout(new FlowLayout());

        menuAddButton.addActionListener(adminMenuHandler);
        salesButton.addActionListener(salesHandler);
        this.add(menuAddButton);
        this.add(salesButton);
    }

    public JButton getMenuAddButton() {
        return menuAddButton;
    }
    public JButton getSalesButton(){
        return salesButton;
    }
}

