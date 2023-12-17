package handler;

import panel.MenuOptionPanel;
import service.ProductService;
import view.MenuOptionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuOptionHandler implements ActionListener {
    private MenuOptionPanel menuOptionPanel;
    private ProductService productService;

    public MenuOptionHandler(MenuOptionPanel menuOptionPanel) {
        this.menuOptionPanel = menuOptionPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuOptionPanel.getButton()) {
            productService = new ProductService();
            String productName = menuOptionPanel.getProductNameField().getText();
            int price = Integer.parseInt(menuOptionPanel.getPriceField().getText());
            int category = (menuOptionPanel.getCategoryComboBox().getSelectedIndex()+1);
            productService.save(productName, price, category);
        }
    }
}
