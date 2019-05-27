package formulario;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.AcaoLogin;
import acao.AcaoLoja;
import dados.Dados;
import departamentos.APrazo;
import departamentos.Padrao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Loja extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtDesenvolvedora;
	

	private JTable table;
	private JTable tablePl;
	
	private int indice;
	private int contador;
	
	private double contador2;
	
	private JTextField txtPlataforma;
	private JTextField txtValor;
	private JTextField txtClassificacao;

	private JTextField txtQTD;
	private JTextField txtInserir;
	private JTextField txtTotal;
	
	//PAINEL CONTA
	private JTextField txtNomeUsuario;
	private JTextField txtEmailUsuario;
	private JTextField txtSenhaUsuario;
	private JTextField txtLoginUsuario;

	//Botão
	private JButton btnComprar;
	
	public Loja() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Gamer\\Desktop\\lupa.png"));
		
		//Instanciando obj
		AcaoLoja a = new AcaoLoja();
		
		
		//Painel
		JPanel conta = new JPanel();
		conta.setVisible(false);
		
		JPanel panel = new JPanel();
		
		JPanel painel_Carrinho = new JPanel();
		painel_Carrinho.setVisible(false);
		panel.add(painel_Carrinho);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 628);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(10, 11, 804, 567);
		contentPane.add(panel);
		//Adicionando Painel_Conta ao painel
		panel.add(painel_Carrinho);
		panel.add(conta);
		panel.setLayout(null);

		JPanel pLoja = new JPanel();
		JLabel lblConta = new JLabel("CONTA");
		JLabel lblCarrinho = new JLabel("CARRINHO");
		JLabel lblLoja = new JLabel("LOJA");
		
		
		
		
		lblConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//AÇÃO LABEL CONTA
				
				pLoja.setVisible(false);
				lblCarrinho.setForeground(Color.LIGHT_GRAY);
				lblConta.setForeground(Color.WHITE);
				lblLoja.setForeground(Color.LIGHT_GRAY);
	
				
				
				painel_Carrinho.setVisible(true);
				painel_Carrinho.setVisible(false);
				conta.setVisible(true);
				
				
			}
		});
		
		
		
		lblLoja.setBackground(SystemColor.window);
		lblLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// AÇÃO DA LABEL
				
				pLoja.setVisible(true);
				painel_Carrinho.setVisible(false);
				//painel_Conta.setVisible(false);
				
			
				lblCarrinho.setForeground(Color.LIGHT_GRAY);
				lblConta.setForeground(Color.LIGHT_GRAY);
				lblLoja.setForeground(Color.WHITE);
				
				//Instanciando obj
				
				painel_Carrinho.setVisible(false);
				conta.setVisible(false);
				
				
			}
		});
		lblLoja.setBounds(27, 11, 85, 34);
		panel.add(lblLoja);
		lblLoja.setForeground(Color.WHITE);
		lblLoja.setFont(new Font("Arial", Font.PLAIN, 20));

		
		pLoja.setBackground(SystemColor.activeCaptionBorder);
		pLoja.setBounds(0, 50, 804, 520);
		panel.add(pLoja);
		pLoja.setLayout(null);



		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] ob = new Object[] {"Plataforma","Classificação", "Gênero"};
				
				int op = JOptionPane.showOptionDialog(null, "Buscar por..", "Buscar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, ob, 0);
				
				switch (op) {
				
				case 0:
					
					String resposta = JOptionPane.showInputDialog("Pesquisar..");
					table.setModel(a.buscaPL(resposta));
					
				break;
				
				case 1:
					
					String resposta1 = JOptionPane.showInputDialog("Pesquisar..");
					table.setModel(a.buscaCL(resposta1));
					
				break;
				
				case 2:
					String resposta2 = JOptionPane.showInputDialog("Pesquisar..");
					table.setModel(a.buscaGE(resposta2));
					
				break;
				
				}
				
				
				
			}
		});
		btnBuscar.setBounds(700, 29, 100, 31);
		pLoja.add(btnBuscar);

		JButton btnAtt = new JButton("Todos os produtos");
		btnAtt.setBounds(500, 29, 150, 31);
		btnAtt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(a.selecionar());
				
			}
		});
		
		pLoja.add(btnAtt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 66, 784, 443);
		pLoja.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProdutos = new JLabel("JOGOS");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProdutos.setBounds(340, 16, 115, 27);
		panel_1.add(lblProdutos);
		
		JPanel painel_Informacoes = new JPanel();
		painel_Informacoes.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Informacoes.setBackground(Color.WHITE);
		painel_Informacoes.setBounds(31, 212, 730, 220);
		panel_1.add(painel_Informacoes);
		painel_Informacoes.setLayout(null);
		
		JLabel lblInformaes = new JLabel("INFORMA\u00C7\u00D5ES");
		lblInformaes.setBounds(289, 11, 231, 27);
		painel_Informacoes.add(lblInformaes);
		lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(65, 57, 46, 14);
		painel_Informacoes.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(105, 54, 279, 20);
		painel_Informacoes.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setBounds(49, 82, 46, 14);
		painel_Informacoes.add(lblGnero);
		
		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setBounds(105, 79, 279, 20);
		painel_Informacoes.add(txtGenero);
		txtGenero.setColumns(10);
		
		JLabel lblDesenvolvedora = new JLabel("Desenvolvedora:");
		lblDesenvolvedora.setBounds(10, 106, 101, 14);
		painel_Informacoes.add(lblDesenvolvedora);
		
		txtDesenvolvedora = new JTextField();
		txtDesenvolvedora.setEditable(false);
		txtDesenvolvedora.setBounds(105, 103, 279, 20);
		painel_Informacoes.add(txtDesenvolvedora);
		txtDesenvolvedora.setColumns(10);
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		lblPlataforma.setBounds(32, 132, 74, 14);
		painel_Informacoes.add(lblPlataforma);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setEditable(false);
		txtPlataforma.setBounds(105, 131, 279, 20);
		painel_Informacoes.add(txtPlataforma);
		txtPlataforma.setColumns(10);
		
		JButton btnCarrinho = new JButton("Adicionar ao carrinho");
		btnCarrinho.setEnabled(false);
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Adicionando ao carrinho
				
				// contando o total de produtos adicionados ao carrinho
				contador++;
				txtQTD.setText(String.valueOf(contador));
				
				//Calculando o valor total dos produtos 
				contador2 += Dados.arrayJogo.get(indice).getValor();
				txtTotal.setText(String.valueOf(contador2));
				
				//Botão de compra
				btnComprar.setEnabled(true);
				
				//Mensagem
				JOptionPane.showMessageDialog(null, "Já está no seu carrinho :)");
				
			}
		});
		btnCarrinho.setBounds(473, 157, 170, 48);
		painel_Informacoes.add(btnCarrinho);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(49, 157, 46, 14);
		painel_Informacoes.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBounds(105, 157, 279, 20);
		painel_Informacoes.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o ");
		lblClassificao.setBounds(21, 182, 94, 14);
		painel_Informacoes.add(lblClassificao);
		
		txtClassificacao = new JTextField();
		txtClassificacao.setEditable(false);
		txtClassificacao.setBounds(105, 179, 279, 20);
		painel_Informacoes.add(txtClassificacao);
		txtClassificacao.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 54, 730, 147);
		
		panel_1.add(scrollPane);
		
		//tabela da busca
		tablePl = new JTable();
		
		//Tabela para compra do usuário
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				//Obtendo índice
				
				indice = table.getSelectedRow();
				
				txtNome.setText(table.getValueAt(indice, 0).toString());
				txtDesenvolvedora.setText(Dados.arrayJogo.get(indice).getDesenvolvedora());
				txtGenero.setText(table.getValueAt(indice, 1).toString());
				txtPlataforma.setText(table.getValueAt(indice, 2).toString());
				
				txtValor.setText(table.getValueAt(indice, 3).toString());
				
				txtClassificacao.setText(Dados.arrayJogo.get(indice).getClassificacao());
				
				btnCarrinho.setEnabled(true);
				
				
			}
		});
		table.setModel(a.selecionar());
		
		scrollPane.setViewportView(table);
		
		JLabel lblBoasCompras = new JLabel("BOAS COMPRAS!!");
		lblBoasCompras.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblBoasCompras.setBounds(45, 11, 268, 49);
		pLoja.add(lblBoasCompras);

		
		
		lblCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				painel_Carrinho.setVisible(true);
				//AÇÃO
				pLoja.setVisible(false);
				lblCarrinho.setForeground(Color.WHITE);
				lblConta.setForeground(Color.LIGHT_GRAY);
				lblLoja.setForeground(Color.LIGHT_GRAY);
				
				//Instanciando obj
				painel_Carrinho.setVisible(true);
				conta.setVisible(false);
				
				
			}
		});
		lblCarrinho.setForeground(Color.LIGHT_GRAY);
		lblCarrinho.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCarrinho.setBackground(Color.LIGHT_GRAY);
		lblCarrinho.setBounds(131, 11, 117, 34);
		panel.add(lblCarrinho);
		
		
		lblConta.setForeground(Color.LIGHT_GRAY);
		lblConta.setFont(new Font("Arial", Font.PLAIN, 20));
		lblConta.setBackground(Color.LIGHT_GRAY);
		lblConta.setBounds(677, 11, 117, 34);
		panel.add(lblConta);

		
	 
		
		//
		painel_Carrinho.setBounds(0, 50, 804, 520);
		painel_Carrinho.setBackground(SystemColor.activeCaptionBorder);
		painel_Carrinho.setLayout(null);
		JPanel painelCompra = new JPanel();
		painelCompra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados da Compra", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		painelCompra.setBounds(10, 66, 784, 244);
		painel_Carrinho.add(painelCompra);
		painelCompra.setLayout(null);
		
		JLabel lblQuantidadeDeJogos = new JLabel("Quantidade de jogos adicionados");
		lblQuantidadeDeJogos.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuantidadeDeJogos.setBounds(52, 39, 250, 19);
		painelCompra.add(lblQuantidadeDeJogos);
		
		txtQTD = new JTextField();
		txtQTD.setEditable(false);
		txtQTD.setBounds(294, 39, 56, 20);
		painelCompra.add(txtQTD);
		txtQTD.setColumns(10);
		
		
		JLabel lblInsiraUmValor = new JLabel("Insira um valor");
		lblInsiraUmValor.setBounds(45, 117, 100, 19);
		painelCompra.add(lblInsiraUmValor);
		
		txtInserir = new JTextField();
		txtInserir.setBounds(130, 116, 86, 20);
		painelCompra.add(txtInserir);
		txtInserir.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(130, 86, 86, 20);
		painelCompra.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(94, 89, 46, 14);
		painelCompra.add(lblTotal);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(127, 147, 89, 23);
		btnComprar.setEnabled(false);
		
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				double pagamento = Double.parseDouble(txtInserir.getText());
				double TotPag = Double.parseDouble(txtTotal.getText());
				int TotQtd = 0;
				
				TotQtd = Integer.parseInt(txtQTD.getText());
				
				if (pagamento >= TotPag) {
					
					//Opções do pane
	               Object[] ob = new Object[] {"A vista", "A prazo"};
	                    
	               int op = JOptionPane.showOptionDialog(null, "Forma de pagamento", "Pagamento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[0]);
	               
	               switch (op) {
	               
	               case 0:
	            	   //Se for A VISTA
	            	   Padrao p = new Padrao(TotQtd, pagamento);
	            	   p.calculo(pagamento, TotPag);
	            	   txtQTD.setText("0");
            		   txtTotal.setText("0");
            		   
	               break;
	               
	               case 1:
	            	   
	            	   //Se for A prazo
	            	   
	            	   Object[] r = new Object[] {"6x", "12x"};
	                    
		               int o = JOptionPane.showOptionDialog(null, "Número de parcelas", "Pagamento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, r, r[0]);
	            	   switch (o) {
	            	   
	            	   case 0:
	            		   
	            		   APrazo Aprazo = new APrazo(pagamento, 6, TotPag); 
	            		   Aprazo.calculo(pagamento, 6, TotPag);
	            		   txtQTD.setText("0");
	            		   txtTotal.setText("0");
	            		   
	            		   
	                   break;
	            	   
	            	   case 1:
	            		   
	            		   APrazo Apra = new APrazo(pagamento, 6, TotPag); 
	            		   Apra.calculo(pagamento, 12, TotPag);
	            		   
	            		   txtQTD.setText("0");
	            		   txtTotal.setText("0");
	            		   
	            	   break;
	            	   
	            	   }
	            	   
	               break;
	               
	               }
	                    
	                int qtd = Dados.arrayJogo.get(indice).getQtd();
	                Dados.arrayJogo.get(indice).setQtd(qtd-1);
	                
	                if (Dados.arrayJogo.get(indice).getQtd() == 0) {
	                	
	                	Dados.arrayJogo.remove(indice);
	                	
	                }

	                }else {
	                    JOptionPane.showMessageDialog(null, "Pagamento Insuficiente",null, JOptionPane.WARNING_MESSAGE);
	                }
				}
		});
		
		painelCompra.add(btnComprar);	
		
		
		// PAINEL DA CONTA 
		
		//Instanciando obj
		AcaoLogin lo = new AcaoLogin();
		
		
	
		 conta.setBounds(0, 50, 804, 520);
		 conta.setBackground(SystemColor.activeCaptionBorder);
		 conta.setLayout(null);
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados da Conta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBounds(10, 66, 784, 309);
		 conta.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnUsuario = new JButton("");
		btnUsuario.setEnabled(false);
		btnUsuario.setIcon(new ImageIcon("D:\\Downloads\\icons8-usu\u00E1rio-100.png"));
		btnUsuario.setBounds(465, 40, 227, 245);
		panel_2.add(btnUsuario);
		
		JLabel lblNome1 = new JLabel("Nome");
		lblNome1.setBounds(54, 40, 46, 14);
		panel_2.add(lblNome1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(54, 106, 46, 14);
		panel_2.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(54, 142, 46, 14);
		panel_2.add(lblSenha);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setEditable(false);
		txtNomeUsuario.setText(Dados.arrayLogin.get(lo.contador).getNome());
		txtNomeUsuario.setBounds(100, 40, 156, 20);
		panel_2.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		txtEmailUsuario = new JTextField();
		txtEmailUsuario.setText(Dados.arrayLogin.get(lo.contador).getEmail());
		txtEmailUsuario.setEditable(false);
		txtEmailUsuario.setBounds(100, 103, 156, 20);
		panel_2.add(txtEmailUsuario);
		txtEmailUsuario.setColumns(10);
		
		txtSenhaUsuario = new JTextField();
		txtSenhaUsuario.setText(Dados.arrayLogin.get(lo.contador).getSenha());
		txtSenhaUsuario.setEditable(false);
		txtSenhaUsuario.setBounds(100, 139, 156, 20);
		panel_2.add(txtSenhaUsuario);
		txtSenhaUsuario.setColumns(10);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de Usu\u00E1rio");
		lblNomeDeUsurio.setBounds(5, 74, 107, 14);
		panel_2.add(lblNomeDeUsurio);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setText(Dados.arrayLogin.get(lo.contador).getLogin());
		txtLoginUsuario.setEditable(false);
		txtLoginUsuario.setBounds(100, 71, 156, 20);
		panel_2.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);
		
		JButton btnAtualizarDados = new JButton("Atualizar dados");
		btnAtualizarDados.setBounds(33, 175, 130, 23);
		panel_2.add(btnAtualizarDados);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnAtualizarDados.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				txtLoginUsuario.setEditable(true);
				txtSenhaUsuario.setEditable(true);
				txtNomeUsuario.setEditable(true);
				txtEmailUsuario.setEditable(true);
				
				btnSalvar.setEnabled(true);
				btnAtualizarDados.setEnabled(false);
				
			}
		});
		
		JLabel lblNOME = new JLabel("");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(165, 175, 113, 23);
		
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object[] aa = new Object[] {"Sim","Cancelar"};
				int op = JOptionPane.showOptionDialog(null, "Deseja salvar os dados?", "AVISO!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, aa, 0);
				
				switch (op) {
				
				case 0:
					
					//Atualizando dados
					Dados.arrayLogin.get(contador).setEmail(txtEmailUsuario.getText());
					Dados.arrayLogin.get(contador).setLogin(txtLoginUsuario.getText());
					Dados.arrayLogin.get(contador).setSenha(txtSenhaUsuario.getText());
					Dados.arrayLogin.get(contador).setNome(txtNomeUsuario.getText());
					lblNOME.setText(Dados.arrayLogin.get(contador).getNome());
					
					//Não possibilita a edição
					txtLoginUsuario.setEditable(false);
					txtSenhaUsuario.setEditable(false);
					txtNomeUsuario.setEditable(false);
					txtEmailUsuario.setEditable(false);
					
					//Enable
					btnSalvar.setEnabled(false);
					btnAtualizarDados.setEnabled(true);
					
				break;
				
				case 1:
					
					txtLoginUsuario.setEditable(false);
					txtSenhaUsuario.setEditable(false);
					txtNomeUsuario.setEditable(false);
					txtEmailUsuario.setEditable(false);
					
					txtLoginUsuario.setText(Dados.arrayLogin.get(contador).getLogin());
					txtSenhaUsuario.setText(Dados.arrayLogin.get(contador).getSenha());
					txtNomeUsuario.setText(Dados.arrayLogin.get(contador).getNome());
					txtEmailUsuario.setText(Dados.arrayLogin.get(contador).getEmail());
					
					
					btnSalvar.setEnabled(false);
					btnAtualizarDados.setEnabled(true);
				break;
				
				}
				
				
			}
		});
		
		panel_2.add(btnSalvar);
		
		JButton btnDeletarConta = new JButton("Deletar Conta");
		btnDeletarConta.addActionListener(new ActionListener() { 
			
			//DELETANDO CONTA
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
		btnDeletarConta.setBounds(330, 270, 120, 23);
		
		JButton sair = new JButton("Sair");
		sair.setBounds(335, 245, 107, 23);
		sair.addActionListener(new ActionListener() {
			//SE A PESSOA QUISER SAIR
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object[] op = new Object[] {"Sim", "Não"};
				
				int escolha = JOptionPane.showOptionDialog(null, "Deseja mesmo sair da sua conta?", "AVISO!!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null , op, 0);
				
				switch (escolha) {
				
				case 0:
										
					setVisible(false);
					
				break;
				
				}
				
			}
		});
		
		panel_2.add(sair);
		panel_2.add(btnDeletarConta);
		
		
		lblNOME.setText(Dados.arrayLogin.get(lo.contador).getNome());
		
		lblNOME.setFont(new Font("Arial", Font.BOLD, 16));
		lblNOME.setBounds(31, 11, 575, 52);
		 conta.add(lblNOME);
		
				
		
		
	}
}

