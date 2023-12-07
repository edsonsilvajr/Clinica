package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Especialidade;

public class EspecialidadeDAO {

    private Connection connection;

    
    public EspecialidadeDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void cadastrarEspecialidade(Especialidade especialidade) throws SQLException {
        String sql = "INSERT INTO especialidades (codigo, nome) VALUES (?, ?)";
        PreparedStatement st = null;

        try {
        	st = connection.prepareStatement(sql);
            st.setInt(1, especialidade.getCodigo());
            st.setString(2, especialidade.getNome());

            st.executeUpdate();
        } finally {
        	//TODO
        }
    }

    public List<Especialidade> listarEspecialidades() throws SQLException {
        List<Especialidade> especialidades = new ArrayList<>();
        String sql = "SELECT * FROM especialidades";
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery(); 

            while (rs.next()) {
                Especialidade especialidade = new Especialidade(rs.getInt("codigo"), rs.getString("nome"));
                especialidades.add(especialidade);
            }
        } finally {
            // TODO
        }

        return especialidades;
    }
}
