package ExerciciosExtra;

import static br.senai.sp.informatica.lib.SwUtil.*;

import javax.swing.JOptionPane;

public class ExExtraa {
	public static void main (String[] args) {
		double salariohora = leReal("Digite o salario por hora:");
		double horas = leReal("Digite as horas trabalhadas:");
		double dependentes = leReal("Digite o número de dependentes:");
		double inss, ir;
		
		// Salário Bruto//
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
		
		
		// Salário líquido
		double liquido = bruto - inss - ir;
		
//		escreva("Cálculo \n \nSalário por hora: " , salariohora , 
//		"\n Número de horas: " , horas, 
//		"\n Número de dependentes: " , dependentes, 
//		"\nSalário bruto: R$ " , bruto , 
//		"\nValor do INSS: R$ " , inss, 
//		"\n Valor do IR: R$ " , ir, 
//		"\nSalário Liquido: R$ ", liquido);
		
		JOptionPane.showMessageDialog(null, String.format(
				"Cálculo \n \nSalário por hora: R$ %,.2f" + 
				"\n Número de horas: %.0f" +
				"\n Número de dependentes: %.0f" +
				"\nSalário bruto: R$ %,.2f" +  
				"\nValor do INSS: R$ %,.2f" +  
				"\n Valor do IR: R$ %,.2f" +  
				"\nSalário Liquido: R$ %,.2f",
				salariohora, horas, dependentes, bruto, inss, ir, liquido)
			);
	}
}
