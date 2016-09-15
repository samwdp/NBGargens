package model.product;

import model.IPrice;

/**
 * Model of the porous product
 * 
 * @author Sam Precious
 *
 */
public class Porous extends Product implements IPrice {

	public Porous() {

	}

	public Porous(String name, String type) {
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
