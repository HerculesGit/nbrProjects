package model;

public class Usuario {
	
	private int id;
	private String nome;
	private String matricula;
	private String curso;
	private String senha;
	
	public Usuario() {
		this.id = 0;
		this.nome = "";
		this.matricula = "";
		this.curso = "";
	}
	
	public Usuario(String nome, String matricula, String curso, String senha) {
		this.id = 0;
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.senha = senha;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		
		return new StringBuilder()
				.append("id:").append(id)
				.append(" matricula:").append(matricula)
				.append(" nome:").append(nome)
				.append(" curso:").append(curso)
				.append(" senha:").append(senha)
				.toString();
	}
	
}
