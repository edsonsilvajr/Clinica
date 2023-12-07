package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entities.Especialidade;
import entities.Medico;
import services.EspecialidadeService;
import services.MedicoService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaMedicos extends JFrame {
    private DefaultTableModel tableModel;
    private JTable tabelaMedicos;
    private JTextField txtCRM;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JComboBox<String> cmbEspecialidade;
    private MedicoService medicoService;

    public TelaMedicos(MedicoService medicoService, EspecialidadeService especialidadeService) {
        super("Cadastro e Listagem de Médicos");
        this.medicoService = medicoService;

        tableModel = new DefaultTableModel();
        tableModel.addColumn("CRM");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Especialidade");

        tabelaMedicos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaMedicos);

        txtCRM = new JTextField(20);
        txtNome = new JTextField(20);
        txtEndereco = new JTextField(20);
        txtTelefone = new JTextField(20);
        cmbEspecialidade = new JComboBox<>();

        JButton btnCadastrar = new JButton("Cadastrar");

        preencherTabela();

        preencherComboBoxEspecialidades(especialidadeService);

        setLayout(new BorderLayout());

        add(new JLabel("Listagem de Médicos", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelCadastro = new JPanel(new GridLayout(7, 2));
        panelCadastro.add(new JLabel("Cadastro de Médico", SwingConstants.CENTER));
        panelCadastro.add(new JLabel());
        panelCadastro.add(new JLabel("CRM:"));
        panelCadastro.add(txtCRM);
        panelCadastro.add(new JLabel("Nome:"));
        panelCadastro.add(txtNome);
        panelCadastro.add(new JLabel("Endereço:"));
        panelCadastro.add(txtEndereco);
        panelCadastro.add(new JLabel("Telefone:"));
        panelCadastro.add(txtTelefone);
        panelCadastro.add(new JLabel("Especialidade:"));
        panelCadastro.add(cmbEspecialidade);
        panelCadastro.add(new JLabel());
        panelCadastro.add(btnCadastrar);

        add(panelCadastro, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMedico();
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preencherTabela() {
    	try {
    		List<Medico> medicos = medicoService.listarMedicos();
    		for (Medico medico : medicos) {
    			Object[] rowData = {medico.getCrm(), medico.getNome(), medico.getEspecialidade().getNome()};
    			tableModel.addRow(rowData);
    		}
    		
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    private void preencherComboBoxEspecialidades(EspecialidadeService especialidadeService) {
    	try {
    		List<Especialidade> especialidades = especialidadeService.listarEspecialidades();
    		for (Especialidade especialidade : especialidades) {
    			cmbEspecialidade.addItem(especialidade.getNome());
    		}    		
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    private void cadastrarMedico() {           
        try {
        	String crm = txtCRM.getText();
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();
            String nomeEspecialidade = cmbEspecialidade.getSelectedItem().toString();
            
        	Especialidade especialidade = medicoService.obterEspecialidadePorNome(nomeEspecialidade);

            Medico medico = new Medico(nome, endereco, telefone, crm, especialidade);

            medicoService.cadastrarMedico(medico);

            txtCRM.setText("");
            txtNome.setText("");
            txtEndereco.setText("");
            txtTelefone.setText("");

            Object[] rowData = {medico.getCrm(), medico.getNome(), medico.getEspecialidade().getNome()};
            tableModel.addRow(rowData);
        } catch (Exception e) {
        	System.out.println(e);
        }

        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EspecialidadeService especialidadeService = new EspecialidadeService();
                MedicoService medicoService = new MedicoService();

                new TelaMedicos(medicoService, especialidadeService);
            }
        });
    }
}