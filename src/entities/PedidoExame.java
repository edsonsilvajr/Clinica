package entities;

import java.time.LocalDate;

public class PedidoExame {
	private Exame exame;
    private Paciente paciente;
    private String crmMedico;
    private LocalDate dataRealizacao;
    private double valorPago;
    
	public PedidoExame(Exame exame, Paciente paciente, String crmMedico, LocalDate dataRealizacao, double valorPago) {
		this.exame = exame;
		this.paciente = paciente;
		this.crmMedico = crmMedico;
		this.dataRealizacao = dataRealizacao;
		this.valorPago = valorPago;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getCrmMedico() {
		return crmMedico;
	}

	public void setCrmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}

	public LocalDate getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(LocalDate dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
}
