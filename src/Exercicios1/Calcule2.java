package Exercicios1;

import javax.swing.JOptionPane;

public class Calcule2 {

	public static void main (String [] args) {
		double media;
	
		String prova1 = JOptionPane.showInputDialog("Informe a primeira nota:");
		double nota1 = Double.parseDouble(prova1);
		
		String prova2 = JOptionPane.showInputDialog("Informe a segunda nota:");
		double nota2 = Double.parseDouble(prova2);
		
		String prova3 = JOptionPane.showInputDialog("Informe a terceira nota:");
		double nota3 = Double.parseDouble(prova3);
		
		String prova4 = JOptionPane.showInputDialog("Informe a quarta nota:");
		double nota4 = Double.parseDouble(prova4);
		
		media = (nota1 + nota2 + nota3 + nota4) / 4;
				
		JOptionPane.showMessageDialog(null, "A média é: " + media);
	}
}
