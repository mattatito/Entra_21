package acao;

import javax.swing.table.DefaultTableModel;

import dados.Dados;

public class AcaoLoja {

	//Selecionar
	public DefaultTableModel selecionar() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Gênero");
		modelo.addColumn("Desenvolvedora");
		modelo.addColumn("Valor");
		
			for (int i = 0; i < Dados.arrayJogo.size(); i++) {
				
				modelo.addRow(new Object[] {
						Dados.arrayJogo.get(i).getNome(),
						Dados.arrayJogo.get(i).getGenero(),
						Dados.arrayJogo.get(i).getDesenvolvedora(),
						Dados.arrayJogo.get(i).getValor(),
				}
				);
				
				
			}
		
		
		
		return modelo;
	}
	
	
	
	
}
