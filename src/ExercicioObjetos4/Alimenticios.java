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
		return "Tipo: Aliment�cios  \nC�digo do Produto: " + codprod + "\nDescri��o do Produto: " + desc
				+ "\nValor do produto: R$" + valor + "\nData de Validade: " + fmt.format(validade) + "\nData de Produ��o: "
				+ fmt.format(producao) + " \n";
	}

	@Override
	public String getTipo() {
		return "Aliment�cios";
	}

}
