package services;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.PacienteDAO;
import entities.Paciente;

public class PacienteService {
	public PacienteService() {
		
	}
	
	public void cadastrarPaciente(Paciente paciente) throws Exception {
		Connection conn = BancoDados.conectar();
		new PacienteDAO(conn).cadastrarPaciente(paciente);
	}
	
	public List<Paciente> listarPacientes() throws Exception {
		Connection conn = BancoDados.conectar();
		List<Paciente> pacientes = new PacienteDAO(conn).listarPacientes();
		return pacientes;
	}

}
