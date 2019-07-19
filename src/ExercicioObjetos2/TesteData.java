package ExercicioObjetos2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class TesteData {
	public static void main(String[] args) {
		String data = "28/02/2012";
		LocalDate validade = LocalDate.parse(data, 
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(validade);
	}
}
