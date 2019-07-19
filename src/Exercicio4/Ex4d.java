package Exercicio4;

import static br.senai.sp.informatica.lib.SwUtil.*;


public class Ex4d {
 public static void main (String[] args) {
	  int contador = leInteiro("Quantas vezes?");
	  int menor = Integer.MAX_VALUE;
	  
	  String msg = "";
	  
	  for ( int i = 0; i < contador; i++ ) {
		  int num = leInteiro("Escreva um número:");
		  	  
		  if (num < menor) {
			  menor = num;
			  contador =1;
		  } else if (num == menor) {
			  contador++;
		  }
		  msg += num + " ";
	  }
	  escreva("O menor número é " + menor +" e foi informado " + contador +  " vezes dentre estes números citados:" + msg);
 }
}
