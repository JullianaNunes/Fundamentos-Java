package ExerciciosObjetos1;

import lombok.Data;
import static br.senai.sp.informatica.lib.SwUtil.*;

import java.util.*;


@Data
public class CadastroFornecedores {
public static void main (String[] agrs) {
	List<Fornecedor> lista = new ArrayList<>();
	
	 String nome = leTexto("Informe o nome");
	   	

		while(!nome.equalsIgnoreCase("fim")) {
			Fornecedor oForn = new Fornecedor();  
			oForn.setNome(nome);
			oForn.setEndereco(leTexto("Informe o endereço:"));
			
			
			
            lista.add(oForn);
            nome = leTexto("Informe o nome");
		}
		String msg = "Cadastro\n\n";
		for (Fornecedor fornecedor : lista) {
			msg += fornecedor + "\n";
			
		}
		escreva(msg);
}	
}
