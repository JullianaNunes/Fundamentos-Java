package ExerciciosObjetos1;

public class Fornecedor {
	private String nome;
	private String endereco;
	
	 
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public String toString() {
		return "Nome do fornecedor:" + nome + "/nEnderešo do fornecedor: " + endereco;
	}


	
	}
	 
	

	

