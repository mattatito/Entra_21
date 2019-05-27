package acao;

import javax.swing.table.DefaultTableModel;

import beans.Jogos;
import dados.Dados;

public class AcaoJogos {

	// Cadastrar
	public void cadastrar1(Jogos j) {
		Dados.arrayJogo.add(j);
		
	}
	
	// Alterar
	public void alterar(int indice, Jogos j) {
		
		Dados.arrayJogo.set(indice, j);
		
	}
	
	// Excluir
	public void excluir(int indice) {
		Dados.arrayJogo.remove(indice);
	}
	
	//Selecionar usuários
	    public DefaultTableModel usuario() {
	    	
	    	DefaultTableModel usuario = new DefaultTableModel();
	    	usuario.addColumn("Nome");
	    	usuario.addColumn("Email");
	    	
	    		for (int i = 0; i< Dados.arrayLogin.size(); i++) {
	    			usuario.addRow(new Object[] {
	    					
	    					Dados.arrayLogin.get(i).getNome(),
	    					Dados.arrayLogin.get(i).getEmail(),
	    					
	    			});
	    		}
	    		
	    		
	    		return usuario;
	    }
	
	//Selecionar
		public DefaultTableModel selecionar() {
			
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Classificacao");
			modelo.addColumn("Genero");
			modelo.addColumn("Plataforma");
			modelo.addColumn("Desenvolvedora");
			modelo.addColumn("Valor");
			modelo.addColumn("QTD Disponível");
			
			for (int i = 0; i < Dados.arrayJogo.size(); i++) {
				modelo.addRow(new Object[] {
						Dados.arrayJogo.get(i).getNome(),
						Dados.arrayJogo.get(i).getClassificacao(),
						Dados.arrayJogo.get(i).getGenero(),
						Dados.arrayJogo.get(i).getPlataforma(),
						Dados.arrayJogo.get(i).getDesenvolvedora(),
						Dados.arrayJogo.get(i).getValor(),
						Dados.arrayJogo.get(i).getQtd(),
						
				});
				
			}
			
			return modelo;
		}
	
	
	
}
