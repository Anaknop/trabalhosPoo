package Conversor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class Menu extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ActionListener acao;

	public Menu(String text) {
		super(text);
	}
	
	public Menu(String text, ActionListener acao) {
		super(text);
		addActionListener(this);
		this.acao = acao;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Item clicked: " + e.getActionCommand());
		if (acao != null) {
			acao.onclick();
		}
	}

	public interface ActionListener {
		void onclick();
	}

}