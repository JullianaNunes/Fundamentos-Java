package Exercicio3;

import static br.senai.sp.informatica.lib.SwUtil.*;
import javax.swing.JOptionPane;

public class Ex3d {
	public static void main (String[] args) {
		double desconto, salariolq;
		double salariob = leReal("Digite o valor do seu salário:");
		 
	    if (salariob <= 300) {
	    	 desconto = salariob * 0.5;
	    	 salariolq = salariob - desconto;
	    	 JOptionPane.showMessageDialog(null, "O seu salário liquido é de R$" + salariolq + ",00");
	    }
	    else if (salariob >= 301 || salariob <= 1200) {
	    	 desconto = salariob * 0.10;
	    	 salariolq = salariob - desconto;
	    	 JOptionPane.showMessageDialog(null, "O seu salário liquido é de R$" + salariolq + ",00");
	}
	    else if (salariob >= 1200) {
	    	 desconto = salariob * 0.15;
	    	 salariolq = salariob - desconto;
	    	 JOptionPane.showMessageDialog(null, "O seu salário liquido é de R$" + salariolq + ",00");

	    }
	    else {
	    	 JOptionPane.showMessageDialog(null, "Valor invalido!");
	    }
} 
}
