package Exercicio4;

import static br.senai.sp.informatica.lib.SwUtil.*;
import javax.swing.JOptionPane;

public class Ex4c {

	public static void main(String[] args) {
		double sal = leReal("Digite o seu salário:");

		while (sal > 0)  {
			if (sal <= 500) {
				double aumento = sal * 0.20;
				aumento = sal + aumento;
				JOptionPane.showMessageDialog(null,
						String.format("Seu salário é de: R$ %,.2f" + " e o aumento fica R$ %,.2f", sal, aumento));
			} else {
				double aumento = sal * 0.10;
				aumento = sal + aumento;
				JOptionPane.showMessageDialog(null,
						String.format("Seu salário é de: R$ %,.2f" + " e o aumento fica R$ %,.2f", sal, aumento));
			}
			
			sal = leReal("Digite o seu salário:");
		} 
	}
}
