package Exercicio3;

import static br.senai.sp.informatica.lib.SwUtil.*;
import javax.swing.JOptionPane;

public class Ex3c {
    public static void main (String[] args) {
      
    int num1 = leInteiro("Digite o primeiro n�mero:");
    int num2 = leInteiro("Digite o segundo n�mero:");
    
    double div = num1 % num2;
    
    if ( div == 0) {
    	JOptionPane.showMessageDialog(null, "Os n�meros " + num1 + " e " + num2 + " s�o divisiveis!");
    }
    else {
    	JOptionPane.showMessageDialog(null, "Os n�meros " + num1 + " e " + num2 + " n�o s�o divisiveis!");
    }
    
      
    }
}
 