package controller;

import java.util.ArrayList;

import model.order.PurchaseOrder;
import model.product.Product;
import view.OrderForm;
import database.ConnectionToDatabase;

public class OrderFormController {
	private ConnectionToDatabase ctd;
	
	public OrderFormController(ConnectionToDatabase ctd){
		this.ctd = ctd;
		
	}
	
	/**
	 * Turns an arraylist of orders into an array of objects to be displayed in
	 * the GUI
	 */
	public ArrayList<Product> getProducts() {

		
		return ctd.getProductArray();
	}

}
