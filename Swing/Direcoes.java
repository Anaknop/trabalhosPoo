package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Direcoes extends JFrame {
    private static final long serialVersionUID = 1L;

    public Direcoes() {
        setTitle("Direcoes");
        setSize(350, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout();
    }

    private JPanel criarPanel(Color color, String texto) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(new JLabel(texto));
        return panel;
    }

    private void setLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        JPanel panelChecks = new JPanel();
        panelChecks.setLayout(null);
        panelChecks.setBackground(Color.WHITE);

        JCheckBox checkNorte = new JCheckBox("Norte");
        checkNorte.setSelected(true);
        checkNorte.setBounds(0, 50, 140, 30);

        JCheckBox checkSul = new JCheckBox("Sul");
        checkSul.setSelected(true);
        checkSul.setBounds(0, 80, 140, 30);

        JCheckBox checkLeste = new JCheckBox("Leste");
        checkLeste.setSelected(true);
        checkLeste.setBounds(0, 110, 140, 30);

        JCheckBox checkOeste = new JCheckBox("Oeste");
        checkOeste.setSelected(true);
        checkOeste.setBounds(0, 140, 140, 30);

        JCheckBox checkCentro = new JCheckBox("Centro");
        checkCentro.setSelected(true);
        checkCentro.setBounds(0, 170, 140, 30);

        panelChecks.add(checkNorte);
        panelChecks.add(checkSul);
        panelChecks.add(checkLeste);
        panelChecks.add(checkOeste);
        panelChecks.add(checkCentro);

        JPanel panelDirecoes = new JPanel();
        panelDirecoes.setLayout(new BorderLayout());

        JPanel norte = criarPanel(new Color(21, 163, 255), "Norte");
        JPanel leste = criarPanel(new Color(184, 114, 64), "Leste");
        JPanel oeste = criarPanel(new Color(248, 102, 5), "Oeste");
        JPanel sul = criarPanel(new Color(247, 54, 48), "Sul");
        JPanel centro = criarPanel(Color.WHITE, "Centro");

        panelDirecoes.add(norte, BorderLayout.NORTH);
        removeComponentListener(checkNorte, norte);
        panelDirecoes.add(sul, BorderLayout.SOUTH);
        removeComponentListener(checkSul, sul);
        panelDirecoes.add(leste, BorderLayout.EAST);
        removeComponentListener(checkLeste, leste);
        panelDirecoes.add(oeste, BorderLayout.WEST);
        removeComponentListener(checkOeste, oeste);
        panelDirecoes.add(centro, BorderLayout.CENTER);
        removeComponentListener(checkCentro, centro);

        mainPanel.add(panelChecks);
        mainPanel.add(panelDirecoes);

        add(mainPanel);
    }
    private void removeComponentListener(JCheckBox check, JPanel component) {
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Esse campo esta selecionado? " + check.isSelected());
                component.setVisible(check.isSelected());
            }
        });
    }
}