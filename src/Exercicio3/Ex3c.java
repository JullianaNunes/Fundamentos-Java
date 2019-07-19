package Exercicio3;

import static br.senai.sp.informatica.lib.SwUtil.*;
import javax.swing.JOptionPane;

public class Ex3c {
    public static void main (String[] args) {
      
    int num1 = leInteiro("Digite o primeiro número:");
    int num2 = leInteiro("Digite o segundo número:");
    
    double div = num1 % num2;
    
    if ( div == 0) {
    	JOptionPane.showMessageDialog(null, "Os números " + num1 + " e " + num2 + " são divisiveis!");
    }
    else {
    	JOptionPane.showMessageDialog(null, "Os números " + num1 + " e " + num2 + " não são divisiveis!");
    }
    
      
    }
}
 