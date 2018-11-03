package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para criar uma conexao com o banco de dados que está na pasta badabase
 * */
public class ConnectionFactory {
	private final String NOME = "dados.db";
	public static String USUARIO = "usuario";
	public static String MATERIAL = "material";
	public static String POSTAGEM = "postagem";
	public static String ADQUIRIDO = "adquirido";
	
	/**
	 * Método usado para criar a conexao
	 * 
	 * */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:database\\"+NOME);
	
	}
	

	public boolean criaBancoDeDados() {
		
		
		return false;
	}
	
}


