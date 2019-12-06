package br.com.ana.knop;



public class UserControl {
    private UserView view;
    private UserModel model;

    public UserControl(UserView view, UserModel model) {
        this.model = model;
        this.view = view;
        model.attach(view);
        view.setModel(model);
        view.setControl(this);
    }

    public void showScreen() {
        view.show();
        model.notifyObservers();
    }



    public void _new() {
        model.newRegister();
    
        view.setMessageStatusBar("Usuário Novo");
    }

    public void save() {
        this.model.setNome(this.view.getUsername());
        this.model.setSobrenome(this.view.getSobrenome());
        this.model.setEmail(this.view.getEmail());
        try {
            this.model.save();
            this.view.setMessageStatusBar("Usuário salvo");
         
        } catch (Exception e) {
            e.printStackTrace();
            view.setMessageStatusBar("Error: " + e.getMessage());
        }
    }
}