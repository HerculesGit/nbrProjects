package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAOI {
	
	/**
	 * @param user - Um usuario com: nome, matricula, etc. Menos com id
	 * @return boolean - Informando se a operacao foi efetuada com sucesso
	 * */
	public boolean inserir(Usuario user);
	
	/**
	 * @param user - O usuario mandado como parametro deve conter o id para que o banco saiba qual usar
	 * @return boolean - Informando se a operacao foi efetuada com sucesso
	 * */
	public boolean alterar(Usuario user); 
	
	/**
	 * @param user - O usuario mandado como parametro deve conter o id ou matricula para que o banco saiba deletar
	 * @return boolean - Informando se a operacao foi efetuada com sucesso
	 * */
	public boolean remover(Usuario user);
	
	
	/**
	 * Vai listar todos os usuarios cadastrados
	 * @return List<Usuario>- Uma lista com todos os usuarios
	 * */
	public List<Usuario> lista();
	
	/**
	 * @param matricula - pesquisa pela matricula informada
	 * @return usuario | null - Retorna o usuario com todos os atributos okay's ou usuario=null
	 * */
	public Usuario usuario(String matricula);
	
	
	/**
	 * Pesquisa o usuario pelo id
	 * @param idUsuario - int
	 * @return null - se nao encontrou 
	 * @return Usuario - com o id tambem
	 * */
	public Usuario usuario(int idUsuario);
	
	
	
}
