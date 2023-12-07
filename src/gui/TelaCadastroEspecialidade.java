package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroEspecialidade extends JFrame {
    private JTextField txtCodigo;
    private JTextField txtNome;

    public TelaCadastroEspecialidade() {
        super("Cadastro de Especialidade");

        txtCodigo = new JTextField(20);
        txtNome = new JTextField(20);

        JButton btnCadastrar = new JButton("Cadastrar");

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Código:"));
        add(txtCodigo);
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEspecialidade();
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarEspecialidade() {
        JOptionPane.showMessageDialog(this, "Especialidade cadastrada com sucesso!");
    }
}