package Exercicio4;

import static br.senai.sp.informatica.lib.SwUtil.*;

public class Ex4a {
	public static void main(String[] args) {
		int num1 = leInteiro("Informe o primeiro n�mero:");
		int num2 = leInteiro("Informe o segundo n�mero:");

		String msg = "";

		for (int cnt = num1; cnt <= num2; cnt++) {
			 
			
			
			if (cnt == 0) {
				msg += cnt + "\n";
			}
			
		}
		escreva("N�meros �mpares entre " + num1 + " e " + num2 + " s�o\n\n" + msg);
	}

}
