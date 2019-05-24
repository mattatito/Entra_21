package acao;

import javax.swing.table.DefaultTableModel;

import beans.Jogos;
import dados.Dados;

public class AcaoJogos {

	// Cadastrar
	public void cadastrar1(Jogos j) {
		
		Dados.arrayJogo.add(j);
		
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
						
				});
				
			}
			
			return modelo;
		}
	
	
	
}
