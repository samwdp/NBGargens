package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import listener.ListMouseListener;
import model.order.CustomerOrder;
import view.OrderListView;
import database.ConnectionToDatabase;
/**
 * The view of all of the orders
 * @author Sam Precious
 *
 */
public class ViewController{

	private OrderListView olv;
	private ConnectionToDatabase ctd;

	public ViewController(ConnectionToDatabase ctd) throws ClassNotFoundException {
		olv = new OrderListView();
		this.ctd = ctd;

		String col[] = { "OrderID", "Worker", "Status" };

		olv.addCustomerOrderTableData(getCustomerOrderData());

		buttonListener();
		listListener();
	}

	/**
	 * Turns an arraylist of orders into an array of objects to be displayed in
	 * the GUI
	 * @throws ClassNotFoundException 
	 */
	private ArrayList<CustomerOrder> getCustomerOrderData() throws ClassNotFoundException {
		
		return ctd.getCustomerOrders();
		
	}
	
	
	
	/**
	 * adds a listener to the button on the order panel
	 */
	public void buttonListener(){
		olv.getRefreshButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					olv.addCustomerOrderTableData(getCustomerOrderData());
					//olv.addPurchaseOrderTableData(getPurchaseOrderData());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
	}
	
	/**
	 * adds a listener to the list in the order panel
	 */
	private void listListener(){
		olv.getCoList().addMouseListener(new ListMouseListener(ctd));
		//olv.getPoList().addMouseListener(new ListMouseListener(ctd));
	}
	
	public void addProducts(JPanel panel){
		olv.setProductList(panel);
	}
}
