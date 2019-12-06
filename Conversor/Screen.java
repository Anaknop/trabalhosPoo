package Conversor;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Screen extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<JFormattedTextField> tfList = new ArrayList<JFormattedTextField>();

	public Screen() {
		setTitle("Conversor Universal");
		setSize(600, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout();
	}

	private void setLayout() {
		JTabbedPane panel = new JTabbedPane();
		addTab("Moeda", panel);
		addTab("Temperatura", panel);
		addTab("Comprimento", panel);

		setMenubar(panel);
		add(panel);
	}

	private void setMenubar(JTabbedPane panel) {
		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("Arquivo");
		JMenu editMenu = new JMenu("Editar");
		JMenu helpMenu = new JMenu("Ajuda");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		Menu exitAction = new Menu("Sair", new Menu.ActionListener() {
			@Override
			public void onclick() {
				dispatchEvent(new WindowEvent(Screen.this, WindowEvent.WINDOW_CLOSING));
			}
		});

		Menu clearAction = new Menu("Limpar Campos", new Menu.ActionListener() {
			@Override
			public void onclick() {
				clearTextFields();
			}
		});

		MenuCheckbox showMoedaAction = new MenuCheckbox("Exibir Moedas", true, showHideTab(panel, "Moeda"));

		MenuCheckbox showTemperaturaAction = new MenuCheckbox("Exibir Temperaturas", true,
				showHideTab(panel, "Temperatura"));
		MenuCheckbox showComprimentosAction = new MenuCheckbox("Exibir Comprimentos", true,
				showHideTab(panel, "Comprimento"));

		Menu developersAction = new Menu("Desenvolvedores", new Menu.ActionListener() {
			@Override
			public void onclick() {
				Desktop desktop = Desktop.getDesktop();

				try {
					URI url = new URI("https://github.com/Leandrosilva14");
					desktop.browse(url);
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
			}
		});

		Menu githubAction = new Menu("Repositório do Github", new Menu.ActionListener() {
			@Override
			public void onclick() {
				Desktop desktop = Desktop.getDesktop();

				try {
					URI url = new URI("https://github.com/Leandrosilva14/TrabalhosPOO");
					desktop.browse(url);
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		Menu aboutAction = new Menu("Sobre", new Menu.ActionListener() {
			@Override
			public void onclick() {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});

		fileMenu.add(exitAction);
		editMenu.add(clearAction);
		editMenu.addSeparator();
		editMenu.add(showMoedaAction);
		editMenu.add(showTemperaturaAction);
		editMenu.add(showComprimentosAction);
		helpMenu.add(developersAction);
		helpMenu.add(githubAction);
		helpMenu.add(aboutAction);
	}

	private MenuCheckbox.ActionListener showHideTab(JTabbedPane panel, String title) {
		return new MenuCheckbox.ActionListener() {
			@Override
			public void onclick() {
				int i = panel.indexOfTab(title);
				if (i != -1) {
					panel.removeTabAt(i);
				} else {
					addTab(title, panel);
				}
			}
		};
	}

	private JPanel getMoedaPanel() {
		String[] itens = { "Real", "Dolar" };

		return panelModel(itens, new SubmitAction() {

			@Override
			public ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
					JFormattedTextField field2, JLabel labelError) {
				return new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String de = (String) combo1.getSelectedItem();
						String para = (String) combo2.getSelectedItem();

						if (de == null) {
							labelError.setText("Selecione a moeda 'de'.");
						} else if (para == null) {
							labelError.setText("Selecione a moeda 'para'.");
						} else if (de.equals(para)) {
							labelError.setText(
									"<html>Selecione moedas diferentes para realizar a conversão.</html>");
						} else if (field1.getValue() == null) {
							labelError.setText("Informe o valor para a conversão.");
						} else {
							labelError.setText("");
							double result = 0;
							try {
								result = convertMoeda(
										Double.parseDouble(field1.getText().replaceAll("\\.", "").replace(",", ".")),
										de, para);
							} catch (Exception e) {
								e.printStackTrace();
							}

							field2.setValue(result);
						}
					}
				};
			}
		});
	}

	private JPanel getTemperaturaPanel() {
		String[] itens = { "Celsius", "Kelvin" };
		return panelModel(itens, new SubmitAction() {

			@Override
			public ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
					JFormattedTextField field2, JLabel labelError) {
				return new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String de = (String) combo1.getSelectedItem();
						String para = (String) combo2.getSelectedItem();

						if (de == null) {
							labelError.setText("Selecione a temperatura 'de'.");
						} else if (para == null) {
							labelError.setText("Selecione a temperatura 'para'.");
						} else if (de.equals(para)) {
							labelError.setText(
									"<html>Selecione temperaturas diferentes para realizar a conversão.</html>");
						} else if (field1.getValue() == null) {
							labelError.setText("Informe o valor para a conversão.");
						} else {
							labelError.setText("");
							double result = 0;
							try {
								result = convertTemperatura(
										Double.parseDouble(field1.getText().replaceAll("\\.", "").replace(",", ".")),
										de, para);
							} catch (Exception e) {
								e.printStackTrace();
							}

							field2.setValue(result);
						}
					}
				};
			}
		});
	}

	private JPanel getComprimentoPanel() {
		String[] itens = { "Metro", "Milimetro" };
		return panelModel(itens, new SubmitAction() {

			@Override
			public ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
					JFormattedTextField field2, JLabel labelError) {
				return new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String de = (String) combo1.getSelectedItem();
						String para = (String) combo2.getSelectedItem();

						if (de == null) {
							labelError.setText("Selecione a medida 'de'.");
						} else if (para == null) {
							labelError.setText("Selecione a medida 'para'.");
						} else if (de.equals(para)) {
							labelError.setText(
									"<html>Selecione medidas diferentes para realizar a conversão.</html>");
						} else if (field1.getValue() == null) {
							labelError.setText("Informe o valor para a conversão.");
						} else {
							labelError.setText("");
							double result = 0;
							try {
								result = convertComprimento(
										Double.parseDouble(field1.getText().replaceAll("\\.", "").replace(",", ".")),
										de, para);
							} catch (Exception e) {
								e.printStackTrace();
							}

							field2.setValue(result);
						}
					}
				};
			}
		});
	}

	private double convertMoeda(double value, String from, String to) {
		double convertedValue = 0;

		switch (from) {
		case "Dolar":
			if (to.equalsIgnoreCase("real")) {
				convertedValue = value * 3.99;
			}
			break;
		case "Real":
			if (to.equalsIgnoreCase("dolar")) {
				convertedValue = value / 3.99;
			}
			break;
		default:
			break;
		}

		return convertedValue;
	}

	private double convertTemperatura(double value, String from, String to) {
		double convertedValue = 0;

		switch (from) {
		case "Celsius":
			if (to.equalsIgnoreCase("kelvin")) {
				convertedValue = value + 272.15;
			}
			break;
		case "Kelvin":
			if (to.equalsIgnoreCase("celsius")) {
				convertedValue = value - 272.15;
			}
			break;
		default:
			break;
		}

		return convertedValue;
	}

	private double convertComprimento(double value, String from, String to) {
		double convertedValue = 0;

		switch (from) {
		case "Metro":
			if (to.equalsIgnoreCase("milimetro")) {
				convertedValue = value * 1000;
			}
			break;
		case "Milimetro":
			if (to.equalsIgnoreCase("metro")) {
				convertedValue = value / 1000;
			}
			break;
		default:
			break;
		}

		return convertedValue;
	}

	private interface SubmitAction {
		ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
				JFormattedTextField field2, JLabel labelError);
	}

	private JPanel panelModel(String[] itens, SubmitAction submitAction) {
		JPanel panel = new JPanel(null);
		JLabel labelError = new JLabel();
		labelError.setForeground(Color.RED);

		JLabel label1 = new JLabel("De:");
		NumberFormat fieldFormat = NumberFormat.getNumberInstance();
		fieldFormat.setMinimumFractionDigits(2);
		JFormattedTextField field1 = new JFormattedTextField(fieldFormat);
		tfList.add(field1);

		JComboBox<String> combo1 = new JComboBox<String>(itens);
		combo1.setSelectedIndex(-1);

		JLabel label2 = new JLabel("Para:");
		JFormattedTextField field2 = new JFormattedTextField(fieldFormat);
		field2.setEditable(false);
		tfList.add(field2);

		JComboBox<String> combo2 = new JComboBox<String>(itens);
		combo2.setSelectedIndex(-1);

		JButton submit = new JButton("Converter");
		submit.addActionListener(submitAction.action(combo1, combo2, field1, field2, labelError));

		label1.setBounds(20, 20, 50, 30);
		combo1.setBounds(80, 20, 140, 30);
		label2.setBounds(300, 20, 50, 30);
		combo2.setBounds(360, 20, 140, 30);
		field1.setBounds(80, 60, 140, 30);
		field2.setBounds(360, 60, 140, 30);
		submit.setBounds(380, 100, 120, 30);
		labelError.setBounds(80, 140, 400, 50);

		panel.add(label1);
		panel.add(combo1);
		panel.add(label2);
		panel.add(combo2);

		panel.add(field1);
		panel.add(field2);

		panel.add(submit);

		panel.add(labelError);

		return panel;
	}

	private void addTab(String title, JTabbedPane panel) {
		String[] tabs = { "Moeda", "Temperatura", "Comprimento" };
		JPanel[] panels = { getMoedaPanel(), getTemperaturaPanel(), getComprimentoPanel() };

		for (int i = 0; i < tabs.length; i++) {
			String tab = tabs[i];

			if (tab.equals(title)) {
				panel.addTab(tab, null, panels[i], "Conversor de " + tab);
			}
		}
	}

	private void clearTextFields() {
		for (JFormattedTextField tf : tfList) {
			tf.setText("");
		}
	}

}
