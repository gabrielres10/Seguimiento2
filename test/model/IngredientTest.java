package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exceptions.InvalidRemovingException;
import exceptions.NegativeValueException;

class IngredientTest {
	
	private Ingredient tomato;

	//Escenario 1
	void setUpStage1() {
		tomato = new Ingredient("Tomate",245);
	}
	
	//Escenario 2
	void setUpStage2() {
		try {
			tomato.addWeight(54);
		} catch (NegativeValueException e) {
			e.printStackTrace();
		}
	}
	
	//Escenario 3
	void setUpStage3() {
		try {
			tomato.removeWeight(45);
		} catch (NegativeValueException | InvalidRemovingException e) {
			e.printStackTrace();
		}
	}
	
	//Escenario 4
	void setUpStage4() {
		try {
			tomato.removeWeight(-100);
		} catch (NegativeValueException | InvalidRemovingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void addIngredientTest() {
		//
		setUpStage1();
		 //
		assertEquals(tomato.getName(), "Tomate");
		assertTrue(tomato.getWeight()== 245.0);
	}
	
	@Test
	void addWeightTest() {
		setUpStage1();
		setUpStage2();
		
		assertTrue(tomato.getWeight()== 299.0);
	}
	
	
	@Test
	void removeWeightTest() {
		setUpStage1();
		setUpStage3();
		
		
		assertTrue(tomato.getWeight()== 200); 
	}
	
	@Test
	void negativeWeightTest() {
		setUpStage1();
		setUpStage4();
		
		assertTrue(tomato.getWeight()== 245); 
	}

}
