package entities;

public abstract class Persona {
	private String nome;
	private String endereco;
	private String telefone;
	public Persona(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	
}
