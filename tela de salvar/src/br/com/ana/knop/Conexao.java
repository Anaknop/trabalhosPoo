package br.com.ana.knop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Conexao instance;

	private static String usuario = "root";
	private static String senha = "root";
	
	private Conexao() {}

	public static Conexao getInstance() {
		if(instance == null) {
			instance = new Conexao();
		}
		return instance;
	}
	
	public Connection getConnection(){
			Connection conn;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_tarefa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
						usuario, 
						senha);
				
				return conn;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
