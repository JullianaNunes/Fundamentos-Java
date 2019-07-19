package Exercicios1;

import javax.swing.JOptionPane;

public class Calcule3 {
	public static void main (String [] args) {
		double area;
		
		String bs = JOptionPane.showInputDialog("Informe o valor da base do triangulo:");
		double base= Double.parseDouble(bs);
		
		String al = JOptionPane.showInputDialog("Informe o valor da altura do triangulo:");
		double altura= Double.parseDouble(al);
		
		area = (base * altura)/2;
		
		JOptionPane.showMessageDialog(null, "A área do triângulo é " + area);
	}

}
