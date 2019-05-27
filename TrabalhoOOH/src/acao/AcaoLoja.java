package acao;

import javax.swing.table.DefaultTableModel;

import dados.Dados;

public class AcaoLoja {

	//Selecionar
	public DefaultTableModel selecionar() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Gênero");
		modelo.addColumn("Plataforma");
		modelo.addColumn("Valor");
		
			for (int i = 0; i < Dados.arrayJogo.size(); i++) {
				
				modelo.addRow(new Object[] {
						Dados.arrayJogo.get(i).getNome(),
						Dados.arrayJogo.get(i).getGenero(),
						Dados.arrayJogo.get(i).getPlataforma(),
						Dados.arrayJogo.get(i).getValor(),
						
				}
				);
				
			}
			
		return modelo;
	}
	
	// Selecionar dados tabela do carrinho
	public DefaultTableModel selecionar1(int indice) {
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Nome");
		modelo.addColumn("Valor");
		
			for (int i = 0; i < indice; i++) {
				modelo.addRow(new Object[] {
						
						Dados.arrayJogo.get(i).getNome(),
						Dados.arrayJogo.get(i).getValor(),
						
				});
			}
		return modelo;
	}
	
	
	//Buscar por plataforma
	public void busca(String coisa) {
		
		for (int i = 0; i < Dados.arrayJogo.size(); i++) {
			
			if (coisa.equals(Dados.arrayJogo.get(i).getPlataforma())) {
				
					
				
				break;
			}
			
		}
		
	}
	
	
	//Selecionar Busca plataforma
		public DefaultTableModel buscaPL(String coisa) {
			
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Gênero");
			modelo.addColumn("Plataforma");
			modelo.addColumn("Valor");
			
				for (int i = 0; i < Dados.arrayJogo.size(); i++) {
					
					if (coisa.equals(Dados.arrayJogo.get(i).getPlataforma())) {
						
					modelo.addRow(new Object[] {
							
							Dados.arrayJogo.get(i).getNome(),
							Dados.arrayJogo.get(i).getGenero(),
							Dados.arrayJogo.get(i).getPlataforma(),
							Dados.arrayJogo.get(i).getValor(),
							
					  }
					 );
					}
					
				}
				
			return modelo;
		}
		
		//Selecionar busca Genero
		public DefaultTableModel buscaGE(String coisa) {
			
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Gênero");
			modelo.addColumn("Plataforma");
			modelo.addColumn("Valor");
			
				for (int i = 0; i < Dados.arrayJogo.size(); i++) {
					
					if (coisa.equals(Dados.arrayJogo.get(i).getGenero())) {
						
					modelo.addRow(new Object[] {
							
							Dados.arrayJogo.get(i).getNome(),
							Dados.arrayJogo.get(i).getGenero(),
							Dados.arrayJogo.get(i).getPlataforma(),
							Dados.arrayJogo.get(i).getValor(),
							
					  }
					 );
					}
					
				}
				
			return modelo;
		}
	
		//Selecionar default
		public DefaultTableModel buscaCL(String coisa) {
			
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Gênero");
			modelo.addColumn("Plataforma");
			modelo.addColumn("Valor");
			
				for (int i = 0; i < Dados.arrayJogo.size(); i++) {
					
					if (coisa.equals(Dados.arrayJogo.get(i).getClassificacao())) {
						
					modelo.addRow(new Object[] {
							
							Dados.arrayJogo.get(i).getNome(),
							Dados.arrayJogo.get(i).getGenero(),
							Dados.arrayJogo.get(i).getPlataforma(),
							Dados.arrayJogo.get(i).getValor(),
							
					  }
					 );
					}
					
				}
				
			return modelo;
		}
		
		
}
