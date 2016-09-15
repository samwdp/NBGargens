package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.order.CustomerOrder;
import model.order.Order;
import model.product.Porous;
import model.product.Standard;
import view.ProductView;
import database.ConnectionToDatabase;

/**
 * The controller for the product view, deals with all of the listeners
 * 
 * @author Sam Precious
 *
 */
public class ProductViewController {
	private DefaultTableModel porousProductModel;
	private DefaultTableModel normalProductModel;
	private ProductView pv;
	private Order order;
	private final static Logger LOGGER = Logger
			.getLogger(ProductViewController.class.getName());
	private ConnectionToDatabase ctd;

	public ProductViewController(Order order, ConnectionToDatabase ctd) {

		this.order = order;
		this.ctd = ctd;
		pv = new ProductView();
		String col[] = { "Name", "Type", "Amount" };

		porousProductModel = new DefaultTableModel(col, 0);
		normalProductModel = new DefaultTableModel(col, 0);

		getPorousProductData(order.getPorousProductArray());
		getStandardProductData(order.getStandardProductArray());

		pv.addPorousTableData(porousProductModel);
		pv.addStandardTableData(normalProductModel);

		statusComboBoxListener();
		workerAssign();

	}

	/**
	 * Turns an arraylist of products into an array of objects to be displayed
	 * in the GUI
	 */
	private void getPorousProductData(ArrayList<Porous> product) {

		for (int i = 0; i < product.size(); i++) {
			String name = product.get(i).getName();
			String type = product.get(i).getType();
			int amount = product.get(i).getAmount();

			Object[] obj = { name, type, amount };

			porousProductModel.addRow(obj);
		}
	}

	/**
	 * Turns an arraylist of products into an array of objects to be displayed
	 * in the GUI
	 */
	private void getStandardProductData(ArrayList<Standard> product) {

		for (int i = 0; i < product.size(); i++) {
			String name = product.get(i).getName();
			String type = product.get(i).getType();
			int amount = product.get(i).getAmount();

			Object[] obj = { name, type, amount };

			normalProductModel.addRow(obj);
		}
	}

	/**
	 * Sets the actionlistener to the status box and changes the order status
	 * depending on the selection
	 */
	private void statusComboBoxListener() {
		pv.getStatusChanger().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();

				order.setStatus(cb.getSelectedItem().toString());
				
				ctd.updateStatus(order.getStatus(), order.getOrderID());
				

				pv.setOutputTextAreaText("The status has been changed to: " + cb.getSelectedItem().toString());
			}
		});

	}

	/**
	 * Sets the worker that is associated to a customer order
	 */
	private void workerAssign() {
		pv.getSelectButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField t = pv.getNameInput();

				try {
					CustomerOrder o = (CustomerOrder) order;
					o.setWorker(t.getText());
					
					ctd.updateWorkerAssigned(o.getWorker(), o.getOrderID());
					pv.setOutputTextAreaText("The worker  " + t.getText() + " has been assigned to the order");
				} catch (ClassCastException cce) {
					LOGGER.log(Level.SEVERE, cce.getMessage());
					pv.showErrorMessage();
				}

			}
		});
	}
}
