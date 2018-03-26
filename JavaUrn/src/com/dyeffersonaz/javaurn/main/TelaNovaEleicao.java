package com.dyeffersonaz.javaurn.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class TelaNovaEleicao extends JFrame {

	private JPanel contentPane;
	private JTextField NomedaEleicao;
	public static File dir;
	public static JFileChooser fileChooser;
	public static JLabel dirLabel = new JLabel("...");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovaEleicao frame = new TelaNovaEleicao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaNovaEleicao() {
		setTitle("Criar nova eleição...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaEleio = new JLabel("Nome da Eleição");
		lblNomeDaEleio.setBounds(20, 16, 221, 14);
		contentPane.add(lblNomeDaEleio);
		
		NomedaEleicao = new JTextField();
		NomedaEleicao.setBounds(20, 41, 221, 20);
		contentPane.add(NomedaEleicao);
		NomedaEleicao.setColumns(10);
		
		JLabel lblEspecificaesvideDocumentao = new JLabel("Especificações (VIDE Documentação)");
		lblEspecificaesvideDocumentao.setBounds(20, 72, 221, 14);
		contentPane.add(lblEspecificaesvideDocumentao);
		
		JButton btnCriar = new JButton("Criar!");
		btnCriar.setBounds(94, 365, 91, 23);
		contentPane.add(btnCriar);
		
		JTextArea specificacoes = new JTextArea();
		specificacoes.setBounds(26, 97, 221, 180);
		contentPane.add(specificacoes);
		
		JButton btnNewButton = new JButton("Selecionar Pasta para salvar a eleição");
		btnNewButton.addActionListener(new ActionListener() {
			
			//When Button select file is on
			public void actionPerformed(ActionEvent arg0) {
				fileChooser.showOpenDialog(TelaNovaEleicao.this);
				dir = fileChooser.getSelectedFile();
				dirLabel.setText(dir.toString());
			}
			
			
		});
		btnNewButton.setBounds(26, 302, 221, 23);
		contentPane.add(btnNewButton);
		
		dirLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dirLabel.setBounds(26, 339, 221, 14);
		contentPane.add(dirLabel);
		
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}
}
