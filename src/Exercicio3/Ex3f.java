package Exercicio3;
import static br.senai.sp.informatica.lib.SwUtil.*;

import javax.swing.JOptionPane;

public class Ex3f {

	  public static void main (String[] args) {
		  int idade = leInteiro("Digite sua idade");
		  
		  if (idade <= 10) {
			  JOptionPane.showMessageDialog(null, "Sua classifical��o �: Infantil");
		  }
		  else if (idade >= 11 & idade <= 15) {
			  JOptionPane.showMessageDialog( null, "Sua classifical��o �: Infanto");			  
		  }
		  else if (idade >= 16 & idade <= 18) {
			  JOptionPane.showMessageDialog( null, "Sua classifical��o �: Juvenil");
		  }
		  else {
			  JOptionPane.showMessageDialog( null, "Sua classifical��o �: Adulto");
		  }
	  }
}
