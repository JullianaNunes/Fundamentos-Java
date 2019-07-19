package ExerciciosObjeto4;

import java.io.Serializable;
import lombok.Data;

@Data
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idproduto; 
	private int codigo;
	private String nome;
	private String descricao;
	private double valor;
	private int quantidade;
	}
