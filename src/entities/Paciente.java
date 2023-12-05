package entities;

import java.time.LocalDate;

public class Paciente extends Persona {
	private String foto;
	private LocalDate dataNascimento;
	private String sexo;
	private String formaPagamento;

	public Paciente(String nome, String endereco, String telefone, String foto, LocalDate dataNascimento, String sexo,
			String formaPagamento) {
		super(nome, endereco, telefone);
		this.foto = foto;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.formaPagamento = formaPagamento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
