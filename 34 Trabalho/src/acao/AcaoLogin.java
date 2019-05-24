package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Log;
import dados.Dados;
import formulario.Loja;
import formulario.Login;

public class AcaoLogin {

	// Login
	public void Login(String login, String senha) {

		for (int i = 0; i < Dados.arrayLogin.size(); i++) {

			// Se o array encontrar o usuário e a senha, logará
			if (login.equals(Dados.arrayLogin.get(i).getLogin()) && senha.equals(Dados.arrayLogin.get(i).getSenha())) {

				// Intanciando obj
				Loja l = new Loja();
				Login lo = new Login();

				lo.setVisible(false);
				l.setVisible(true);
				
				break;

			} else {// Se não encontrar nenhum usuário cadastrado
				
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");

			}

		}

	}

	// Cadastrar Logins
	public void cadastrar(Log l) {
		
		Dados.arrayLogin.add(l);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

	}
	
	

}
