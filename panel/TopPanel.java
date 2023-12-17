package panel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.w3c.dom.Text;
import service.ProductService;
import view.MenuView;

public class TopPanel extends JTabbedPane{
	private ProductService productService;
	private BurgerMenu burgerMenu;
	private BeverageMenu beverageMenu;
	private TextArea textArea;

	public TopPanel(BurgerMenu burgerMenu, BeverageMenu beverageMenu, TextArea textArea) {
		this.burgerMenu = burgerMenu;
		this.beverageMenu = beverageMenu;
		this.textArea = textArea;

		 this.addTab("햄버거", burgerMenu);
	     this.addTab("음료", beverageMenu); 
}
}
