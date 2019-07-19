package Exercicio4;

import static br.senai.sp.informatica.lib.SwUtil.*;

public class Ex4b {
 public static void main (String[] args) {
	 int contador = leInteiro("Quantas vezes?");
	  int maior = Integer.MIN_VALUE;
	  
	  String msg = "";
	  
	  for ( int i = 0; i < contador; i++ ) {
		  int num = leInteiro("Escreva um número:");
		  
		  if (num > maior) {
			  maior = num;
		  }
		  msg += num + " ";
	  }
	  escreva("O maior número é " + maior + "\ndentre estes números citados: " + msg);
		}
 }

