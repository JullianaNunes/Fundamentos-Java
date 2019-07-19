
package Exercicio2;

import javax.swing.JOptionPane;

public class Exs2ex1 {
	public static void main(String[] args) {
	
		String num = JOptionPane.showInputDialog("Informe a largura da piscina:");
		double largura = Double.parseDouble(num);
			
		num = JOptionPane.showInputDialog("Informe a comprimento da piscina:");
		double comprimento = Double.parseDouble(num);
		
		num = JOptionPane.showInputDialog("Informe a profundidade da piscina:");
		double profundidade = Double.parseDouble(num);
		
		double preco = (largura * comprimento * profundidade) * 45.00;
		
		JOptionPane.showMessageDialog(null, "O preço final é de R$" + preco);
		
	}
			
}
