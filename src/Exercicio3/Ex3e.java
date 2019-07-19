package Exercicio3;

import static br.senai.sp.informatica.lib.SwUtil.*;

import javax.swing.JOptionPane;

public class Ex3e {
	public static void main (String[] args) {
		int n1 = leInteiro("Escreva o primeiro número:");
		int n2 = leInteiro("Escreva o segundo número:");
		
		if (n2 == n1 || n2 > n1) {
			JOptionPane.showMessageDialog(null, "Ordem em crescente: " + n1 + " e " + n2);
			
		}
		else { 
			JOptionPane.showMessageDialog(null, "Ordem em crescente: " + n2 + " e " + n1);
		}
	}

}
