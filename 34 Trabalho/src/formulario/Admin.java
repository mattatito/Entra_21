package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import acao.AcaoJogos;
import acao.AcaoLogin;
import beans.Jogos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtPlataforma;
	private JTextField txtDesenvolvedora;
	private JTextField txtValor;

	//Limpar dados
	private void limpaCampos(){
		
		txtDesenvolvedora.setText("");
		txtGenero.setText("");
		txtNome.setText("");
		txtPlataforma.setText("");
		txtValor.setText("");
		
	}
	
	
	// Construtor
	public Admin() {
		
		//Instanciando obj da classe ACAO
		AcaoJogos a = new AcaoJogos();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Cadastrar Jogos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 455, 245);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox<String> cbClass = new JComboBox <String>();
		cbClass.addItem("Selecionar...") ;
		cbClass.addItem("Livre") ;
		cbClass.addItem("+10") ;
		cbClass.addItem("+12") ;
		cbClass.addItem("+14") ;
		cbClass.addItem("+16") ;
		cbClass.addItem("+18") ;
		
		txtNome = new JTextField();
		txtNome.setBounds(105, 11, 96, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(47, 14, 48, 14);
		panel.add(lblNome);

		txtGenero = new JTextField();
		txtGenero.setBounds(105, 37, 96, 20);
		panel.add(txtGenero);
		txtGenero.setColumns(10);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setBounds(47, 39, 48, 14);
		panel.add(lblGnero);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(26, 63, 82, 14);
		panel.add(lblPlataforma);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setBounds(105, 60, 96, 20);
		panel.add(txtPlataforma);
		txtPlataforma.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Cadastrando jogos
				
				//Instanciando obj 
				Jogos j = new Jogos();
				j.setNome(txtNome.getText());
				j.setClassificacao(cbClass.getSelectedItem().toString());
				j.setGenero(txtGenero.getText());
				j.setPlataforma(txtPlataforma.getText());
				j.setDesenvolvedora(txtDesenvolvedora.getText());
				j.setValor(Double.parseDouble(txtValor.getText()));
				
				
				//Cadastrando
				a.cadastrar1(j);
				
				//Atualizando tabela
				table.setModel(a.selecionar());
				
				//Limpando campos
				limpaCampos();
				
				
			}
		});
		btnCadastrar.setBounds(10, 200, 138, 23);
		panel.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(158, 200, 89, 23);
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(257, 200, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(356, 200, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblClassificacao = new JLabel("Classificacao");
		lblClassificacao.setBounds(26, 141, 82, 14);
		panel.add(lblClassificacao);
		
		
		cbClass.setBounds(105, 138, 96, 20);
		panel.add(cbClass);
		
		JLabel lblDesenvolvedora = new JLabel("Desenvolvedora");
		lblDesenvolvedora.setBounds(10, 88, 112, 14);
		panel.add(lblDesenvolvedora);
		
		txtDesenvolvedora = new JTextField();
		txtDesenvolvedora.setBounds(105, 85, 96, 20);
		panel.add(txtDesenvolvedora);
		txtDesenvolvedora.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(47, 113, 46, 14);
		panel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(105, 113, 96, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(26, 166, 82, 14);
		panel.add(lblQuantidade);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(91, 163, 48, 20);
		
		panel.add(spinner);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produtos listados", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GRAY));
		panel_1.setBounds(10, 265, 789, 226);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 769, 192);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(a.selecionar());
		scrollPane.setViewportView(table);

	}
}
