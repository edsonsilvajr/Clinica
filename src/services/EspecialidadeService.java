package services;

import java.sql.Connection;
import java.util.List;

import dao.BancoDados;
import dao.EspecialidadeDAO;
import entities.Especialidade;

public class EspecialidadeService {    
    public EspecialidadeService() {
    	
    }

    public List<Especialidade> listarEspecialidades() throws Exception {
    	Connection conn = BancoDados.conectar();
    	List<Especialidade> especialidades = new EspecialidadeDAO(conn).listarEspecialidades();
        return especialidades;
    }

    public void cadastrarEspecialidade(Especialidade especialidade) throws Exception {
    	Connection conn = BancoDados.conectar();
    	new EspecialidadeDAO(conn).cadastrarEspecialidade(especialidade);
    }

    // Adicione métodos adicionais conforme necessário (ex: atualizar, excluir, etc.)
}