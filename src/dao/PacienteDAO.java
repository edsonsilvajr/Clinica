package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Paciente;

public class PacienteDAO {

    private Connection connection;
    
    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarPaciente(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO pacientes (nome, foto, data_nascimento, sexo, endereco, telefone, forma_pagamento) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = null;

        try {
        	st = connection.prepareStatement(sql);
            st.setString(1, paciente.getNome());
            st.setString(2, paciente.getFoto());
            st.setString(3, paciente.getDataNascimento());
            st.setString(4, paciente.getSexo());
            st.setString(5, paciente.getEndereco());
            st.setString(6, paciente.getTelefone());
            st.setString(7, paciente.getFormaPagamento());

            st.executeUpdate();
        } finally {
            // TODO
        }
    }

    public List<Paciente> listarPacientes() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        PreparedStatement st = null;
    	ResultSet rs = null;


        try {
        	st = connection.prepareStatement(sql);
        	rs = st.executeQuery();
        			
            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("foto"), rs.getString("data_nascimento"),rs.getString("sexo"), rs.getString("forma_pagamento"));
                paciente.setCodigo(rs.getInt("codigo"));
                pacientes.add(paciente);
            }
        } finally {
        	//TODO
        }

        return pacientes;
    }
}

