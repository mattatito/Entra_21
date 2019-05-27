package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import beans.Log;
import dados.Dados;
import formulario.Loja;
import formulario.Login;

public class AcaoLogin {
	
	public static int contador;
	// Login
	public void Login(String login, String senha) {
		
	if (Dados.arrayLogin.size() == 0) {
			JOptionPane.showMessageDialog(null, "Usuário Não Cadastrado");
	}else {
		
		for (int i = 0; i < Dados.arrayLogin.size(); i++) {
			
					System.out.println(login);
					System.out.println(senha);
					
					System.out.println("\nlogin"+Dados.arrayLogin.get(i).getLogin());
					System.out.println("\nSenha"+Dados.arrayLogin.get(i).getSenha());
					
			// Se o array encontrar o usuário e a senha, logará
			if (login.equals(Dados.arrayLogin.get(i).getLogin()) && senha.equals(Dados.arrayLogin.get(i).getSenha())) {
				
				// Intanciando obj
				Loja l = new Loja();
			   				
				contador = i;
				l.setVisible(true);
				System.out.println(contador);
				
				break;

			} else if (login.equals(Dados.arrayLogin.get(i).getLogin()) || senha.equals(Dados.arrayLogin.get(i).getSenha())) {
				
				JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos");
				break;
			}
			
		}
		
	}
		
	}

	// Cadastrar Logins
	public void cadastrar(Log l) {
		
		
		Dados.arrayLogin.add(l);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

	}

}
