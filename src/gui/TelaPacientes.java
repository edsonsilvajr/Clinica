package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entities.Paciente;
import services.PacienteService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaPacientes extends JFrame {
    private DefaultTableModel tableModel;
    private JTable tabelaPacientes;
    private JTextField txtNomeNovoPaciente;
    private JTextField txtEnderecoNovoPaciente;
    private JTextField txtTelefoneNovoPaciente;
    private JTextField txtFotoNovoPaciente;
    private JTextField txtDataNascimentoNovoPaciente;
    private JTextField txtSexoNovoPaciente;
    private JTextField txtFormaPagamentoNovoPaciente;
    private JButton btnAdicionarNovoPaciente;
    private PacienteService pacienteService;

    public TelaPacientes(PacienteService pacienteService) {
        super("Cadastro de Pacientes");
        this.pacienteService = pacienteService;

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Data de Nascimento");
        tableModel.addColumn("Sexo");
        tableModel.addColumn("Forma de Pagamento");

        tabelaPacientes = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaPacientes);

        JLabel lblNomeNovoPaciente = new JLabel("Nome:");
        txtNomeNovoPaciente = new JTextField(20);
        
        JLabel lblEnderecoNovoPaciente = new JLabel("Endereço:");
        txtEnderecoNovoPaciente = new JTextField(20);
        
        JLabel lblTelefoneNovoPaciente = new JLabel("Telefone:");
        txtTelefoneNovoPaciente = new JTextField(20);
        
        JLabel lblFotoNovoPaciente = new JLabel("Foto:");
        txtFotoNovoPaciente = new JTextField(20);
        
        JLabel lblDataNascimentoNovoPaciente = new JLabel("Data de Nascimento:");
        txtDataNascimentoNovoPaciente = new JTextField(20);
        
        JLabel lblSexoNovoPaciente = new JLabel("Sexo:");
        txtSexoNovoPaciente = new JTextField(20);
        
        JLabel lblFormaPagamentoNovoPaciente = new JLabel("Forma de Pagamento:");
        txtFormaPagamentoNovoPaciente = new JTextField(20);

        btnAdicionarNovoPaciente = new JButton("Adicionar");

        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.NORTH);

        JPanel panelCadastro = new JPanel(new GridLayout(8,1));
        panelCadastro.add(lblNomeNovoPaciente);
        panelCadastro.add(txtNomeNovoPaciente);
        panelCadastro.add(lblEnderecoNovoPaciente);
        panelCadastro.add(txtEnderecoNovoPaciente);
        panelCadastro.add(lblTelefoneNovoPaciente);
        panelCadastro.add(txtTelefoneNovoPaciente);
        panelCadastro.add(lblFotoNovoPaciente);
        panelCadastro.add(txtFotoNovoPaciente);
        panelCadastro.add(lblDataNascimentoNovoPaciente);
        panelCadastro.add(txtDataNascimentoNovoPaciente);
        panelCadastro.add(lblSexoNovoPaciente);
        panelCadastro.add(txtSexoNovoPaciente);
        panelCadastro.add(lblFormaPagamentoNovoPaciente);
        panelCadastro.add(txtFormaPagamentoNovoPaciente);
        panelCadastro.add(new JLabel());
        panelCadastro.add(btnAdicionarNovoPaciente);
        add(panelCadastro, BorderLayout.CENTER);

        btnAdicionarNovoPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNovoPaciente();
            }
        });

        preencherTabela();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarNovoPaciente() {
    	try {
    		String nome = txtNomeNovoPaciente.getText();
    		String endereco = txtEnderecoNovoPaciente.getText();
    		String telefone = txtTelefoneNovoPaciente.getText();
    		String foto = txtFotoNovoPaciente.getText();
    		String dataNascimento = txtDataNascimentoNovoPaciente.getText();
    		String sexo = txtSexoNovoPaciente.getText();
    		String formaPagamento = txtFormaPagamentoNovoPaciente.getText();
    		
    		Paciente paciente = new Paciente(nome, endereco, telefone, foto, dataNascimento, sexo, formaPagamento);
    		pacienteService.cadastrarPaciente(paciente);
    		
    		Object[] rowData = {paciente.getNome(), paciente.getEndereco(), paciente.getTelefone(),
					paciente.getDataNascimento(), paciente.getSexo(), paciente.getFormaPagamento()};
			tableModel.addRow(rowData);
			
    		limparCampos();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    private void preencherTabela() {
    	try {
    		tableModel.setRowCount(0);
    		
    		List<Paciente> pacientes = pacienteService.listarPacientes();
    		
    		for (Paciente paciente : pacientes) {
    			Object[] rowData = {paciente.getNome(), paciente.getEndereco(), paciente.getTelefone(),
    					paciente.getDataNascimento(), paciente.getSexo(), paciente.getFormaPagamento()};
    			tableModel.addRow(rowData);
    		}    		
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    private void limparCampos() {
        txtNomeNovoPaciente.setText("");
        txtEnderecoNovoPaciente.setText("");
        txtTelefoneNovoPaciente.setText("");
        txtFotoNovoPaciente.setText("");
        txtDataNascimentoNovoPaciente.setText("");
        txtSexoNovoPaciente.setText("");
        txtFormaPagamentoNovoPaciente.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PacienteService pacienteService = new PacienteService();
            new TelaPacientes(pacienteService);
        });
    }
}
