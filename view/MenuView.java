package view;

import entity.Product;
import handler.BurgerHandler;
import panel.*;
import panel.TextArea;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

    public MenuView() {
        TextArea textArea = new TextArea();
        BurgerMenu burgerMenu = new BurgerMenu(textArea);
        BeverageMenu beverageMenu = new BeverageMenu(textArea);
        SouthOrderPanel southClick = new SouthOrderPanel(textArea);
        TopPanel topPanel = new TopPanel(burgerMenu, beverageMenu, textArea);

        JFrame frame = new JFrame("햄버거 자동 판매기");
        frame.setBounds(0, 0, 1800, 1000);
        frame.setBackground(Color.black);

        frame.add(topPanel);
        frame.add(new JScrollPane(textArea), BorderLayout.EAST);
        frame.add(southClick, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuView menuView = new MenuView();
            menuView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
