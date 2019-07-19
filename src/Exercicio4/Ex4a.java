package Exercicio4;

import static br.senai.sp.informatica.lib.SwUtil.*;

public class Ex4a {
	public static void main(String[] args) {
		int num1 = leInteiro("Informe o primeiro número:");
		int num2 = leInteiro("Informe o segundo número:");

		String msg = "";

		for (int cnt = num1; cnt <= num2; cnt++) {
			 
			
			
			if (cnt == 0) {
				msg += cnt + "\n";
			}
			
		}
		escreva("Números ímpares entre " + num1 + " e " + num2 + " são\n\n" + msg);
	}

}
