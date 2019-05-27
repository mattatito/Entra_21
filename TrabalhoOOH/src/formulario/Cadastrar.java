package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import acao.AcaoLogin;
import beans.Log;
import dados.Dados;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastrar extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtNome;

	//Limpar dados
	private void limpaDados() {
		
		txtEmail.setText("");
		txtSenha.setText("");
		txtUsuario.setText("");
		
	}
	
	//Construtor
	public Cadastrar() {
		//Instanciando obj ACAO
		AcaoLogin a = new AcaoLogin();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 247);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "CADASTRO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel.setBounds(10, 11, 321, 186);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Cadastrando usuário
				
				//Instanciando objetos
				Login log = new Login();
				
				Log l = new Log();
				l.setNome(txtNome.getText());
				l.setLogin(txtUsuario.getText());
				l.setEmail(txtEmail.getText());
				l.setSenha(txtSenha.getText());
				
				
				
				//Cadastrando
				
				boolean JaVai=false;
				
				String Duplicata = txtUsuario.getText();
				 String DupPlat = txtEmail.getText();
				 
				 for (int i = 0; i<Dados.arrayLogin.size(); i++) {
						if((Duplicata.equals(Dados.arrayLogin.get(i).getLogin())) || (DupPlat.equals(Dados.arrayLogin.get(i).getEmail()))){
							JOptionPane.showMessageDialog(null, "Nome de usuário ou email já utilizado");
						JaVai = true;
						} 
						
					
					}
				 if (JaVai == false) {
				a.cadastrar(l);
				
					//Limpando dados
					limpaDados();
				
					//Voltando a tela de login
					setVisible(false);
					log.setVisible(true);
				 }
	
			}
		});
		btnCadastrar.setBounds(46, 151, 99, 23);
		panel.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Instanciando obj
				Login l = new Login();
				
				setVisible(false);
				l.setVisible(true);
				
			}
		});
		btnVoltar.setBounds(170, 151, 99, 23);
		panel.add(btnVoltar);
		
		JLabel lblUsurio = new JLabel("Nome de Usu\u00E1rio");
		lblUsurio.setBounds(16, 95, 144, 14);
		panel.add(lblUsurio);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(73, 70, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(62, 126, 46, 14);
		panel.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(129, 92, 182, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(129, 67, 182, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(129, 120, 182, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(16, 39, 114, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(129, 36, 182, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
	}
}
