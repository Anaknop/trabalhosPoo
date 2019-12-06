package br.com.ana.knop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;

public class UserView extends JFrame implements Observer {
    private UserModel model;
    private UserControl control;
    private JTextField idField;
    private JTextField usernameField;
    private JTextField nameField;
    private JTextField SobrenomeField;
    private JTextField emailField;
   
    private JButton saveButton;
  
    private JLabel status;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;


    public UserView() {
    	setResizable(false);
        setSize(400, 280);
        setTitle("Cadastro de usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildLayout();
    }

    public void setModel(UserModel model) {
        this.model = model;
    }

    public void setControl(UserControl control) {
        this.control = control;
    }

    private void buildLayout() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 0, 20)
                , BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Detalhes do usuário")
                        , BorderFactory.createEmptyBorder(10, 10, 10, 10))));
        idField = new JTextField(2);
        idField.setBounds(91, 51, 22, 20);
        idField.setEnabled(false);
        usernameField = new JTextField(15);
        usernameField.setBounds(164, 87, 126, 20);
        emailField = new JTextField(24);
        emailField.setBounds(91, 145, 198, 20);
        panel.setLayout(null);

      

        JLabel label = new JLabel("Codigo", JLabel.RIGHT);
        label.setBounds(41, 53, 45, 16);
        label.setPreferredSize(new Dimension(45, 16));
        panel.add(label);
        panel.add(idField);

        label_1 = new JLabel("Nome",JLabel.RIGHT);
        label_1.setBounds(78, 89, 60, 16);
        label_1.setPreferredSize(new Dimension(60,16));
        panel.add(label_1);
        panel.add(usernameField);
        SobrenomeField = new JTextField(20);
        SobrenomeField.setBounds(123, 114, 166, 20);
        panel.add(SobrenomeField);

        label_2 = new JLabel("Sobrenome",JLabel.RIGHT);
        label_2.setBounds(53, 116, 60, 16);
        label_2.setPreferredSize(new Dimension(60,16));
        panel.add(label_2);

        label_3 = new JLabel("Email",JLabel.RIGHT);
        label_3.setBounds(41, 147, 43, 16);
        label_3.setPreferredSize(new Dimension(43,16));
        panel.add(label_3);
        panel.add(emailField);

       


        label_4 = new JLabel();
        label_4.setBounds(51, 109, 160, 20);
        label_4.setPreferredSize(new Dimension(160,20));
        panel.add(label_4);
    

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
        status = new JLabel("Cadastre um novo usuario");
        statusPanel.add(status);

        rootPanel.add(statusPanel, BorderLayout.SOUTH);
        rootPanel.add(panel, BorderLayout.CENTER);
        
        
        
                saveButton = new JButton("Salvar");
                saveButton.setBounds(164, 193, 63, 23);
                saveButton.setHorizontalAlignment(SwingConstants.LEADING);
                saveButton.setBackground(Color.LIGHT_GRAY);
                saveButton.setToolTipText("Salvar as alteracoes");
                saveButton.setEnabled(true);
                saveButton.addActionListener(e -> save());
                
                 panel.add(saveButton);

        getContentPane().add(rootPanel);
    }

    private void showData() {
        idField.setText(Integer.toString(this.model.getId()));
        usernameField.setText(this.model.nome);
        nameField.setText(this.model.sobrenome);
        emailField.setText(this.model.email);

    }

    public void edit() {
        idField.setEnabled(true);
        saveButton.setEnabled(true);
  
    }

    public void save() {
        this.control.save();
        idField.setEnabled(false);
    }


    public void _new() {
        this.control._new();
        idField.setEnabled(false);
    }

  

    public void setMessageStatusBar(String status) {
        this.status.setText(status);
    }

    @Override
    public void update(Subject s, Object o) {
        this.model = (UserModel) o;
        showData();
    }

    public String getUsername() {
        return this.usernameField.getText();
    }

    public String getName() {
        return this.nameField.getText();
    }

    public String getEmail() {
        return this.emailField.getText();
    }

    public String getSobrenome() {
        return this.SobrenomeField.getText();
    }

 
}