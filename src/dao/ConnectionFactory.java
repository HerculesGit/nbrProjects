package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para criar uma conexao com o banco de dados que está na pasta badabase
 * */
public class ConnectionFactory {
	
	private String PATH = "database";
	private final String NOME = "dados.db";
	public final static String USUARIO = "usuario";
	public final static String MATERIAL = "material";
	public final static String POSTAGEM = "postagem";
	public final static String ADQUIRIDO = "adquirido";
	
	/**
	 * Método usado para criar a conexao
	 * 
	 * */
	public Connection getConnection() throws SQLException {
		
		// descobrir sistema operacional
		String systemName = System.getProperty("os.name");
		
		if (systemName.equalsIgnoreCase("linux")) PATH +="/"; 	// para linux
		else PATH+="\\";										// para windows
		
		
		return DriverManager.getConnection("jdbc:sqlite:"+PATH+""+NOME);
	
	}
	
}


