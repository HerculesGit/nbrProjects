package model;

public class Postagem {
	private String descricao;
	private int idUsuario;
	private int idMaterial;

	/**
	 * Construtor sem parametro
	 * */ 
	public Postagem() {

		this.idMaterial = 0;
		this.idUsuario = 0;
		this.descricao = "";
	}

	/**
	 * Construtor com parametro
	 * */ 
	public Postagem(String descricao) {
		this.idMaterial = 0;
		this.idUsuario = 0;
		this.descricao = descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	@Override
	public String toString() {
		return "Postagem [descricao=" + descricao + ", idUsuario=" + idUsuario + ", idMaterial=" + idMaterial + "]";
	}

	
	
}
