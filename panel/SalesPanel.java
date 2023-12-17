package panel;

import java.awt.Dimension;

import javax.swing.*;

public class SalesPanel extends JPanel {
    private JTextArea orderDetailsTextArea;

    public SalesPanel() {
        orderDetailsTextArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(orderDetailsTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(1500, 900));

        add(scrollPane);
    }

    public JTextArea getOrderDetailsTextArea() {
        return orderDetailsTextArea;
    }
}
