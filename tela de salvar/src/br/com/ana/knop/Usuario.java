package br.com.ana.knop;

public class Usuario {
	protected int id_usu;
	protected String nome;
	protected String sobrenome;
	protected String email;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getId() {
		return id_usu;
	}
	public void setId(int id) {
		this.id_usu = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}