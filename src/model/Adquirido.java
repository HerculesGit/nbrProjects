package model;

public class Adquirido {

	private int idUsuario;
	private int idMaterial;
	private String descricao;

	/**
	 * Construtor sem parametros
	 * */ 
	public Adquirido() {
		this.idMaterial = 0;
		this.idUsuario = 0;
		this.descricao = "";
	}

	/**
	 * Construtor com parametro
	 * */ 
	public Adquirido(String descricao) {
		this.idMaterial = 0;
		this.idUsuario = 0;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Adquirido [idUsuario=" + idUsuario + ", idMaterial=" + idMaterial + ", descricao=" + descricao + "]";
	}
	
}
