package main;

import java.sql.Connection;
import java.util.List;

import dao.BancoDados;
import dao.PacienteDAO;
import entities.Paciente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Paciente paciente = new Paciente("Edson", "Rua P", "42902932", "foto", "01/05/1997", "Masc", "Dinheiro");
			Connection conn = BancoDados.conectar();
			new PacienteDAO(conn).cadastrarPaciente(paciente);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection conn = BancoDados.conectar();
			List<Paciente> pacientes = new PacienteDAO(conn).listarPacientes();
			for (Paciente paciente : pacientes) {
				System.out.println(paciente.getNome());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
