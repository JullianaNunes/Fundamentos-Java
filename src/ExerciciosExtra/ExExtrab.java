package ExerciciosExtra;

import static br.senai.sp.informatica.lib.SwUtil.*;
import javax.swing.JOptionPane;

public class ExExtrab {
	public static void main (String[] args) {
		int nota1 = leInteiro("Digite a primeira nota entre 0 a 100:");
		int nota2 = leInteiro("Digite a segunda nota entre 0 a 100:");
		int media;
		
		media = (nota1 + nota2) / 2;
		
		if (media <= 60) {
			   JOptionPane.showMessageDialog(null,"Seua m�dia � " + media + " � insuficiente!");
			   		}
		else if (media >= 61 && media <=80) {
			JOptionPane.showMessageDialog(null,"Sua m�dia � " + media + " � satisfat�ria!");
		}
		else if (media >= 81 && media <= 90) {
			JOptionPane.showMessageDialog(null,"Sua m�dia � " + media + " � boa!");
		}
		else {
			JOptionPane.showMessageDialog(null,"Sua m�dia � " + media + " � excelente!");
		}
	}

}
