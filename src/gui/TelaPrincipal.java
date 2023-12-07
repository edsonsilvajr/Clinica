package gui;

import javax.swing.*;

import entities.Especialidade;
import entities.Medico;
import services.ConsultaService;
import services.EspecialidadeService;
import services.MedicoService;
import services.PacienteService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        super("Sistema de Cadastros");

        JButton btnEspecialidades = new JButton("Especialidades");
        JButton btnPacientes = new JButton("Pacientes");
        JButton btnMedicos = new JButton("Médicos");
        JButton btnConsulta = new JButton("Agendar Consulta");
        JButton btnConsultasPaciente = new JButton("Consultas por paciente");

        setLayout(new GridLayout(5, 1));

        add(btnPacientes);
        add(btnMedicos);
        add(btnEspecialidades);
        add(btnConsulta);
        add(btnConsultasPaciente);

        btnEspecialidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaEspecialidades();
            }
        });
        
        btnMedicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaMedicos();
            }
        });
        
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaAgendarConsulta();
            }
        });
        
        btnPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaPacientes();
            }
        });
        
        btnConsultasPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaConsultasPorPaciente();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirTelaEspecialidades() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	EspecialidadeService especialidadeService = new EspecialidadeService();
                new TelaEspecialidades(especialidadeService);
            }
        });
    }
    
    private void abrirTelaMedicos() {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {    			
    			EspecialidadeService especialidadeService = new EspecialidadeService();
                MedicoService medicoService = new MedicoService();

                new TelaMedicos(medicoService, especialidadeService);
    			
    		}
    	});
    }
    
    private void abrirTelaAgendarConsulta() {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {    			
    			PacienteService pacienteService = new PacienteService();
                MedicoService medicoService = new MedicoService();
                ConsultaService consultaService = new ConsultaService();
                new TelaAgendarConsulta(consultaService, pacienteService, medicoService);
    			
    		}
    	});
    }
    
    private void abrirTelaConsultasPorPaciente() {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {    			
    			ConsultaService consultaService = new ConsultaService();
                PacienteService pacienteService = new PacienteService();
                new TelaConsultasPaciente(consultaService, pacienteService);
    			
    		}
    	});
    }
    
    private void abrirTelaPacientes() {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {    			
    			 PacienteService pacienteService = new PacienteService();
    	            new TelaPacientes(pacienteService);
    			
    		}
    	});
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal();
            }
        });
    }
}
