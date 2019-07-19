package ExerciciosExtra;

import static br.senai.sp.informatica.lib.SwUtil.*;

import javax.swing.JOptionPane;

public class ExExtraa {
	public static void main (String[] args) {
		double salariohora = leReal("Digite o salario por hora:");
		double horas = leReal("Digite as horas trabalhadas:");
		double dependentes = leReal("Digite o n�mero de dependentes:");
		double inss, ir;
		
		// Sal�rio Bruto//
		double bruto = horas * salariohora + 50 * dependentes ;
		
		
		// Desconto INSS //
		if (bruto <= 1000) {
			inss = (bruto * 8.5) / 100;
		}
		else {
			inss = (bruto * 9) / 100;
		}
		
		
		// Desconto IR //
		if (bruto <= 500) {
			ir = 0;
		}
		else if (bruto <= 1000) {
			ir = (bruto * 5) / 100;
		}
		else {
			ir = (bruto * 7) / 100;
		}
		
		
		// Sal�rio l�quido
		double liquido = bruto - inss - ir;
		
//		escreva("C�lculo \n \nSal�rio por hora: " , salariohora , 
//		"\n N�mero de horas: " , horas, 
//		"\n N�mero de dependentes: " , dependentes, 
//		"\nSal�rio bruto: R$ " , bruto , 
//		"\nValor do INSS: R$ " , inss, 
//		"\n Valor do IR: R$ " , ir, 
//		"\nSal�rio Liquido: R$ ", liquido);
		
		JOptionPane.showMessageDialog(null, String.format(
				"C�lculo \n \nSal�rio por hora: R$ %,.2f" + 
				"\n N�mero de horas: %.0f" +
				"\n N�mero de dependentes: %.0f" +
				"\nSal�rio bruto: R$ %,.2f" +  
				"\nValor do INSS: R$ %,.2f" +  
				"\n Valor do IR: R$ %,.2f" +  
				"\nSal�rio Liquido: R$ %,.2f",
				salariohora, horas, dependentes, bruto, inss, ir, liquido)
			);
	}
}
