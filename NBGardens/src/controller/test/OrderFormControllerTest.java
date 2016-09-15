package controller.test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.OrderFormController;
import view.OrderForm;
import database.ConnectionToDatabase;

public class OrderFormControllerTest {

	@Test
	public void testGetProducts() {
		ConnectionToDatabase ctd = new ConnectionToDatabase();
		OrderFormController of = new OrderFormController(ctd);
		
		int expected = 8;
		
		int actual = of.getProducts().size();
		
		assertEquals(expected, actual);
	}

}
