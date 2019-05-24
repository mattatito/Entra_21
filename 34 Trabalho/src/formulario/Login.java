package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.AcaoLogin;
import beans.Log;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;

	public Login() {

		// Instanciando OBJ da classe ACAO
		AcaoLogin a = new AcaoLogin();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 196);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pLogin = new JPanel();
		pLogin.setBorder(UIManager.getBorder("ToolBar.border"));
		pLogin.setBackground(Color.WHITE);
		pLogin.setBounds(10, 11, 232, 135);
		pLogin.setLayout(null);
		contentPane.add(pLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblLogin.setBounds(88, 11, 84, 20);
		pLogin.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(75, 42, 96, 20);
		pLogin.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(24, 44, 62, 14);
		pLogin.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 76, 48, 14);
		pLogin.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(76, 73, 96, 20);
		pLogin.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnLogar = new JButton("Login");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Ação do botão LOGIN

				// Instanciando objetos
				Admin adm = new Admin();

				Log l = new Log();
				l.setLogin(txtLogin.getText().toLowerCase());
				l.setSenha(txtSenha.getText().toLowerCase());

				if (txtSenha.getText().equals("") || txtLogin.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha os campos");

				} else if (l.getLogin().equals("admin") && l.getSenha().equals("admin")) {

					setVisible(false);
					adm.setVisible(true);

				} else {

					a.Login(l.getLogin(), l.getSenha());
					
				}

			}

		});
		btnLogar.setBounds(24, 104, 67, 23);
		pLogin.add(btnLogar);

		// BOTÃO DE CADASTRO
		JButton btnCadastrar = new JButton("Cadastre-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instanciando obj
				Cadastrar c = new Cadastrar();
				
				setVisible(false);
				c.setVisible(true);

			}
		});
		btnCadastrar.setBounds(100, 104, 108, 23);
		pLogin.add(btnCadastrar);
	}
}
