package database.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import model.order.CustomerOrder;
import model.order.PurchaseOrder;
import model.product.Porous;
import model.product.Product;
import model.product.Standard;

import org.junit.Test;

import database.ConnectionToDatabase;

public class ConnectionToDatabaseTest {

	@Test
	public void testGetCustomerOrders() {
		ConnectionToDatabase ctb = new ConnectionToDatabase();
		
		int expected = 2;
		
		ArrayList<CustomerOrder> co = ctb.getCustomerOrders();
		
		
		int actual = co.size();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testgetProducts() {
		ConnectionToDatabase ctb = new ConnectionToDatabase();
		
		int expected = 8;
		
		ArrayList<Product> co = ctb.getProductArray();
		
		
		int actual = co.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUpdate() {
		ConnectionToDatabase ctb = new ConnectionToDatabase();
		
		int expected = 7;
		
		ArrayList<Product> prod = new ArrayList();
		prod.add(new Porous("Dave", "Gnome"));
		prod.add(new Standard("Dave", "Gnome"));
		prod.add(new Porous("Jim", "Gnome"));
		prod.add(new Standard("Jim", "Gnome"));
		
		PurchaseOrder po = new PurchaseOrder("Not delivered");
		po.setOrderDate("2016-10-12");
		po.setDeliveryDate("2016-10-18");
		po.setpArray(prod);
		
		ctb.createPurchaseOrder(po);
		
		
		int actual = ctb.id;
		
		assertEquals(expected, actual);
	}
	
	
}
