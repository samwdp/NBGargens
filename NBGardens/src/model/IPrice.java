package model;

/**
 * Interface for price
 * 
 * @author Sam Precious
 *
 */
public interface IPrice {

	/**
	 * sets the price of the order
	 * 
	 * @param price
	 *            of the order
	 */
	public void setPrice(double price);

	/**
	 * gets the price of the order
	 * 
	 * @return price of the order
	 */
	public double getPrice();

}
