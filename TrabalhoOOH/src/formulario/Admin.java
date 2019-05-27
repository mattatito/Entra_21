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
import dados.Dados;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class Admin extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtPlataforma;
	private JTextField txtDesenvolvedora;
	private JTextField txtValor;
	private JSpinner spinner;
	private int codigo;
	private JTable tabela_usuario;
	private JComboBox<String> cbClass;
	
	//Botões
	private JButton btnCadastrar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	
	//Limpar dados
	private void limpaCampos(){
		
		txtDesenvolvedora.setText("");
		txtGenero.setText("");
		txtNome.setText("");
		txtPlataforma.setText("");
		txtValor.setText("");
		cbClass.setSelectedIndex(0);
		spinner.setValue(0);
		
	}
	
	
	// Construtor
	public Admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Gamer\\Desktop\\icons8-moderador-masculino-filled-50.png"));
		setResizable(false);
		//Instanciando obj da classe ACAO
		AcaoJogos a = new AcaoJogos();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Cadastrar Jogos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 455, 245);
		contentPane.add(panel);
		panel.setLayout(null);

		cbClass = new JComboBox <String>();
		cbClass.addItem("Selecionar...") ;
		cbClass.addItem("Livre") ;
		cbClass.addItem("+10") ;
		cbClass.addItem("+12") ;
		cbClass.addItem("+14") ;
		cbClass.addItem("+16") ;
		cbClass.addItem("+18") ;
		
		txtNome = new JTextField();
		txtNome.setBounds(105, 24, 96, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(47, 27, 48, 14);
		panel.add(lblNome);

		txtGenero = new JTextField();
		txtGenero.setBounds(105, 50, 96, 20);
		panel.add(txtGenero);
		txtGenero.setColumns(10);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setBounds(47, 52, 48, 14);
		panel.add(lblGnero);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(26, 76, 82, 14);
		panel.add(lblPlataforma);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setBounds(105, 73, 96, 20);
		panel.add(txtPlataforma);
		txtPlataforma.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(286, 74, 48, 20);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
					
				
				boolean JaVai = false;
				txtValor.setBorder(new LineBorder(Color.GRAY));
					
				if (txtNome.getText().equals("") || txtValor.getText().equals("") || txtGenero.getText().equals("")
							|| txtDesenvolvedora.getText().equals("") || txtPlataforma.getText().equals("") ) {
						
						JOptionPane.showMessageDialog(null, "Informe todos os campos");
						
				}else {
					
					//Instanciando obj 
					Jogos j = new Jogos();
					j.setNome(txtNome.getText());
					j.setClassificacao(cbClass.getSelectedItem().toString());
					j.setGenero(txtGenero.getText());
					j.setPlataforma(txtPlataforma.getText());
					j.setDesenvolvedora(txtDesenvolvedora.getText());
					j.setValor(Double.parseDouble(txtValor.getText()));
					
					//Validação de repetição
					String Duplicata = txtNome.getText();
					String DupPlat = txtPlataforma.getText();
					 
					for (int i = 0; i<Dados.arrayJogo.size(); i++) {
						if((Duplicata.equals(Dados.arrayJogo.get(i).getNome())) && (DupPlat.equals(Dados.arrayJogo.get(i).getPlataforma()))){
							JOptionPane.showMessageDialog(null, "Jogo duplicado");
						JaVai = true;
						} 
						
					
					}
					
					
					int qtd = Integer.parseInt(spinner.getValue().toString());
					if (qtd < 0) {
						
						JOptionPane.showMessageDialog(null, "Não é possível cadastrar uma quantidade negativa.");
						spinner.setValue(0);
						
					}else {
						
					j.setQtd(Integer.parseInt(spinner.getValue().toString()));
					
					}
					//Cadastrando
					if (JaVai == false) {
						
						//Cadastrando
						a.cadastrar1(j);
						
						//Atualizando tabela
						table.setModel(a.selecionar());
						
						//Limpando campos
						limpaCampos();
						
					}
					    
				}
				}catch (Exception erro) {
					
					JOptionPane.showMessageDialog(null, "caracteres inválidos.", "Erro!", JOptionPane.ERROR_MESSAGE);
					txtValor.setBorder(new LineBorder(Color.RED));
				}	
				
			}
		});
		btnCadastrar.setBounds(10, 200, 138, 23);
		panel.add(btnCadastrar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instanciando obj 
				Jogos j = new Jogos();
				j.setNome(txtNome.getText());
				j.setClassificacao(cbClass.getSelectedItem().toString());
				j.setGenero(txtGenero.getText());
				j.setPlataforma(txtPlataforma.getText());
				j.setDesenvolvedora(txtDesenvolvedora.getText());
				j.setValor(Double.parseDouble(txtValor.getText()));
				
				 //Realizando alteração
				 a.alterar(codigo, j);
				 
				 //Atualizando tabela
				 table.setModel(a.selecionar());
				 
				 //Limpando campos
				 limpaCampos();
				 
				 //Botões
				 botoes();
	
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(158, 200, 89, 23);
		panel.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Excluindo
				a.excluir(codigo);
				
				//Atualizando tabela
				table.setModel(a.selecionar());
				
				//Limpando campos
				limpaCampos();
				
				//Botões
				botoes();
				
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(257, 200, 89, 23);
		panel.add(btnExcluir);
		
	    btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(356, 200, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Resetando campos
				limpaCampos();
				
				//Botões
				botoes();
				
			}
		});
		
		panel.add(btnCancelar);
		
		JLabel lblClassificacao = new JLabel("Classificacao");
		lblClassificacao.setBounds(221, 52, 82, 14);
		panel.add(lblClassificacao);
		
		
		cbClass.setBounds(300, 49, 96, 20);
		panel.add(cbClass);
		
		JLabel lblDesenvolvedora = new JLabel("Desenvolvedora");
		lblDesenvolvedora.setBounds(10, 101, 112, 14);
		panel.add(lblDesenvolvedora);
		
		txtDesenvolvedora = new JTextField();
		txtDesenvolvedora.setBounds(105, 98, 96, 20);
		panel.add(txtDesenvolvedora);
		txtDesenvolvedora.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(242, 24, 46, 14);
		panel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(300, 24, 96, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(221, 77, 82, 14);
		panel.add(lblQuantidade);
		
		
		
		panel.add(spinner);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Produtos listados", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_1.setBounds(10, 265, 804, 226);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 784, 192);
		panel_1.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				//Obter indice da tabela
				int indice = table.getSelectedRow();
				//Armazenando indice
				codigo = indice;
				//Selecionando dados
		        txtNome.setText(table.getValueAt(codigo, 0).toString());
		        txtGenero.setText(table.getValueAt(codigo, 2).toString());
		        txtPlataforma.setText(table.getValueAt(codigo, 3).toString());
		        txtDesenvolvedora.setText(table.getValueAt(codigo, 4).toString());
		        txtValor.setText(table.getValueAt(codigo, 5).toString());
		        spinner.setValue(table.getValueAt(codigo, 6));
		        
				String classificacao = table.getValueAt(codigo, 1).toString();
				switch (classificacao) {
				
				case "Livre":
					cbClass.setSelectedIndex(1);
				break;
				case "+10":
					cbClass.setSelectedIndex(2);
				break;
				case "+12":
					cbClass.setSelectedIndex(3);
				break;
				case "+14":
					cbClass.setSelectedIndex(4);
				break;
				case "+16":
					cbClass.setSelectedIndex(5);
				break;
				case "+18":
					cbClass.setSelectedIndex(6);
				break;
				}
				
				//Botões
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(true);
				
				
				
			}
		});
		
		table.setModel(a.selecionar());
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Usu\u00E1rios cadastrados", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_2.setBounds(475, 11, 339, 211);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(10, 31, 319, 169);
		panel_2.add(scrollPane_1);
		
		tabela_usuario = new JTable();
		tabela_usuario.setModel(a.usuario());
		
		scrollPane_1.setViewportView(tabela_usuario);
	
		
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object [] a = new Object[] {"Ok","Cancelar"};
				
				int op = JOptionPane.showOptionDialog(null, "Realmente deseja sair?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE , null, a, 0);
				switch (op) {
				
				case 0:
					//Instanciando obj
					Login log = new Login();
					
					setVisible(false);
					log.setVisible(true);
					
				break;
			
				}
			}
		});
		btnSair.setBounds(612, 233, 89, 23);
		contentPane.add(btnSair);

	}
	
	//Botões
	private void botoes() {
		//Botões
		btnCadastrar.setEnabled(true);
		btnAlterar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
	
	
	
}
