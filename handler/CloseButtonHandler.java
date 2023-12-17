package handler;

import panel.SouthOrderPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseButtonHandler implements ActionListener {
    private SouthOrderPanel southOrderPanel;
    public CloseButtonHandler(SouthOrderPanel southOrderPanel) {
        this.southOrderPanel = southOrderPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
