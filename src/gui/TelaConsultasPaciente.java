package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entities.Consulta;
import entities.Paciente;
import services.ConsultaService;
import services.PacienteService;

import java.awt.*;
import java.util.List;

public class TelaConsultasPaciente extends JFrame {
    private JComboBox<Paciente> cmbPacientes;
    private JTable tabelaConsultas;
    private DefaultTableModel tableModel;
    private ConsultaService consultaService;
    private PacienteService pacienteService;

    public TelaConsultasPaciente(ConsultaService consultaService, PacienteService pacienteService) {
        super("Consultas por Paciente");
        this.pacienteService = pacienteService;
        this.consultaService = consultaService;
        
        cmbPacientes = new JComboBox<>();
        preencherComboBox();

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Data");
        tableModel.addColumn("Médico - CRM");

        tabelaConsultas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaConsultas);

        setLayout(new BorderLayout());

        JPanel panelPacientes = new JPanel(new FlowLayout());
        panelPacientes.add(new JLabel("Selecione o Paciente:"));
        panelPacientes.add(cmbPacientes);
        add(panelPacientes, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        cmbPacientes.addActionListener(e -> atualizarListaConsultas());
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    private void preencherComboBox() {
    	try {
    		List<Paciente> pacientes = pacienteService.listarPacientes();
    		cmbPacientes.addItem(null);
    		for (Paciente paciente : pacientes) {
				cmbPacientes.addItem(paciente);
			}
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    private void atualizarListaConsultas() {
        tableModel.setRowCount(0);

        Paciente pacienteSelecionado = (Paciente) cmbPacientes.getSelectedItem();
        
        try {
        	if (pacienteSelecionado != null) {
        		List<Consulta> consultas = consultaService.listarConsultasPorPaciente(pacienteSelecionado.getCodigo());
        		
        		for (Consulta consulta : consultas) {
        			Object[] rowData = {consulta.getHorarioConsulta(), consulta.getMedicoCrm(), consulta.getPacienteId()};
        			tableModel.addRow(rowData);
        		}
        	}        	
        } catch (Exception e) {
        	System.out.println(e);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultaService consultaService = new ConsultaService();
            PacienteService pacienteService = new PacienteService();
            new TelaConsultasPaciente(consultaService, pacienteService);
        });
    }
}
