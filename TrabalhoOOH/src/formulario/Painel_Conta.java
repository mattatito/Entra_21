package formulario;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import acao.AcaoLogin;
import dados.Dados;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painel_Conta extends JPanel {
	private JTextField txtNomeUsuario;
	private JTextField txtEmailUsuario;
	private JTextField txtSenhaUsuario;
	private JTextField txtLoginUsuario;

	public Painel_Conta() {
		
		//Instanciando obj
				AcaoLogin lo = new AcaoLogin();
		setBounds(0, 50, 804, 520);
		setBackground(SystemColor.activeCaptionBorder);
		setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados da Conta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_1.setBounds(10, 66, 784, 309);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnUsuario = new JButton("");
		btnUsuario.setEnabled(false);
		btnUsuario.setIcon(new ImageIcon("D:\\Downloads\\icons8-usu\u00E1rio-100.png"));
		btnUsuario.setBounds(465, 40, 227, 245);
		panel_1.add(btnUsuario);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(54, 40, 46, 14);
		panel_1.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(54, 106, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(54, 142, 46, 14);
		panel_1.add(lblSenha);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setEditable(false);
		txtNomeUsuario.setText(Dados.arrayLogin.get(lo.contador).getNome());
		txtNomeUsuario.setBounds(100, 40, 156, 20);
		panel_1.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		txtEmailUsuario = new JTextField();
		txtEmailUsuario.setText(Dados.arrayLogin.get(lo.contador).getEmail());
		txtEmailUsuario.setEditable(false);
		txtEmailUsuario.setBounds(100, 103, 156, 20);
		panel_1.add(txtEmailUsuario);
		txtEmailUsuario.setColumns(10);
		
		txtSenhaUsuario = new JTextField();
		txtSenhaUsuario.setText(Dados.arrayLogin.get(lo.contador).getSenha());
		txtSenhaUsuario.setEditable(false);
		txtSenhaUsuario.setBounds(100, 139, 156, 20);
		panel_1.add(txtSenhaUsuario);
		txtSenhaUsuario.setColumns(10);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de Usu\u00E1rio");
		lblNomeDeUsurio.setBounds(10, 74, 107, 14);
		panel_1.add(lblNomeDeUsurio);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setText(Dados.arrayLogin.get(lo.contador).getLogin());
		txtLoginUsuario.setEditable(false);
		txtLoginUsuario.setBounds(100, 71, 156, 20);
		panel_1.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);
		
		JButton btnAtualizarDados = new JButton("Atualizar dados");
		btnAtualizarDados.setBounds(33, 167, 113, 23);
		panel_1.add(btnAtualizarDados);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(156, 167, 113, 23);
		panel_1.add(btnSalvar);
		
		JButton btnDeletarConta = new JButton("Deletar Conta");
		btnDeletarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] op = new Object[] {"Sim", "Não"};
				
				int escolha = JOptionPane.showOptionDialog(null, "Deseja mesmo deletar sua conta?", "AVISO!!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null , op, 0);
				
				switch (escolha) {
				
				case 0:
					Dados.arrayLogin.remove(lo.contador);
					JOptionPane.showMessageDialog(null, "Conta excluida.","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
					setVisible(false);
					
				break;
				
				}
				
			}
		});
		btnDeletarConta.setBounds(340, 263, 107, 23);
		panel_1.add(btnDeletarConta);
		
		JLabel lblNOME = new JLabel("");
		lblNOME.setText(Dados.arrayLogin.get(lo.contador).getNome());
		
		lblNOME.setFont(new Font("Arial", Font.BOLD, 16));
		lblNOME.setBounds(31, 11, 575, 52);
		add(lblNOME);
		
		
		
	}

}
