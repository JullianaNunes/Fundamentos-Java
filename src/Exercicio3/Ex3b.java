package Exercicio3;

import static br.senai.sp.informatica.lib.SwUtil.*;
import javax.swing.JOptionPane;

public class Ex3b {
    public static void main (String[] args ) {
    	
    	int n1 = leInteiro("Digite o primeiro n�mero:");
       	int par = n1%2;
       	
       	if (par == 0) {
       		JOptionPane.showMessageDialog(null, "O n�mero " + n1 + " � par!");
       	}
       	else {
       		JOptionPane.showMessageDialog(null, " O n�mero " + n1 + " � impar!");
       	}
    }
}
