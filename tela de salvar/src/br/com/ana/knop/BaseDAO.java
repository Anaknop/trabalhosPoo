package br.com.ana.knop;

import java.sql.Connection;


public abstract class BaseDAO {
	
	
	public Connection getConnection() {
		return Conexao.getInstance().getConnection();
	}

}
