package Exercicios1;

import javax.swing.JOptionPane;

public class Calcule1 {
	public static void main(String[] args) {
 
		String numx = JOptionPane.showInputDialog("Informe o primeiro número:");
		double num1 = Double.parseDouble(numx);
		
		
		String numy = JOptionPane.showInputDialog("Informe o segundo número:");
		double num2 = Double.parseDouble(numy);
		
		JOptionPane.showMessageDialog(null, "O primeiro número é " + num1 + "\n O segundo número é " + num2); 
		
		// Math.pow é usado para potenciação
	  double total = Math.pow(num1, num2);
	
		JOptionPane.showMessageDialog(null, " O total é " + total);

	}

}
