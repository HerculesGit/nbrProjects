package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Adquirido;
import model.Usuario;

public class AdquiridoDAO {

	private Connection connection;
	// nome da tabela e nome das colunas 
	private final String TABELA_ADQUIRIDO= ConnectionFactory.ADQUIRIDO;
	private final String ID_MATERIAL= MaterialDAO.ID_MATERIAL;
	private final String ID_USUARIO = UsuarioDAO.ID_USUARIO;
		
	
	public AdquiridoDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		
		} catch (SQLException e) {
			new Exception("Erro ao connectar em Material" + e.getMessage());
		}
	}
	
	/**
	 * @param idUsuario - id do usuario 
	 * @param idMaterial - id do material
	 * */
	public boolean adquirir(int idUsuario, int idMaterial) {
		String sql = "INSERT INTO " + TABELA_ADQUIRIDO + "("+ID_USUARIO+","+ID_MATERIAL+")"
				+ " VALUES (?,?);";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, idUsuario);
			pstmt.setInt(2, idMaterial);

			// executuar o script sql
			pstmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			new Exception("Erro ao adquirir Material em Adquirir: "+e.getMessage());
		}	
		return false;
	}
	
	/**
	 * @param idUsuario - informe o id do usuario 
	 * @param idMaterial - informe o id do material
	 * Precisa ter os dois id's
	 * */
	public boolean alterarAquisicao(int idUsuario, int idMaterial) {
		String sql = "UPDADE " + TABELA_ADQUIRIDO + " SET " + ID_USUARIO+"=?," + ID_MATERIAL
				+ " WHERE "+ID_USUARIO+"=? AND "+ID_MATERIAL+"=?";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, idUsuario);
			pstmt.setInt(2, idMaterial);			
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			new Exception("Erro ao alterar Adquirir: "+e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * Remove uma quisicao(adquirir) feita pelo usuario
	 * */
	public boolean removerUmaAquisicao(int idUsuario, int idMaterial) {
		String sql = "DELETE FROM " + TABELA_ADQUIRIDO +
				" WHERE "+ID_USUARIO+"=? AND "+ID_MATERIAL+"=? ;";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1,idUsuario);
			pstmt.setInt(2,idMaterial);
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			 new Exception("Erro ao tentar remover uma aquisicao do usuario: " + e.getMessage());
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * */ 
	public boolean removerTodasAquisicoesUsuario(Usuario user) {
		
		return false;
	}
	
	
	/**
	 * @param user - Pesquisa pelo id ou pela matricula
	 * 
	 * */
	public List<Adquirido> listarPostagemDe(Usuario user){
		List<Adquirido> lista = new ArrayList<Adquirido>();
		
		
		
		return lista;
	}
	
	public List<Adquirido> listar(){
		return null;
		
	}
	
	
	
}
