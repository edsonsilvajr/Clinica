package entities;


public class Consulta {
	private int codigo;
	private int pacienteId;
	private String medicoCrm;
	private String horarioConsulta;

	public Consulta(int pacienteId, String medicoCrm, String horarioConsulta) {
		this.setPacienteId(pacienteId);
		this.setMedicoCrm(medicoCrm);
		this.horarioConsulta = horarioConsulta;
	}
	
	public Consulta(int codigo, int pacienteId, String medicoCrm, String horarioConsulta) {
		this.setCodigo(codigo);
		this.setPacienteId(pacienteId);
		this.setMedicoCrm(medicoCrm);
		this.horarioConsulta = horarioConsulta;
	}

	public String getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(String horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}

	public String getMedicoCrm() {
		return medicoCrm;
	}

	public void setMedicoCrm(String medicoCrm) {
		this.medicoCrm = medicoCrm;
	}
}
