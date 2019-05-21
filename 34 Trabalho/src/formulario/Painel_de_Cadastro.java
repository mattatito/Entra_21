package formulario;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Painel_de_Cadastro extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	// Construtor
	public Painel_de_Cadastro() {
		setVisible(true);
		setBorder(new TitledBorder(null, "Cadastro de Usu\u00E1rio", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		setBackground(Color.WHITE);

		setBounds(10, 11, 313, 205);
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome completo");
		lblNome.setBounds(10, 40, 96, 14);
		add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(102, 37, 201, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de Usu\u00E1rio");
		lblNomeDeUsurio.setBounds(10, 65, 96, 14);
		add(lblNomeDeUsurio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 62, 201, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(58, 93, 48, 14);
		add(lblSenha);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 90, 201, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(102, 156, 89, 23);
		add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(201, 156, 89, 23);
		add(btnCancelar);
		
		
	}

}
