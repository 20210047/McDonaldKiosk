package view;

import panel.MenuOptionPanel;

import javax.swing.*;
import java.awt.*;

public class MenuOptionView extends JFrame {
    private MenuOptionPanel menuOptionPanel;
    public MenuOptionView() {
        menuOptionPanel = new MenuOptionPanel();
        setTitle("메뉴 추가");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(480, 640);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(menuOptionPanel);

        setVisible(true);
    }
}
