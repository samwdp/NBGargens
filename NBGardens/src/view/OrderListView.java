package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import listener.ListMouseListener;
import model.order.CustomerOrder;
import model.order.PurchaseOrder;

/**
 * View of all of the orders
 * 
 * @author Sam Precious
 *
 */
public class OrderListView extends JFrame {

	private JPanel listPanel;
	private JScrollPane coScroller;
	private JScrollPane poScroller;
	private JList<CustomerOrder> coList;
	private JTabbedPane tab;
	private JPanel customerOrderPanel;
	private JButton refreshButton;
	private JPanel refreshPanel;

	public OrderListView() {
		listPanel = new JPanel();
		coScroller = new JScrollPane();
		poScroller = new JScrollPane();
		customerOrderPanel = new JPanel();
		tab = new JTabbedPane();
		refreshButton = new JButton("Refresh");
		refreshPanel = new JPanel();
		initiliseView();
	}

	/**
	 * initialise the view
	 */
	private void initiliseView() {
		// set the frame
		setTitle("Orders");
		setSize(400, 400);

		// set the tab view
		tab.addTab("Customer Order", customerOrderPanel);
		

		customerOrderPanel.add(coScroller);

		refreshPanel.add(refreshButton);

		add(refreshPanel, BorderLayout.NORTH);
		add(tab, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * adds the customer orders to the table and repaints the frame
	 * 
	 * @param list
	 *            of the customer order
	 */
	public void addCustomerOrderTableData(ArrayList<CustomerOrder> list) {
		coList = new JList(list.toArray());
		coList.setSize(MAXIMIZED_HORIZ, MAXIMIZED_VERT);

		coScroller.setViewportView(coList);
		revalidate();
		repaint();

	}

	

	/**
	 * gets the button to refresh the orders
	 * 
	 * @return refreshButton to be pressed
	 */
	public JButton getRefreshButton() {
		return refreshButton;
	}

	/**
	 * Gets the list of the customer orders
	 * 
	 * @return coList view of the orders
	 */
	public JList<CustomerOrder> getCoList() {
		return coList;
	}
	
	public void setProductList(JPanel orderPanel){
		tab.addTab("Purchase Order", orderPanel);
		revalidate();
		repaint();
	}

}
