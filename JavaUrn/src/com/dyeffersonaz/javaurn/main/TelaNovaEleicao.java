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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.awt.event.ActionEvent;

public class TelaNovaEleicao extends JFrame {

	private JPanel contentPane;
	private JTextField NomedaEleicao;
	public static File dir;
	public static JFileChooser fileChooser;
	public static JLabel dirLabel = new JLabel("...");
	public static JTextArea especificacoes;

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
		setBounds(100, 100, 277, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaEleio = new JLabel("Nome da Eleição");
		lblNomeDaEleio.setBounds(20, 11, 221, 14);
		contentPane.add(lblNomeDaEleio);
		
		NomedaEleicao = new JTextField();
		NomedaEleicao.setBounds(20, 36, 221, 20);
		contentPane.add(NomedaEleicao);
		NomedaEleicao.setColumns(10);
		
		JLabel lblEspecificaesvideDocumentao = new JLabel("Especificações (VIDE Documentação)");
		lblEspecificaesvideDocumentao.setBounds(20, 67, 221, 14);
		contentPane.add(lblEspecificaesvideDocumentao);
		
		JButton btnCriar = new JButton("Criar!");
		btnCriar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				makeFiles(dir);
			}
			
			
		});
		btnCriar.setBounds(90, 342, 91, 23);
		contentPane.add(btnCriar);
		
		especificacoes = new JTextArea();
		especificacoes.setBounds(20, 92, 221, 180);
		contentPane.add(especificacoes);
		
		JButton btnNewButton = new JButton("Selecionar Pasta para salvar a eleição");
		btnNewButton.addActionListener(new ActionListener() {
			
			//When Button select file is on
			public void actionPerformed(ActionEvent arg0) {
				fileChooser.showOpenDialog(TelaNovaEleicao.this);
				dir = fileChooser.getSelectedFile();
				dirLabel.setText(dir.toString());
			}
			
			
		});
		btnNewButton.setBounds(20, 282, 221, 23);
		contentPane.add(btnNewButton);
		
		dirLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dirLabel.setBounds(0, 318, 269, 14);
		contentPane.add(dirLabel);
		
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
	}
	
	public void makeFiles(File directory) {
		//Create the files that are important to the workflow of the software
		FileWriter fw = null;
		try {
			File project;
			if (NomedaEleicao.getText() != null) {
				project = new File(dir.toString() + "\\" + NomedaEleicao.getText() + ".elec");
			} else {
				throw new Exception("The file can't be null");
			}
			fw = new FileWriter(project);
			String[] candidatos =  especificacoes.getText().split("\n");
			for (int i = 0; i < candidatos.length; i++) {
				fw.write(candidatos[i] + "=" + "X");
				fw.write(System.getProperty("line.separator"));
			}
			System.out.println("Arquivo criado: " + project.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
