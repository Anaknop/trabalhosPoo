package br.com.ana.knop;


public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        UserControl control = new UserControl(new UserView(), model);
        control.showScreen();
    }
}