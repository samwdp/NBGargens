import view.OrderForm;
import controller.OrderFormController;
import controller.ViewController;
import database.ConnectionToDatabase;

/**
 * Initialises the program
 * @author Sam Precious
 *
 */
public class Initilizer {

	
	public static void main(String[] args) throws ClassNotFoundException {
		ConnectionToDatabase ctd = new ConnectionToDatabase();
		OrderFormController ofc = new OrderFormController(ctd);
		OrderForm of = new OrderForm();
		
		of.addProducts(ofc.getProducts());
		ViewController c = new ViewController(ctd);
		
		c.addProducts(of);
		
		
	}

}
