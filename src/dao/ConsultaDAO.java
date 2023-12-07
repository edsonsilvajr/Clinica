package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Consulta;

public class ConsultaDAO {
	private Connection connection;

	public ConsultaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void agendarConsulta(Consulta consulta) throws Exception{
        String sql = "INSERT INTO consultas (paciente_codigo, medico_crm, horario) VALUES (?, ?, ?)";
        PreparedStatement st = null;

        try {
        	st = connection.prepareStatement(sql);
            st.setInt(1, consulta.getPacienteId());
            st.setString(2, consulta.getMedicoCrm());
            st.setString(3, consulta.getHorarioConsulta());

            st.executeUpdate();
        } finally {
        	//TODO
        }
    }

	public List<Consulta> listarConsultasPorPaciente(int codigoPaciente) throws Exception {
		List<Consulta> consultas = new ArrayList<>();
		String sql = "SELECT * FROM consultas WHERE paciente_codigo = ?";
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = connection.prepareStatement(sql);
			st.setInt(1, codigoPaciente);

			rs = st.executeQuery();

			while (rs.next()) {
				int idConsulta = rs.getInt("codigo");
				String medicoCrm = rs.getString("medico_crm");
				String horario = rs.getString("horario");

				consultas.add(new Consulta(idConsulta, codigoPaciente, medicoCrm, horario));
			}

		} finally {
			// TODO
		}

		return consultas;
	}
}
