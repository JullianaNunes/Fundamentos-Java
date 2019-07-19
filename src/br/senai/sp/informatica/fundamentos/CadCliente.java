package br.senai.sp.informatica.fundamentos;

import javax.swing.JOptionPane;

public class CadCliente {

	public static void main(String[] args) {
       Cliente novoCliente = new Cliente();
       
       novoCliente.setNome(JOptionPane.showInputDialog("informe o seu nome querido:"));
       novoCliente.setEmail(JOptionPane.showInputDialog("informe o seu e-mail:"));
       
       String temp = JOptionPane.showInputDialog("Agora informe sua idade:");
       //Conversão de String para Int
       novoCliente.setIdade(Integer.parseInt(temp));
       	
	   JOptionPane.showMessageDialog(null, novoCliente);
	}
}