package model.test;

import static org.junit.Assert.*;
import model.product.Porous;
import model.product.Product;
import model.product.Standard;

import org.junit.Test;

public class ProductTest {

	@Test
	public void testSetNameOnPorous() {
		Porous p = new Porous();
		
		String expected = "Jim";
		
		p.setName(expected);
		
		String actual = p.getName();
		
		assertEquals("The result was", expected, actual);
		
	}
	
	@Test
	public void testSetNameOnStandard() {
		Standard p = new Standard();
		
		String expected = "Jim";
		
		p.setName(expected);
		
		String actual = p.getName();
		
		assertEquals("The result was", expected, actual);
		
	}
	
	@Test
	public void testSetTypeOnPorous() {
		Porous p = new Porous();
		
		String expected = "Gnome";
		
		p.setType(expected);
		
		String actual = p.getType();
		
		assertEquals("The result was", expected, actual);
		
	}
	
	@Test
	public void testSetTypeOnStandard() {
		Standard p = new Standard();
		
		String expected = "Gnome";
		
		p.setType(expected);
		
		String actual = p.getType();
		
		assertEquals("The result was", expected, actual);
		
	}
	

	@Test
	public void testPriceOnPorous() {
		Porous p = new Porous();
		
		double expected = 23.99;
		
		p.setPrice(expected);
		
		double actual = p.getPrice();
		
		assertEquals(Double.doubleToLongBits(expected), Double.doubleToLongBits(actual));		
	}
	
	@Test
	public void testPriceOnStandard() {
		Standard p = new Standard();
		
		double expected = 23.99;
		
		p.setPrice(expected);
		
		double actual = p.getPrice();
		
		assertEquals(Double.doubleToLongBits(expected), Double.doubleToLongBits(actual));		
	}

}
