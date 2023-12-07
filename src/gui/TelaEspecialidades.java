package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entities.Especialidade;
import services.EspecialidadeService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaEspecialidades extends JFrame {
    private DefaultTableModel tableModel;
    private JTable tabelaEspecialidades;
    private JTextField txtCodigo;
    private JTextField txtNome;
    private EspecialidadeService especialidadeService;

    public TelaEspecialidades(EspecialidadeService especialidadeService){
        super("Cadastro e Listagem de Especialidades");
        this.especialidadeService = especialidadeService;

        // Criação dos componentes
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Código");
        tableModel.addColumn("Nome");

        tabelaEspecialidades = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaEspecialidades);

        txtCodigo = new JTextField(20);
        txtNome = new JTextField(20);

        JButton btnCadastrar = new JButton("Cadastrar");

        try {
        	preencherTabela();	
        } catch (Exception e) {
        	System.out.println(e);
        }        

        setLayout(new BorderLayout());

        add(new JLabel("Listagem de Especialidades", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelCadastro = new JPanel(new GridLayout(5, 2));
        panelCadastro.add(new JLabel("Cadastro de Especialidade", SwingConstants.CENTER));
        panelCadastro.add(new JLabel());
        panelCadastro.add(new JLabel("Código:"));
        panelCadastro.add(txtCodigo);
        panelCadastro.add(new JLabel("Nome:"));
        panelCadastro.add(txtNome);
        panelCadastro.add(new JLabel());
        panelCadastro.add(btnCadastrar);

        add(panelCadastro, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		cadastrarEspecialidade();            		
            	} catch (Exception ex) {
            		System.out.println(ex);
            	}
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preencherTabela() throws Exception {
        List<Especialidade> especialidades = especialidadeService.listarEspecialidades();
        for (Especialidade especialidade : especialidades) {
            Object[] rowData = {especialidade.getCodigo(), especialidade.getNome()};
            tableModel.addRow(rowData);
        }
    }

    private void cadastrarEspecialidade() throws Exception{
        int codigo = Integer.parseInt(txtCodigo.getText());
        String nome = txtNome.getText();
        Especialidade especialidade = new Especialidade(codigo, nome);

        especialidadeService.cadastrarEspecialidade(especialidade);

        txtCodigo.setText("");
        txtNome.setText("");

        Object[] rowData = {especialidade.getCodigo(), especialidade.getNome()};
        tableModel.addRow(rowData);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EspecialidadeService especialidadeService = new EspecialidadeService();
                new TelaEspecialidades(especialidadeService);
            }
        });
    }
}
