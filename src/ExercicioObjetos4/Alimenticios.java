package ExercicioObjetos4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Alimenticios extends Produtos {
	private LocalDate validade;
	private LocalDate producao;
	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public String toString() {
		return "Tipo: Alimentícios  \nCódigo do Produto: " + codprod + "\nDescrição do Produto: " + desc
				+ "\nValor do produto: R$" + valor + "\nData de Validade: " + fmt.format(validade) + "\nData de Produção: "
				+ fmt.format(producao) + " \n";
	}

	@Override
	public String getTipo() {
		return "Alimentícios";
	}

}
