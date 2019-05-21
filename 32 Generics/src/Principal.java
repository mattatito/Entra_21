
public class Principal {
	
	
	/*
	  		VALORES GENÉRICOS
	  		
	  	E -> Tipos de classe 
	  	K -> Chave (Utilizado com HashMap)
	  	V -> Valor (Utilizado com HashMap)
	  	T -> Tipo (int, double, char)
	  	
     */
	
	
	//Método estático de exibição
	public static <E> void exibirDados(E[] vetor) {
  //E = tipo genérico; elemento = Posição do vetor
		for(E elemento : vetor) {
			System.out.println(elemento);
		}
		
	}
	
	// Método principal
	public static void main(String[] args) {
		
		/*
		   Generics só funciona com classes
		*/
		
		//Dados
		Integer[] dadosInt = {1,5,7,8};
		Double[] dadosDouble = {7.5, 8.3, 1.2};
		String[] dadosString = {"Computador", "Impressora"};

		//Exibir dados
		exibirDados(dadosInt);
		
		
		
		
	}

}
