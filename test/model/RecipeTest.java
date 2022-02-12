package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecipeTest {

	private Recipe recipe;
	
	void setUpStage1() {
		recipe = new Recipe();
	}
	
	void setUpStage2() {
		recipe.addIngredient("Cebolla", 315);
		recipe.addIngredient("Ajo", 58);
		recipe.addIngredient("Arroz", 520);
	}
	
	void setUpStage3() {
		recipe.addIngredient("Sal", 12);
	}
	
	void setUpStage4() {
		for (int i = 0; i < 3; i++) {
			recipe.addIngredient(""+i, i);
		}
		recipe.addIngredient("Pimienta", 6);
	}
	
	void setUpStage5() {
		recipe.addIngredient("Ajo", 21);
	}
	
	void setUpStage6() {
		recipe.removeIngredient("Ajo");
	}
	
	@Test
	void AddZeroIngredientstest() {
		setUpStage1();
		
		assertTrue(recipe.getIngredients().size() == 0);
	}
	
	@Test
	void addThreeIngredientTest() {
		setUpStage1();
		setUpStage2();
		
		assertTrue(recipe.getIngredients().get(0).getName().equals("Cebolla") ); 
		assertTrue(recipe.getIngredients().get(1).getName().equals("Ajo") ); 
		assertTrue(recipe.getIngredients().get(2).getName().equals("Arroz") ); 
		assertTrue(recipe.getIngredients().get(0).getWeight() == 315 ); 
		assertTrue(recipe.getIngredients().get(1).getWeight() == 58 ); 
		assertTrue(recipe.getIngredients().get(2).getWeight() == 520 ); 
		
	}
	
	@Test
	void addSaltTest() {
		setUpStage1();
		setUpStage3();
		
		assertTrue(recipe.getIngredients().get(0).getName().equals("Sal") ); 
		assertTrue(recipe.getIngredients().get(0).getWeight() == 12 );
		
	}
	
	@Test
	void addPiperTest() {
		setUpStage1();
		setUpStage4();
		
		assertTrue(recipe.getIngredients().get(3).getName().equals("Pimienta") );
		assertTrue(recipe.getIngredients().get(3).getWeight() == 6 );
		
	}
	
	@Test
	void addGarlicTest() {
		setUpStage1();
		setUpStage2();
		setUpStage5();
		
		assertTrue(recipe.getIngredients().get(1).getName().equals("Ajo") );
		
		assertTrue(recipe.getIngredients().get(1).getWeight() == 79 ); 
	}
	
	@Test
	void removeGarlicTest() {
		setUpStage1();
		setUpStage2();
		setUpStage6();
		
		assertTrue(recipe.getIngredients().size() == 2); 
	}
}
