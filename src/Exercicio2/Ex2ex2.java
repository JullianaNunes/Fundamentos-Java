package Exercicio2;

import javax.swing.JOptionPane;

public class Ex2ex2 {
	public static void main(String[] args) {
		
		String num = JOptionPane.showInputDialog("Informe um número:");
		int n = Integer.parseInt(num);
		
		int a = n/10;
		int b = a/10;
		
		
		int d = n % 10;			
		int e = a % 10;	
		int f = b % 10;
		
		int numero = (d*100) + (e*10) + f;
		
		JOptionPane.showMessageDialog(null, "Número gerado: " + numero);
	
		
		
				
}
}