package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Material;


public class MaterialDAO {
	
	private Connection connection;

	// nome da tabela e nome das colunas 
	private final String TABELA_MATERIAL = ConnectionFactory.MATERIAL;
	public static final String ID_MATERIAL= " idMaterial";
	private final String DESCRICAO = "descricao";
	private final String FILTRO = "filtro";
	private final String TIPO = "tipo";
	private final String FOI_PEGO = "foipego";
	
	public MaterialDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		
		} catch (SQLException e) {
			new Exception("Erro ao connectar em Material" + e.getMessage());
		}
	}
	
	
	/**
	 * @param material - Material com todos os atributos (menos id)
	 * @return boolean
	 * @exception Exception - Aviso de erro
	 * */
	public boolean inserir(Material material) {
		String sql = "INSERT INTO " + TABELA_MATERIAL + "("+DESCRICAO+","+FILTRO+","+TIPO+","+FOI_PEGO+")"
				+ " VALUES (?,?,?,?);";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, material.getDescricao());
			pstmt.setString(2, material.getFiltro());
			pstmt.setString(3, material.getTipo());
			
			int foi_pego = 0;					//nao foi pego
			if(material.isFoipego() == true)
				foi_pego = 1;
			
			pstmt.setInt(4, foi_pego);

			// executuar o script sql
			pstmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			new Exception("Erro ao inserir Material: "+e.getMessage());
		}	
		return false;
	}
	
	/**
	 * @param material - Material que quer alterar, passe com todos os parametros que deseja alterar
	 * Lembre-se de que ele serah alterado pelo que deve conter nesse Material passado como parametro
	 * @return boolean
	 * @exception Exception - Aviso de erro
	 * */
	public boolean alterar(Material material) {
		if (material.getIdMaterial()<1) {
			new Exception("Erro alterar Material \n"
					+ "Provavelmente voceh esqueceu de informar o id para a alteracao desse registro de material\n"
					+ " informe o id no parametro").printStackTrace();
			return false;
		} else {
			String sql = "UPDADE " + TABELA_MATERIAL + " SET " + DESCRICAO+ "=?," + FILTRO+ "=?," + TIPO+ "=?" + FOI_PEGO+"=?"
					+ " WHERE "+ID_MATERIAL+"=?";
			
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, material.getDescricao());
				pstmt.setString(2, material.getFiltro());
				pstmt.setString(3, material.getTipo());
				
				int foi_pego = 0;					//nao foi pego
				if(material.isFoipego() == true)
					foi_pego = 1;
				
				pstmt.setInt(4, foi_pego);
				pstmt.setInt(5, material.getIdMaterial());
				
				pstmt.executeUpdate();
				
				return true;
			} catch (SQLException e) {
				new Exception("Erro ao alterar Material: "+e.getMessage());
			}
		}		
		return false;
	}
	
	/**
	 * @param material - Remove pelo id
	 * @return boolean
	 * @exception Exception - aviso de erro
	 * */
	public boolean remover(Material material) {
		String sql = "DELETE FROM " + TABELA_MATERIAL + " WHERE "+ID_MATERIAL+"=? ;";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, material.getIdMaterial());
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			 new Exception("Erro ao tentar remover Material : " + e.getMessage());
		}
		
		return false;	
	}
	
	/**
	 * Lista todos os materiais cadastrados
	 * @return List<Material>
	 * @exception Exception - aviso de erro
	 * */
	public List<Material> lista(){
		List<Material> lista = new ArrayList<Material>();
		
		String sql = "SELECT * FROM " + TABELA_MATERIAL + ";";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			
			// sempre que tiver um proximo faca a leitura
			while (rs.next()) {
				Material material = new Material();
				material.setIdMaterial(rs.getInt(ID_MATERIAL));
				material.setDescricao(rs.getString(DESCRICAO));
				material.setFiltro(rs.getString(FILTRO));
				material.setTipo(rs.getString(TIPO));
				

				int foi_pego = rs.getInt(FOI_PEGO);
				
				if(foi_pego > 0) {
					material.setFoipego(true);
				} else {
					material.setFoipego(false);
				}
				lista.add(material);
			}
			rs.close();			// fechando rs
			return lista;
		} catch (SQLException e) {
			new Exception("Erro ao listar Materiais: " + e.getMessage());
		}
		return lista;
	}
	
}
