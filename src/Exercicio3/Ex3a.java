package Exercicio3;

import javax.swing.JOptionPane;
import static br.senai.sp.informatica.lib.SwUtil.*;

public class Ex3a {
	public static void main(String[] args) {
			
	   int num1 = leInteiro("Informe o primeiro número:");
		
	   int num2 = leInteiro("Informe o segundo número:");
	   
		if (num1 == num2) {
			JOptionPane.showMessageDialog(null,"Os números são iguais!");
		}
		else { 
			JOptionPane.showMessageDialog(null,"Os números são diferentes");
		}
		
}
}