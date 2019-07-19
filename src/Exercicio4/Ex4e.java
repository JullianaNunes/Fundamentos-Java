package Exercicio4;

import static br.senai.sp.informatica.lib.SwUtil.*;

public class Ex4e {
 public static void main (String[] args) {
	 double contador = leReal("Digite quantas vezes quer inserir:");
	 double maior = Double.MIN_VALUE;
	 
	 String msg = "";
	 
	 for ( int i = 0; i < contador; i++ ) {
		  double sal = leReal("Escreva um salário:");
		  
		  if (sal < maior) {
			  maior = sal;
		  } 
		  msg += sal + " ";
		  escreva("O menor número é " + sal + "\ndentre estes números citados:" + msg);
	  }
	    
		} 
	 
 }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        