package Exercicio3;
import static br.senai.sp.informatica.lib.SwUtil.*;

import javax.swing.JOptionPane;

public class Ex3f {

	  public static void main (String[] args) {
		  int idade = leInteiro("Digite sua idade");
		  
		  if (idade <= 10) {
			  JOptionPane.showMessageDialog(null, "Sua classificalção é: Infantil");
		  }
		  else if (idade >= 11 & idade <= 15) {
			  JOptionPane.showMessageDialog( null, "Sua classificalção é: Infanto");			  
		  }
		  else if (idade >= 16 & idade <= 18) {
			  JOptionPane.showMessageDialog( null, "Sua classificalção é: Juvenil");
		  }
		  else {
			  JOptionPane.showMessageDialog( null, "Sua classificalção é: Adulto");
		  }
	  }
}
