package view;

import panel.RefreshPanel;
import panel.SalesPanel;

import javax.swing.*;
import java.awt.*;

public class SalesView extends JFrame {
    private SalesPanel salesPanel;
    private RefreshPanel refreshPanel;
    public SalesView() {
        salesPanel = new SalesPanel();
        refreshPanel = new RefreshPanel();
        setTitle("어드민 패널");
        setSize(1900, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(salesPanel);
        c.add(refreshPanel,BorderLayout.SOUTH);
        setVisible(true);
    }
}
