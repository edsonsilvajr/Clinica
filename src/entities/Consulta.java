package entities;

import java.time.LocalDate;

public class Consulta {
	private Paciente paciente;
	private Medico medico;
	private LocalDate horarioConsulta;

	public Consulta(Paciente paciente, Medico medico, LocalDate horarioConsulta) {
		this.paciente = paciente;
		this.medico = medico;
		this.horarioConsulta = horarioConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalDate getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(LocalDate horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}
}
