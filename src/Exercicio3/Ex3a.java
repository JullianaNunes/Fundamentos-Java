package Exercicio3;

import javax.swing.JOptionPane;
import static br.senai.sp.informatica.lib.SwUtil.*;

public class Ex3a {
	public static void main(String[] args) {
			
	   int num1 = leInteiro("Informe o primeiro n�mero:");
		
	   int num2 = leInteiro("Informe o segundo n�mero:");
	   
		if (num1 == num2) {
			JOptionPane.showMessageDialog(null,"Os n�meros s�o iguais!");
		}
		else { 
			JOptionPane.showMessageDialog(null,"Os n�meros s�o diferentes");
		}
		
}
}