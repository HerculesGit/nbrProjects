package model;

public class Material {
	
	private int idMaterial;
	private String descricao;
	private String filtro;
	private String tipo;
	private boolean foipego;
	
	public Material() {
		this.idMaterial = 0;
		this.descricao = "";
		this.filtro = "";
		this.tipo = "";
		this.foipego = false;
	}

	public Material(String descricao, String filtro, String tipo, boolean foipego) {
		this.idMaterial = 0;
		this.descricao = descricao;
		this.filtro = filtro;
		this.tipo = tipo;
		this.foipego = foipego;
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

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isFoipego() {
		return foipego;
	}

	public void setFoipego(boolean foipego) {
		this.foipego = foipego;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("idMaterial: ").append(idMaterial)
				.append(" Descricao:").append(descricao)
				.append(" filtro:").append(filtro)
				.append(" tipo:").append(filtro)
				.append("foipego: ").append(foipego)
				.toString();
	}
	
}
