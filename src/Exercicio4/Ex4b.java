package Exercicio4;

import static br.senai.sp.informatica.lib.SwUtil.*;

public class Ex4b {
 public static void main (String[] args) {
	 int contador = leInteiro("Quantas vezes?");
	  int maior = Integer.MIN_VALUE;
	  
	  String msg = "";
	  
	  for ( int i = 0; i < contador; i++ ) {
		  int num = leInteiro("Escreva um n�mero:");
		  
		  if (num > maior) {
			  maior = num;
		  }
		  msg += num + " ";
	  }
	  escreva("O maior n�mero � " + maior + "\ndentre estes n�meros citados: " + msg);
		}
 }

