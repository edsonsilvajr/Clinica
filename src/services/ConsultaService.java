package services;

import java.sql.Connection;
import java.util.List;

import dao.BancoDados;
import dao.ConsultaDAO;
import entities.Consulta;

public class ConsultaService {
	public ConsultaService() {
		
	}
	
	public void agendarConsulta(Consulta consulta) throws Exception {
		Connection conn = BancoDados.conectar();
		new ConsultaDAO(conn).agendarConsulta(consulta);
	}
	
	public List<Consulta> listarConsultasPorPaciente(int codigoPaciente)  throws Exception{
    	Connection conn = BancoDados.conectar();
        List<Consulta> consultas = new ConsultaDAO(conn).listarConsultasPorPaciente(codigoPaciente);
        return consultas;
    }
}
