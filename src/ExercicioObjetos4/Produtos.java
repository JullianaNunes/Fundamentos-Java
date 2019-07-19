package ExercicioObjetos4;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Produtos {     
	public String desc;
	public Integer codprod;
	public Double valor;
	private List <String> produtos = new ArrayList<>();
	
	protected abstract String getTipo();

	@Override
	public String toString() {
		String texto = "Produtos: \n";
		
		for (String produto : produtos) {
			texto +=produto + "\n"; 
		}
		return super.toString() + texto;
	}
	
	}
	
	



