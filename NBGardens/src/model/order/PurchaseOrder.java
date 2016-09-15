package model.order;

import java.util.ArrayList;

import model.IPrice;
import model.IUpdateAccounts;
import model.product.Porous;
import model.product.Standard;

/**
 * Model of the purchase order
 * 
 * @author Sam Precious
 *
 */
public class PurchaseOrder extends Order implements IPrice, IUpdateAccounts {

	public PurchaseOrder(int orderID, String status) {
		super();
		this.orderID = orderID;
		this.status = status;

	}
	public PurchaseOrder(String status) {
		super();
		this.status = status;

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
		String s = "OrderID: " + orderID + " OrderStatus: " + status;
		return s;
	}

}
