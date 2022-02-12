package exceptions;

public class InvalidRemovingException extends Exception{

	public InvalidRemovingException(String name, double newWeight, double actualWeight) {
		super("El peso que está intentando remover ("+ newWeight +") para el ingrediente ("+name+"), es mayor a la cantidad actual ("+actualWeight+")");
	}
	
}