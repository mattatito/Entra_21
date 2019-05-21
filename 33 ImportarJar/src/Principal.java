import javax.swing.JOptionPane;

import pacote.Texto;

public class Principal {


	public static void main(String[] args) {
	
		
		String a = JOptionPane.showInputDialog("Insira uma palavra");
		
		
		Texto t = new Texto(a);
		t.contarLetras();

	}

}
