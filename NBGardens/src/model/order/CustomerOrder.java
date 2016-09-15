package model.order;

import java.util.ArrayList;

import model.IPrice;
import model.IUpdateAccounts;
import model.product.Porous;
import model.product.Standard;

/**
 * Model of the customer order
 * 
 * @author Sam Precious
 *
 */
public class CustomerOrder extends Order implements IPrice, IUpdateAccounts {

	private String worker;

	public CustomerOrder(int orderID, String status) {
		this.orderID = orderID;
		this.status = status;

	}

	/**
	 * gets the worker that is associated with the order
	 * 
	 * @return worker on the order
	 */
	public String getWorker() {
		return worker;
	}

	/**
	 * sets the worker that is being assigned to the order
	 * 
	 * @param worker
	 *            that is bein assigned
	 */
	public void setWorker(String worker) {
		this.worker = worker;
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAccounts() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		String s = "OrderID : " + orderID + " OrderStatus : " + status
				+ " Worker : " + worker;
		return s;
	}
}
