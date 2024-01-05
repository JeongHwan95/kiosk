package 키오스크;

public class Main {

	public static void main(String[] args) {
		
		OrderDB orderDB = new OrderDB();
		View view = new View(orderDB);
		Controller controller = new Controller(view, orderDB);
		view.setController(controller);
		
		while(true) {
			view.showCategory();
		}
	}
}
