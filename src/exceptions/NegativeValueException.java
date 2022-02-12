package exceptions;

public class NegativeValueException extends Exception{

	public NegativeValueException(String name, double weight) {
		super("Est� intentando agregar un peso negativo -"+ weight +"- para el ingrediente: " + name);
	}
	
}
