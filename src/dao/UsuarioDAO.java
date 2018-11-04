package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;


public class UsuarioDAO implements UsuarioDAOI{
	
	private Connection connection;

	// nome da tabela e nome das colunas
	private final String TABELA_USUARIO = ConnectionFactory.USUARIO;
	public static final String ID_USUARIO = "idUsuario";
	private final String NOME = "nome";
	public static final String MATRICULA = "matricula";
	private final String CURSO = "curso";
	private final String SENHA = "senha";
	
	public UsuarioDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		
		} catch (SQLException e) {
			new Exception("Erro ao conectar em UsuarioDAO: " + e.getMessage());
		}
	}
	
	
	/**
	 * @param user - Usuario com todos os atributos (menos id)
	 * @return boolean
	 * @exception Exception - Aviso de erro
	 * */
	@Override
	public boolean inserir(Usuario user) {
		//insert into usuario (matricula, nome, curso,senha) values ('2018','Hércules Silva','LCC','123');
		
		String sql = "INSERT INTO " + TABELA_USUARIO + "("+MATRICULA+","+NOME+","+CURSO+","+SENHA+")"
				+ " VALUES (?,?,?,?);";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, user.getMatricula());
			pstmt.setString(2, user.getNome());
			pstmt.setString(3, user.getCurso());
			pstmt.setString(4, user.getSenha());

			// executuar o script sql
			pstmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			new Exception("Erro ao inserir usuario: "+e.getMessage());
		}	
		return false;
	}
	
	/**
	 * @param user - Usuario que quer alterar, passe com todos os parametros que deseja alterar
	 * Lembre-se de que ele serah alterado pelo que deve conter nesse usuario passado como parametro
	 * @return boolean
	 * @exception Exception - aviso de erro
	 * */
	@Override
	public boolean alterar(Usuario user) {
		if (user.getId()<1) {
			new Exception("Erro alterar usuario \n"
					+ "Provavelmente voceh esqueceu de informar o id ou informou um menor que 0 para a alteracao desse registro de usuario\n"
					+ " informe o id no parametro").printStackTrace();
			
			System.out.println("Menor que 1");
			return false;
		} else {
			String sql = "UPDATE " + TABELA_USUARIO + " SET " + MATRICULA + "=?," + NOME + "=?," + CURSO + "=?," + SENHA+"=?"
					+ " WHERE "+ID_USUARIO+"=?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

				pstmt.setString(1, user.getMatricula()); 	// matricula
				pstmt.setString(2, user.getNome());			// nome
				pstmt.setString(3, user.getCurso());		// curso
				pstmt.setString(4, user.getSenha());		// senha
				pstmt.setInt(5, user.getId()); 				// id continua sendo o mesmo

				pstmt.executeUpdate();
				
				return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				new Exception("Erro ao alterar usuario: "+e.getMessage());
			}
		}		
		return false;
	}
	
	/**
	 * @param user - Esse usuario precisa conter apenas o id ou a matricula<br>
	 * Ele se o id for <=0 ele procura pela matricula, se matricula estiver, ele lança um erro e retorna false
	 * @return boolean
	 * @exception Exception - aviso de erro
	 * */
	@Override
	public boolean remover(Usuario user) {
		
		String sql = "DELETE FROM " + TABELA_USUARIO + " WHERE "+ID_USUARIO+"=? ;";
		if (user.getId() < 1) {
			user = usuario(user.getMatricula());
			System.out.println(">>>"+user.getMatricula());
			
			if (user.getMatricula().length() == 0) {
				new Exception("Erro aqui ").printStackTrace();
				System.out.println("Erro");
				return false;
			}
		}
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setInt(1, user.getId());
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			 new Exception("Erro ao tentar remover usuario: " + e.getMessage());
		}
		
		return false;	
	}
	
	/**
	 * Lista todos os usuarios cadastrados
	 * @return List<Usuario>
	 * @exception Exception - aviso de erro
	 * */
	@Override
	public List<Usuario> lista(){
		List<Usuario> lista = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM " + TABELA_USUARIO + ";";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			
			// sempre que tiver um proximo faca a leitura
			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt(ID_USUARIO));
				user.setMatricula(rs.getString(MATRICULA));
				user.setNome(rs.getString(NOME));
				user.setCurso(rs.getString(CURSO));
				user.setSenha(rs.getString(SENHA));
				
				lista.add(user);
			}
			rs.close();			// fechando rs
			return lista;
		} catch (SQLException e) {
			new Exception("Erro ao listar usuarios: " + e.getMessage());
		}
		return lista;
	}
	
	/**
	 * Encontra usuario com a matricula informada
	 * @param matricula - String
	 * @return null - se nao encontrou 
	 * @return Usuario - com o id tambem
	 * */
	@Override
	public Usuario usuario(String matricula) {
		Usuario user = null;
		String sql = "SELECT * FROM " + TABELA_USUARIO + ""
				+ "WHERE "+MATRICULA+"=? ;";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			
			// se encontrar esse usuario
			if (rs.next()) {
				user = new Usuario();
				user.setId(rs.getInt(ID_USUARIO));
				user.setMatricula(rs.getString(MATRICULA));
				user.setNome(rs.getString(NOME));
				user.setCurso(rs.getString(CURSO));
				user.setSenha(rs.getString(SENHA));
			}
			rs.close();			// fechando rs
			return user;
		} catch (SQLException e) {
			new Exception("Erro ao recuperar usuario "+matricula+": "+ e.getMessage());
		}
		
		return user;
	}
	
	/**
	 * Encontra usuario com o id informado
	 * @param idUsuario - int
	 * @return null - se nao encontrou 
	 * @return Usuario - com o id tambem
	 * */
	@Override
	public Usuario usuario(int idUsuario) {
		Usuario user = null;
		String sql = "SELECT * FROM " + TABELA_USUARIO + ""
				+ "WHERE "+ID_USUARIO+"=? ;";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			
			// se encontrar esse usuario
			if (rs.next()) {
				user = new Usuario();
				user.setId(rs.getInt(ID_USUARIO));
				user.setMatricula(rs.getString(MATRICULA));
				user.setNome(rs.getString(NOME));
				user.setCurso(rs.getString(CURSO));
				user.setSenha(rs.getString(SENHA));
			}
			rs.close();			// fechando rs
			return user;
		} catch (SQLException e) {
			new Exception("Erro ao recuperar usuario: " + e.getMessage());
		}
		
		return user;
	}

	
}
