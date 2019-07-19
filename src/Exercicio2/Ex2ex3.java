package Exercicio2;

import javax.swing.JOptionPane;

public class Ex2ex3 {
	public static void main (String[] args) {
		
		String saque = JOptionPane.showInputDialog("Informe o valor para saque:");
		int a = Integer.parseInt(saque);
	    
		
		int y = a / 100;
		int b = (a %= 100)/  50;
        int c =  (a %= 50) / 20;
        int d = (a %= 20) / 10;
        int e = (a %= 10) / 5;
        int f = (a %= 5) / 2;
        int j = a;
         
        
        JOptionPane.showMessageDialog(null, "\nValor do saque: " + saque + "\nNotas de 100: " + y + "\nNotas de 50: " + b + "\nNotas de 20: " + c + "\nNotas de 10: " + d + "\nNotas de 5: " + e + "\nNotas de 2: " + f + "\nNotas de 1: " + j);        
        
	}
}

