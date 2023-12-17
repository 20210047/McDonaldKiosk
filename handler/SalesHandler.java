package handler;

import panel.ProductAddPanel;
import panel.SalesPanel;
import view.MenuOptionView;
import view.SalesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesHandler implements ActionListener {
    private ProductAddPanel sales;

    public SalesHandler(ProductAddPanel productAddPanel) {
        this.sales = productAddPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sales.getSalesButton()) {
            new SalesView();
        }
    }
}
