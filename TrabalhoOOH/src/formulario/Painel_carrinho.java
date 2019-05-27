package formulario;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painel_carrinho extends JPanel {
	private JTextField txtQTD;
	private JTextField txtInserir;
	private JTextField txtTotal;

	public Painel_carrinho() {
		
		setBounds(0, 50, 804, 520);
		setBackground(SystemColor.activeCaptionBorder);
		setLayout(null);
		JPanel painelCompra = new JPanel();
		painelCompra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados da Compra", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		painelCompra.setBounds(10, 66, 784, 244);
		add(painelCompra);
		painelCompra.setLayout(null);
		
		JLabel lblQuantidadeDeJogos = new JLabel("Quantidade de jogos adicionados");
		lblQuantidadeDeJogos.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuantidadeDeJogos.setBounds(52, 39, 245, 19);
		painelCompra.add(lblQuantidadeDeJogos);
		
		txtQTD = new JTextField();
		txtQTD.setEditable(false);
		txtQTD.setBounds(294, 39, 56, 20);
		painelCompra.add(txtQTD);
		txtQTD.setColumns(10);
		
		JScrollPane scrollJogos = new JScrollPane();
		scrollJogos.setBounds(381, 49, 309, 168);
		painelCompra.add(scrollJogos);
		
		JTable tableCarrinho = new JTable();
		scrollJogos.setViewportView(tableCarrinho);
		
		JLabel lblJogos = new JLabel("Jogos");
		lblJogos.setBounds(519, 22, 46, 19);
		painelCompra.add(lblJogos);
		
		JLabel lblInsiraUmValor = new JLabel("Insira um valor");
		lblInsiraUmValor.setBounds(52, 117, 100, 19);
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
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			double pagamento = Double.parseDouble(txtInserir.getText());
			double TotPag = Double.parseDouble(txtTotal.getText());
			double troco;
			int TotQtd= Integer.parseInt(txtQTD.getText());
			
				if ((pagamento >= TotPag) && (TotQtd != 0)) {
                    troco = pagamento - TotPag;

                JOptionPane.showMessageDialog(null, "O seu troco é de: R$"+troco+" Obrigado pela compra tenha um bom dia",null, JOptionPane.PLAIN_MESSAGE);

                }else {
                    JOptionPane.showMessageDialog(null, "Pagamento Insuficiente, sua compra foi cancelada",null, JOptionPane.WARNING_MESSAGE);
                }
				
				
				
			}
		});
		btnComprar.setBounds(127, 147, 89, 23);
		painelCompra.add(btnComprar);
		
	}
}
