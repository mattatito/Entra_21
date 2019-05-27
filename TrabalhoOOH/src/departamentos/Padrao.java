package departamentos;

import javax.swing.JOptionPane;

public class Padrao {

	// Atributos

	private double valor,valorTotal;
	
	//Construtor
	public Padrao (double valor, double valorTotal) {
	
		this.valorTotal = valorTotal * 0.90;
       
	}
	
	public void calculo(double valor, double valorTotal) {
		
		double troco;
		
		 if (valor >= valorTotal) {
			 
        troco = valor - valorTotal;
        
        valorTotal = valorTotal *0.90;
        
        JOptionPane.showMessageDialog(null, "Total de "+valorTotal+" em 6x de "+valor+"."
        +"\nO seu troco é de: R$"+troco+" Obrigado pela compra tenha um bom dia",null, JOptionPane.PLAIN_MESSAGE);
		
		}
		
	}

	//Set & Get


	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
}
