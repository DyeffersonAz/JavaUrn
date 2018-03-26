package com.dyeffersonaz.javaurn.main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Urna Eletrônica - JAVAURN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUrnaEletrnica = new JLabel("Urna Eletrônica - JAVAURN");
		lblUrnaEletrnica.setBounds(0, 0, 442, 51);
		lblUrnaEletrnica.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUrnaEletrnica.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUrnaEletrnica);
		
		JButton btnNewButton = new JButton("Nova Eleição");
		btnNewButton.addActionListener(new ActionListener() {
			
			//When the "Nova Eleição" button is pressed
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("NOVA ELEIÇÃO");
			}
			
			
		});
		btnNewButton.setBounds(85, 108, 279, 70);
		contentPane.add(btnNewButton);
	}
}
