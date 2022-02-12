package model;

import exceptions.InvalidRemovingException;
import exceptions.NegativeValueException;

public class Ingredient {
	private String name;
	private double weight;
	
	public Ingredient(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeValueException {
		
		if(additionalW < 0) {
			throw new NegativeValueException(this.name,additionalW);
		}else {
			this.weight += additionalW;
		}
		
	}
	
	public void removeWeight(double decreasingW) throws NegativeValueException, InvalidRemovingException{
		
		if(decreasingW < 0) {
			throw new NegativeValueException(this.name,decreasingW);
		}else if(this.weight < decreasingW){
			throw new InvalidRemovingException(this.name,decreasingW, this.weight);
		}else {
			weight -= decreasingW;
		}
		
	}
	
}