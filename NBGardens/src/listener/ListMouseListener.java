package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import model.order.Order;
import controller.ProductViewController;
import database.ConnectionToDatabase;

/**
 * Creates the product view based on which order has been clicked
 * @author Sam Precious
 *
 */
public class ListMouseListener implements MouseListener {
	public ConnectionToDatabase ctd;
	
	public ListMouseListener(ConnectionToDatabase ctd){
		this.ctd = ctd;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JList l = (JList) arg0.getSource();

		Order o = (Order) l.getSelectedValue();
		
		ProductViewController ov = new ProductViewController(o, ctd);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
