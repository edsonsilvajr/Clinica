package entities;

import java.time.LocalDate;

public class Paciente extends Persona{
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
	
	
}
