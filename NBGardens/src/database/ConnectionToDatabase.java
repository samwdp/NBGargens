package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import model.order.CustomerOrder;
import model.order.PurchaseOrder;
import model.product.Porous;
import model.product.Product;
import model.product.Standard;

/**
 * Deals with all of the connections to the database
 * 
 * @author Sam Precious
 *
 */
public class ConnectionToDatabase {

	private static final Logger LOGGER = Logger
			.getLogger(ConnectionToDatabase.class.getName());
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/nb_gardens?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "Qazxsw12";
	private Connection conn = null;
	private Statement stmt = null;
	public int id;

	/**
	 * opens the connection to the database
	 */
	private void openConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * closes the connection to the database
	 */
	private void closeConnection() {
		System.out.println("closing database");
		try {
			if (stmt != null) {
				conn.close();
			}
		} catch (SQLException se) {
			// LOGGER.log(Level.SEVERE, se.getMessage(), thrown);
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException se) {

		}
	}

	/**
	 * Gets the customer orders that are pending
	 * 
	 * @return customerOrders list
	 */
	public ArrayList<CustomerOrder> getCustomerOrders() {
		ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();

		openConnection();
		try {

			stmt = conn.createStatement();

			String sql = "SELECT co.idcustomer_order, co.order_status, co.worker_assigned from customer_order co where order_status like \"pending\"";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("idcustomer_order");
				String status = rs.getString("order_status");
				String worker = rs.getString("worker_assigned");
				CustomerOrder co = new CustomerOrder(id, status);

				co.setPorousProductArray(getPorousArray(id, "customer_order"));
				co.setStandardProductArray(getStandardArray(id,
						"customer_order"));
				customerOrders.add(co);
			}
			rs.close();

		} catch (SQLException se) {
			se.getMessage();
		}

		closeConnection();

		return customerOrders;
	}

	/**
	 * gets the porous products associated with an order
	 * 
	 * @param id
	 *            of the order
	 * @param orderType
	 *            the type of order
	 * @return posousArray
	 */
	public ArrayList<Porous> getPorousArray(int id, String orderType) {
		ArrayList<Porous> porousArray = new ArrayList<Porous>();

		try {
			stmt = conn.createStatement();
			String sql = "Select p.idproducts, p.name, p.type, p.cost, oa.amount from products p join order_amount oa on oa.products_idproducts = p.idproducts join "
					+ orderType
					+ " co on oa."
					+ orderType
					+ "_id"
					+ orderType
					+ " = co.id"
					+ orderType
					+ " where (p.is_porous = true) and (co.id"
					+ orderType
					+ " =" + id + " )";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Porous p = new Porous();
				p.setId(rs.getInt("idproducts"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("cost"));
				p.setType(rs.getString("type"));
				p.setAmount(rs.getInt("amount"));

				porousArray.add(p);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return porousArray;
	}

	/**
	 * gets the porous products associated with an order
	 * 
	 * @param orderType
	 *            the type of order
	 * @return posousArray
	 */
	public ArrayList<Product> getProductArray() {
		ArrayList<Product> productArray = new ArrayList<Product>();

		openConnection();
		try {
			stmt = conn.createStatement();
			String sql = "Select p.idproducts, p.name, p.type, p.cost from products p";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Porous p = new Porous();

				p.setId(rs.getInt("idproducts"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("cost"));
				p.setType(rs.getString("type"));

				productArray.add(p);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return productArray;
	}

	/**
	 * gets an array of standard items
	 * 
	 * @param id
	 *            of the order
	 * @param orderType
	 *            the type of order
	 * @return standrardArray
	 */
	public ArrayList<Standard> getStandardArray(int id, String orderType) {
		ArrayList<Standard> standardArray = new ArrayList<Standard>();

		try {
			stmt = conn.createStatement();
			String sql = "Select p.idproducts, p.name, p.type, p.cost, oa.amount from products p join order_amount oa on oa.products_idproducts = p.idproducts join "
					+ orderType
					+ " co on oa."
					+ orderType
					+ "_id"
					+ orderType
					+ " = co.id"
					+ orderType
					+ " where (p.is_porous = false) and (co.id"
					+ orderType
					+ " =" + id + " )";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Standard p = new Standard();
				p.setId(rs.getInt("idproducts"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("cost"));
				p.setType(rs.getString("type"));
				p.setAmount(rs.getInt("amount"));

				standardArray.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return standardArray;
	}

	/**
	 * Gets the purchase orders that have been delivered
	 * 
	 * @return purchaseOrder
	 */
	public ArrayList<PurchaseOrder> getProductOrders() {
		ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();

		openConnection();
		try {

			stmt = conn.createStatement();

			String sql = "SELECT co.idstock_order, co.is_delivered from stock_order co where is_delivered = true;";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("idstock_order");
				String status = rs.getString("is_delivered");
				// double price = rs.getDouble("cost");
				PurchaseOrder co = new PurchaseOrder(id, status);

				co.setPorousProductArray(getPorousArray(id, "stock_order"));
				co.setStandardProductArray(getStandardArray(id, "stock_order"));
				purchaseOrders.add(co);
			}
			rs.close();

		} catch (SQLException se) {
			se.getMessage();
		}

		closeConnection();

		return purchaseOrders;
	}

	/**
	 * updates the customer order to say who is working on it
	 * 
	 * @param worker
	 *            that has been assigned
	 * @param id
	 *            of the order
	 */
	public void updateWorkerAssigned(String worker, int id) {

		openConnection();

		try {
			stmt = conn.createStatement();
			String sql = "UPDATE customer_order SET worker_assigned ='"
					+ worker + "' WHERE idcustomer_order= " + id;
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	/**
	 * updates the status of the order
	 * 
	 * @param status
	 *            that is being updated to
	 * @param id
	 *            of the order
	 */
	public void updateStatus(String status, int id) {
		openConnection();

		try {
			stmt = conn.createStatement();
			String sql = "UPDATE customer_order SET order_status ='" + status
					+ "' WHERE idcustomer_order= " + id;
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	public void createPurchaseOrder(PurchaseOrder po) {
		openConnection();

		try {
			stmt = conn.createStatement();
			String instertIntoStock = "INSERT INTO stock_order (order_date, delivery_date) VALUES ("
					+ po.getOrderDate() + "," + po.getDeliveryDate() + ")";
			stmt.executeUpdate(instertIntoStock);

			stmt = conn.createStatement();
			String getID = "SELECT idstock_order from stock_order where (delivery_date = "
					+ po.getDeliveryDate()
					+ ") and ( order_date = "
					+ po.getOrderDate() + ")";
			ResultSet rs = stmt.executeQuery(getID);
			while (rs.next()) {
				id = rs.getInt("idstock_order");
			}

			stmt = conn.createStatement();

			for (Product i : po.getStandardProductArray()) {
				String insertIntoOrder = "INSTER INTO order_amount (amount, products_idproducts, stock_order_idstock_order, cost) VALUES ( "
						+ i.getAmount()
						+ ","
						+ i.getId()
						+ ","
						+ i.getPrice()
						+ ")";
				stmt.executeUpdate(insertIntoOrder);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

}
