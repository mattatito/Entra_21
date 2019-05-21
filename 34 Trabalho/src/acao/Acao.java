package acao;

import javax.swing.JOptionPane;

import beans.Log;
import dados.Dados;
import formulario.Loja;
import formulario.Login;

public class Acao {

	//Login
	public void Login(String login, String senha) {
		
		Dados.arrayLogin.get(0).setLogin("admin");
		Dados.arrayLogin.get(0).setSenha("admin");
		
		for (int i = 0; i < Dados.arrayLogin.size(); i++) {
				
				//Se o array encontrar o usuário e a senha, logará
			if (login.equals(Dados.arrayLogin.get(i).getLogin()) && senha.equals(Dados.arrayLogin.get(i).getSenha())) {
					
				
				//Intanciando obj
				Loja l = new Loja();
				Login lo = new Login();
				
				lo.setVisible(false);
				l.setVisible(true);
				
			}else {
				//Se o login e a senha forem iguais ao login de adm
				
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");
				
			}
			
		}		
		
	}
	
	//Cadastrar
	public void cadastrar(Log l) {
		
		Dados.arrayLogin.add(l);
		
	}
	
	
	
}
