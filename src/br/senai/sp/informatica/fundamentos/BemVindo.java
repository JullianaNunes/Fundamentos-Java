package br.senai.sp.informatica.fundamentos;

import javax.swing.JOptionPane;

public class BemVindo {
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Informe seu nome:");
        JOptionPane.showMessageDialog(null, "Bem Vindo, " + nome);         
	}
}
