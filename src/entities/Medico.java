package entities;

public class Medico extends Persona {
	private int crm;
	private Especialidade especialidade;
	
	public Medico(String nome, String endereco, String telefone, int crm, Especialidade especialidade) {
		super(nome, endereco, telefone);
		this.crm = crm;
		this.especialidade = especialidade;
	}
	
	
}
