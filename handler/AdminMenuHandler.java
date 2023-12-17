package handler;

import panel.ProductAddPanel;
import view.MenuOptionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuHandler implements ActionListener {
    private ProductAddPanel menuAddPanel;

    public AdminMenuHandler(ProductAddPanel productAddPanel) {
        this.menuAddPanel = productAddPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuAddPanel.getMenuAddButton()) {
            new MenuOptionView();
        }
    }
}
