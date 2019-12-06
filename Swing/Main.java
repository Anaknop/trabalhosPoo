package Swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                login.setVisible(true);

                login.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        Direcoes direcoes = new Direcoes();
                        direcoes.setVisible(true);
                    }
                });
            }
        });

    }
}