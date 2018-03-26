package com.dyeffersonaz.javaurn.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class TelaNovaEleicao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 277, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaEleio = new JLabel("Nome da Eleição");
		lblNomeDaEleio.setBounds(10, 11, 85, 14);
		contentPane.add(lblNomeDaEleio);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 221, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 82, 221, 150);
		contentPane.add(editorPane);
		
		JLabel lblEspecificaesvideDocumentao = new JLabel("Especificações (VIDE Documentação)");
		lblEspecificaesvideDocumentao.setBounds(10, 62, 221, 14);
		contentPane.add(lblEspecificaesvideDocumentao);
	}
}
