package ExercicioObjetos4;


import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class Eletrodomesticos extends Produtos{
	private Integer codForn;
	private String nomeForn; 
	
	@Override
	public String getTipo() {
		return "Eletodom�sticos";
	}
	@Override
	public String toString() {
		return "Tipo: Eletrodomesticos \nC�digo do Produto: " + codprod + "\nDescri��o do Produto: " + desc + "\nValor do produto: R$" 
	+ valor + "\nC�digo do Fornecedor: " + codForn + 
				"\nNome do Fornecedor: " + nomeForn + "\n";
	}
	 

}
