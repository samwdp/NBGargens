package model.product;

import java.util.ArrayList;

/**
 * Abstract implementation of the products
 * 
 * @author Sam Precious
 *
 */

public abstract class Product {
	protected String name = "";
	protected String type = "";
	protected double price = 0;
	protected String[][] location = new String[12][12];
	protected int amount;
	protected int id;
	
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * gets the amount that a product has in the order
	 * 
	 * @return amount of the product
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * sets the amount that the product has
	 * 
	 * @param amount
	 *            of the product
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * gets the location the product is in the warehouse
	 * 
	 * @return location of the product
	 */
	public String[][] getLocation() {
		return location;
	}

	/**
	 * sets the location of the product in the warehouse
	 * 
	 * @param location
	 *            of the product
	 */
	public void setLocation(String[][] location) {
		this.location = location;
	}

	/**
	 * Sets the name of the product
	 * 
	 * @param name
	 *            is the name of the product
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the product
	 * 
	 * @return name of the product
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the type of the product
	 * 
	 * @return type of the product
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the product
	 * 
	 * @param type
	 *            that the product is
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString(){
		String s = "Name : " + name + " Type : " + type;
		return s;
	}
}
