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
		return "Eletodomésticos";
	}
	@Override
	public String toString() {
		return "Tipo: Eletrodomesticos \nCódigo do Produto: " + codprod + "\nDescrição do Produto: " + desc + "\nValor do produto: R$" 
	+ valor + "\nCódigo do Fornecedor: " + codForn + 
				"\nNome do Fornecedor: " + nomeForn + "\n";
	}
	 

}
