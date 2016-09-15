package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * The view of all the products
 * @author Sam Precious
 *
 */
public class ProductView extends JFrame {

	private JPanel dropdownPanel;
	private JPanel workerPanel;
	private JPanel outputPanel;
	private JButton selectButton;
	private JScrollPane porousScroller;
	private JScrollPane normalScroller;
	private JTable porousTable;
	private JTable normalTable;
	private JTextField nameInput;
	private JComboBox statusChanger;
	private JLabel workerLabel;
	private JTabbedPane tabs;
	private JPanel porousPanel;
	private JPanel normalPanel;
	private JTextArea outputText;

	public ProductView() {
		String[] status = { "Pending", "Picking", "Dispatched", "Delivered" };
		workerPanel = new JPanel();
		dropdownPanel = new JPanel();
		outputPanel = new JPanel();
		tabs = new JTabbedPane();
		porousPanel = new JPanel();
		normalPanel = new JPanel();
		porousScroller = new JScrollPane(porousTable);
		normalScroller = new JScrollPane(normalTable);
		nameInput = new JTextField(20);
		workerLabel = new JLabel("Input worker name");
		statusChanger = new JComboBox(status);
		selectButton = new JButton("Select");
		outputText = new JTextArea();

		inititaliseView();
	}

	/**
	 * Initialise the view for the products
	 */
	private void inititaliseView() {

		setTitle("Product View");
		setSize(800, 800);

		// add the tabbed view
		tabs.addTab("Porous Product", porousPanel);
		tabs.addTab("Normal Product", normalPanel);

		normalPanel.add(normalScroller);
		porousPanel.add(porousScroller);

		// button panel
		dropdownPanel.add(statusChanger);
		workerPanel.add(workerLabel);
		workerPanel.add(nameInput);
		workerPanel.add(selectButton);
		workerPanel.add(dropdownPanel, BorderLayout.SOUTH);
		
		//add the output text area
		outputPanel.add(outputText);

		// frame
		add(workerPanel, BorderLayout.NORTH);
		add(tabs, BorderLayout.CENTER);
		add(outputPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	/**
	 * Adds the porous items to the table and repaints the frame
	 * 
	 * @param tableModel
	 *            of the porous items
	 */
	public void addPorousTableData(DefaultTableModel tableModel) {
		porousTable = new JTable(tableModel);

		porousScroller.setViewportView(porousTable);
		revalidate();
		repaint();

	}

	/**
	 * Adds the standard items to the table and repaints the frame
	 * 
	 * @param tableModel
	 *            of the standard items
	 */
	public void addStandardTableData(DefaultTableModel tableModel) {
		normalTable = new JTable(tableModel);

		normalScroller.setViewportView(normalTable);
		revalidate();
		repaint();

	}

	/**
	 * gets the select button
	 * 
	 * @return selectButton the button
	 */
	public JButton getSelectButton() {
		return selectButton;
	}

	/**
	 * gets the combobox that contains the status of the order
	 * 
	 * @return statusChanger the combobox
	 */
	public JComboBox getStatusChanger() {
		return statusChanger;
	}

	/**
	 * Gets the textfield
	 * 
	 * @return nameInput the text field
	 */
	public JTextField getNameInput() {
		return nameInput;
	}

	/**
	 * Opens a dialog box when an error is throws
	 */
	public void showErrorMessage() {
		JOptionPane.showMessageDialog(null,
				"This is not a valid order to assign workers on",
				"InfoBox: Error", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Shows the output text
	 * @param output that is shown
	 */
	public void setOutputTextAreaText(String output){
		outputText.setText(output);
	}

}
