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

    public void cadastrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nome, foto, data_nascimento, sexo, endereco, telefone, forma_pagamento) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getFoto());
            stmt.setString(3, paciente.getDataNascimento());
            stmt.setString(4, paciente.getSexo());
            stmt.setString(5, paciente.getEndereco());
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getFormaPagamento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("foto"), rs.getString("data_nascimento"),rs.getString("sexo"), rs.getString("forma_pagamento"));
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pacientes;
    }
}

