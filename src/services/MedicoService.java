package services;

import java.sql.Connection;
import java.util.List;

import dao.BancoDados;
import dao.MedicoDAO;
import entities.Especialidade;
import entities.Medico;

public class MedicoService {
	public MedicoService() {
    	
    }

    public List<Medico> listarMedicos()  throws Exception{
    	Connection conn = BancoDados.conectar();
        List<Medico> medicos = new MedicoDAO(conn).listarMedicos();
        return medicos;
    }

    public void cadastrarMedico(Medico medico) throws Exception {
    	Connection conn = BancoDados.conectar();
        new MedicoDAO(conn).cadastrarMedico(medico);
    }
    
    public Especialidade obterEspecialidadePorNome(String nomeEspecialidade) throws Exception {
    	Connection conn = BancoDados.conectar();
    	Especialidade especialidade = new MedicoDAO(conn).obterEspecialidadePorNome(nomeEspecialidade);
    	return especialidade;
    }
}