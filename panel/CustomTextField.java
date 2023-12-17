package panel;

import javax.swing.*;

public class CustomTextField extends JTextField {
    JTextField customTextField;
    public CustomTextField(int col, String text) {
        customTextField = new JTextField(text, col);
    }
}
