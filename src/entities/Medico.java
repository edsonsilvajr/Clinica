package entities;

public class Medico extends Persona {
	private String crm;
	private Especialidade especialidade;

	public Medico(String nome, String endereco, String telefone, String crm, Especialidade especialidade) {
		super(nome, endereco, telefone);
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " - CRM: " + this.getCrm();
	}

}
