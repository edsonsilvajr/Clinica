package gui;

import javax.swing.*;

import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import services.ConsultaService;
import services.MedicoService;
import services.PacienteService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaAgendarConsulta extends JFrame {
    private JComboBox<Paciente> cmbPacientes;
    private JComboBox<Medico> cmbMedicos;
    private JTextField txtDataHora;
    private ConsultaService consultaService;

    public TelaAgendarConsulta( ConsultaService consultaService, PacienteService pacienteService, MedicoService medicoService) {
        super("Agendar Consulta");
        this.consultaService = consultaService;

        JLabel lblPaciente = new JLabel("Selecione o Paciente:");
        cmbPacientes = new JComboBox<Paciente>(obterPacientes(pacienteService));

        JLabel lblMedico = new JLabel("Selecione o Médico:");
        cmbMedicos = new JComboBox<Medico>(obterMedicos(medicoService));

        JLabel lblDataHora = new JLabel("Data e Hora (Formato: yyyy-MM-dd HH:mm):");
        txtDataHora = new JTextField(20);

        JButton btnAgendar = new JButton("Agendar");

        setLayout(new GridLayout(4, 2));

        add(lblPaciente);
        add(cmbPacientes);
        add(lblMedico);
        add(cmbMedicos);
        add(lblDataHora);
        add(txtDataHora);
        add(new JLabel());
        add(btnAgendar);

        btnAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agendarConsulta();
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Paciente[] obterPacientes(PacienteService pacienteService) {
    	List<Paciente> pacientes = new ArrayList<>();
    	try {
    		pacientes = pacienteService.listarPacientes();
    		return pacientes.toArray(new Paciente[0]);
    		
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return pacientes.toArray(new Paciente[0]);
    }

    private Medico[] obterMedicos(MedicoService medicoService) {
    	List<Medico> medicos = new ArrayList<>();
    	try {
    		medicos = medicoService.listarMedicos();
    		return medicos.toArray(new Medico[0]);
    	}  catch (Exception e) {
    		System.out.println(e);
    	}
    	return medicos.toArray(new Medico[0]);
    }

    private void agendarConsulta() {
    	try {
    		Paciente pacienteSelecionado = (Paciente) cmbPacientes.getSelectedItem();
    		Medico medicoSelecionado = (Medico) cmbMedicos.getSelectedItem();
    		
    		System.out.println(pacienteSelecionado.getCodigo());
    		
    		consultaService.agendarConsulta(new Consulta(pacienteSelecionado.getCodigo(), medicoSelecionado.getCrm(), txtDataHora.getText()));
    		
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PacienteService pacienteService = new PacienteService();
            MedicoService medicoService = new MedicoService();
            ConsultaService consultaService = new ConsultaService();
            new TelaAgendarConsulta(consultaService, pacienteService, medicoService);
        });
    }
}
