package ExercicioObjetos2;

public enum Produto {
     CONSTRUCAO {
    	 @Override
    	public String toString() {
    	return "de Constru��o";
    	}
     },
     FACAVOCEMESMO{
    	 @Override
    	public String toString() {
    	return "Fa�a voc� mesmo";
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
