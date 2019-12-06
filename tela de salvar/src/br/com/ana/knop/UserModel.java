package br.com.ana.knop;


import java.util.ArrayList;
import java.util.List;




public class UserModel extends Usuario implements Subject {
    private List<Observer> observers;

    public UserModel() {
        observers = new ArrayList<Observer>();
    }

    public void newRegister() {
        this.id_usu = 0;
        this.nome = "";
        this.sobrenome = "";
        this.email = "";
        notifyObservers();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override

    public void notifyObservers() {
        for (Observer o : this.observers) {
            o.update(this, this);
        }
    }

    public void save() throws Exception {
        if (this.nome == null || this.nome.isEmpty()) {
            throw new Exception("Nome invalido");
        }
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = new Usuario();
        if (this.getId() == 0) {
            user.setNome(nome);
            user.setSobrenome(sobrenome);
            user.setEmail(email);
         
            userDAO.Insert(user);
        } else {
            user = userDAO.getById(this.id_usu);
            user.setId(this.id_usu);
            user.setNome(nome);
            user.setSobrenome(sobrenome);
            user.setEmail(email);
            userDAO.update(user);
        }
    }

}