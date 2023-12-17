package panel;

import entity.Category;
import handler.MenuOptionHandler;
import service.CategoryService;

import javax.swing.*;
import java.util.List;

public class MenuOptionPanel extends JPanel {
    private MenuOptionHandler menuOptionHandler;
    private CategoryService categoryService;
    private JTextField productNameField;
    private JTextField priceField;
    private JComboBox categoryComboBox;
    private JButton checkButton;
    private List<Category> categoryList;

    public MenuOptionPanel() {
        menuOptionHandler = new MenuOptionHandler(this);
        categoryService = new CategoryService();
        categoryList = categoryService.getCategoryAll();
        String[] categoryName = new String[categoryList.size()];
        for(int i=0; i<categoryList.size(); i++) {
            categoryName[i] = categoryList.get(i).getCategoryName();
        }
        productNameField = new JTextField("메뉴명", 8);
        priceField = new JTextField("가격", 8);
        categoryComboBox = new JComboBox(categoryName);
        checkButton = new JButton("추가하기");
        checkButton.addActionListener(menuOptionHandler);
        this.add(productNameField);
        this.add(priceField);
        this.add(categoryComboBox);
        this.add(checkButton);
    }

    public JButton getButton() {
        return checkButton;
    }

    public JTextField getProductNameField() {
        return productNameField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JComboBox getCategoryComboBox() {
        return categoryComboBox;
    }
}
