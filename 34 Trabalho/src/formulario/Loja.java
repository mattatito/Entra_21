package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.AcaoLoja;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class Loja extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTable table;

	public Loja() {
		
		//Instanciando obj
		AcaoLoja a = new AcaoLoja();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(10, 11, 804, 480);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLoja = new JLabel("LOJA");
		lblLoja.setBackground(SystemColor.window);
		lblLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// AÇÃO DA LABEL
				
				
				
				
				

			}
		});
		lblLoja.setBounds(27, 11, 85, 34);
		panel.add(lblLoja);
		lblLoja.setForeground(Color.WHITE);
		lblLoja.setFont(new Font("Arial", Font.PLAIN, 20));

		JPanel pLoja = new JPanel();
		pLoja.setBackground(SystemColor.activeCaptionBorder);
		pLoja.setBounds(0, 50, 804, 430);
		panel.add(pLoja);
		pLoja.setLayout(null);

		txtBusca = new JTextField();
		txtBusca.setText("Busca...");
		txtBusca.setBounds(617, 40, 150, 20);
		pLoja.add(txtBusca);
		txtBusca.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(769, 39, 25, 23);
		pLoja.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 66, 784, 353);
		pLoja.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 343, 288);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(a.selecionar());
		scrollPane.setViewportView(table);
		
		JLabel lblProdutos = new JLabel("JOGOS");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProdutos.setBounds(144, 11, 115, 27);
		panel_1.add(lblProdutos);

		JLabel lblCarrinho = new JLabel("CARRINHO");
		lblCarrinho.setForeground(Color.LIGHT_GRAY);
		lblCarrinho.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCarrinho.setBackground(Color.LIGHT_GRAY);
		lblCarrinho.setBounds(131, 11, 117, 34);
		panel.add(lblCarrinho);

	}
}
