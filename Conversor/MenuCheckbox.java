package Conversor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;

public class MenuCheckbox extends JCheckBoxMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ActionListener acao;

	public MenuCheckbox(String text) {
		super(text);
	}
	
	public MenuCheckbox(String text, Boolean active) {
		super(text, active);
	}

	public MenuCheckbox(String text, Boolean active, ActionListener acao) {
		super(text, active);
		addActionListener(this);
		this.acao = acao;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Selecionou: " + e.getActionCommand());
		if (acao != null) {
			acao.onclick();
		}
	}

	public interface ActionListener {
		void onclick();
	}

}