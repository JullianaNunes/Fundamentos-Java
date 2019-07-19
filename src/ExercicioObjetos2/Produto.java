package ExercicioObjetos2;

public enum Produto {
     CONSTRUCAO {
    	 @Override
    	public String toString() {
    	return "de Construção";
    	}
     },
     FACAVOCEMESMO{
    	 @Override
    	public String toString() {
    	return "Faça você mesmo";
    	}
     },
     PINTURA {
    	 @Override
    	public String toString() {
    	return "De pintura";
    	}
     },
     CARROS{
    	 @Override
    	public String toString() {
    	return "Para carros";
    	}
     };
}
