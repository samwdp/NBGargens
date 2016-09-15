package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.order.PurchaseOrder;
import model.product.Product;
import database.ConnectionToDatabase;

public class OrderForm extends JPanel{
	
	private JScrollPane scroller;
	private JList<Product> products;
	private JPanel productPanel;
	private JPanel createPanel;
	private JButton createOrder;
	
	public OrderForm(){
		scroller = new JScrollPane();
		productPanel = new JPanel();
		createPanel = new JPanel();
		createOrder = new JButton("CreateOrder");

		inititlaiseForm();
	}
	
	private void inititlaiseForm(){
		
		productPanel.add(scroller);
		createPanel.add(createOrder);
		add(productPanel, BorderLayout.CENTER);
		add(createPanel, BorderLayout.SOUTH);
	}

	/**
	 * adds the p orders to the table and repaints the frame
	 * 
	 * @param list
	 *            of the purchase order
	 */
	public void addProducts(ArrayList<Product> list) {
		products = new JList(list.toArray());

		scroller.add(products);
		scroller.setViewportView(products);
			
		revalidate();
		repaint();

	}
	
	public void buttonListener(ConnectionToDatabase ctd, PurchaseOrder po){
		createOrder.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ctd.createPurchaseOrder(po);
			}
			
		});
	}
	 
}
