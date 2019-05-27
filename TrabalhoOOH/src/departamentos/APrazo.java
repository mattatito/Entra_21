package departamentos;

import javax.swing.JOptionPane;

public class APrazo extends Padrao {

	//Atributos
	private double desconto;
	
	//Contrutor
	public APrazo(double valor, int parcela,double desconto) {
		super(parcela, valor);
		this.desconto = desconto * 0.85;
		
	}
	
	//Realizando o calculo A PRAZO
	public void calculo (double valor, int parcela, double desconto) {
		
	if (valor > desconto) {
			
		if (parcela == 6) {
			
		this.desconto = desconto * 0.85;
		double totValor = valor * 1.12;
		valor /= 6;
		double troco = valor - desconto;
		
		
		JOptionPane.showMessageDialog(null, "Total de "+totValor+" em 6x de "+valor+"."
				+"\nO seu troco é de: R$"+troco+" Obrigado pela compra tenha um bom dia",null, JOptionPane.PLAIN_MESSAGE);
		
		}else {
			this.desconto = desconto * 0.85;
			double totValor = valor * 1.24;
			valor /= 12;
			double troco = valor - desconto;
			
			JOptionPane.showMessageDialog(null, "Total de "+totValor+" em 12x de "+valor+"."
					+"\nO seu troco é de: R$"+troco+" Obrigado pela compra tenha um bom dia",null, JOptionPane.PLAIN_MESSAGE);
			
		}
	
	}else if(valor == desconto) {
		
		
		if (parcela == 6) {
			
		this.desconto = desconto * 0.85;
		double totValor = valor * 1.12;
		valor /= 6;
		
		JOptionPane.showMessageDialog(null, "Total de "+totValor+" em 6x de "+valor+".",null, JOptionPane.PLAIN_MESSAGE);
		
		}else {
			
			this.desconto = desconto * 0.85;
			double totValor = valor * 1.24;
			valor /= 12;
			
			JOptionPane.showMessageDialog(null, "Total de "+totValor+" em 12x de "+valor+".",null, JOptionPane.PLAIN_MESSAGE);
			
		}
		
	}
	
	}
	

	//Set & Get
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	
}
