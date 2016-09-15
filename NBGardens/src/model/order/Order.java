package model.order;

import java.sql.Date;
import java.util.ArrayList;

import model.IPrice;
import model.IUpdateAccounts;
import model.product.Porous;
import model.product.Product;
import model.product.Standard;

/**
 * Abstract model of the order
 * 
 * @author Administrator
 *
 */
public abstract class Order {

	protected ArrayList<Porous> porousProductArray;
	protected ArrayList<Standard> standardProductArray;
	protected String status;
	protected double price;
	protected int orderID;
	protected String orderDate;
	protected String deliveryDate;
	protected ArrayList<Product> pArray;

	public ArrayList<Product> getpArray() {
		return pArray;
	}

	public void setpArray(ArrayList<Product> pArray) {
		this.pArray = pArray;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * gets the order id
	 * 
	 * @return orderID of the order
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * sets the order id of the order
	 * 
	 * @param orderID
	 *            of the order
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * gets an arraylist of porous products associated with the order
	 * 
	 * @return porousProductArray list of porous products
	 */
	public ArrayList<Porous> getPorousProductArray() {
		return porousProductArray;
	}

	/**
	 * sets the porous product array
	 * 
	 * @param porousProductArray
	 *            that the array is being set to
	 */
	public void setPorousProductArray(ArrayList<Porous> porousProductArray) {
		this.porousProductArray = porousProductArray;
	}

	/**
	 * gets an arraylist of standard products associated with the order
	 * 
	 * @return standardProductArray list of porous products
	 */
	public ArrayList<Standard> getStandardProductArray() {
		return standardProductArray;
	}

	/**
	 * sets the standard product array
	 * 
	 * @param standardProductArray
	 *            that the array is being set to
	 */
	public void setStandardProductArray(ArrayList<Standard> standardProductArray) {
		this.standardProductArray = standardProductArray;
	}

	/**
	 * gets the status of the order
	 * 
	 * @return status of the order
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * sets the status of the order
	 * 
	 * @param status
	 *            of the order
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
