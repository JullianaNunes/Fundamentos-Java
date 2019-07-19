package ExercicioObjetos2;

import java.time.LocalDate;
import lombok.*;

@Data
@Builder

public class MaterialConstrucao {
	private String nome;
	private String descricao;
	private LocalDate validade;
	private Produto produtos;
	
	@Override
	public String toString() {
		return "Nome: " + nome + " Validade: " + validade + " Tipo de produto: " + produtos;
	}
}
