package model.product;

import model.IPrice;

/**
 * Model of the standard product
 * 
 * @author Sam Precious
 *
 */
public class Standard extends Product implements IPrice {

	public Standard(){
		
	}
	public Standard(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;

	}

}
