package Exercicios1;

import javax.swing.JOptionPane;

public class Calcule1 {
	public static void main(String[] args) {
 
		String numx = JOptionPane.showInputDialog("Informe o primeiro n�mero:");
		double num1 = Double.parseDouble(numx);
		
		
		String numy = JOptionPane.showInputDialog("Informe o segundo n�mero:");
		double num2 = Double.parseDouble(numy);
		
		JOptionPane.showMessageDialog(null, "O primeiro n�mero � " + num1 + "\n O segundo n�mero � " + num2); 
		
		// Math.pow � usado para potencia��o
	  double total = Math.pow(num1, num2);
	
		JOptionPane.showMessageDialog(null, " O total � " + total);

	}

}
