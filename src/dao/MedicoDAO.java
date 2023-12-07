package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Especialidade;
import entities.Medico;
import entities.Paciente;

public class MedicoDAO {
	
	private Connection connection;
    
    public MedicoDAO(Connection connection) {
        this.connection = connection;
    }
	
	public List<Medico> listarMedicos() throws Exception{
		List<Medico> medicos = new ArrayList<>();
		String sql = "SELECT * FROM medicos";
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(sql);
        	rs = st.executeQuery();
        	
        	while (rs.next()) {
        		int idEspecialidade = rs.getInt("especialidade_id");
        		Especialidade especialidade = obterEspecialidadePorId(idEspecialidade);
                Medico medico = new Medico(rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("crm"), especialidade);
                medicos.add(medico);
            }
			
		} finally {
			//TODO
		}
		
		return medicos;
	}
	
	public void cadastrarMedico(Medico medico) throws Exception {
		String sql = "INSERT INTO medicos (crm, nome, endereco, telefone, especialidade_id) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = null;
		
		try {
        	st = connection.prepareStatement(sql);
            st.setString(1, medico.getCrm());
            st.setString(2, medico.getNome());
            st.setString(3, medico.getEndereco());
            st.setString(4, medico.getTelefone());
            st.setInt(5, medico.getEspecialidade().getCodigo());
            st.executeUpdate();
        } finally {
            // TODO
        }
    }
	
	public Especialidade obterEspecialidadePorId(int idEspecialidade) throws Exception {
		String sql = "SELECT * FROM especialidades WHERE codigo = ?";
		Especialidade especialidade = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = connection.prepareStatement(sql);
			st.setInt(1, idEspecialidade);
			rs = st.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");

				especialidade = new Especialidade(codigo, nome);
			}

		} finally {
			//TODO
		}

		return especialidade;
	}
	
	public Especialidade obterEspecialidadePorNome(String nome) throws Exception {
		String sql = "SELECT * FROM especialidades WHERE nome = ?";
		Especialidade especialidade = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = connection.prepareStatement(sql);
			st.setString(1, nome);
			rs = st.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nomeEspecializacao= rs.getString("nome");

				especialidade = new Especialidade(codigo, nomeEspecializacao);
			}

		} finally {
			//TODO
		}

		return especialidade;
	}
}
