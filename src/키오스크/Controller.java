package 키오스크;

import java.util.LinkedHashMap;

import lombok.extern.java.Log;

@Log
public class Controller {

	
	View view;
	OrderDB orderDB;
	
	public Controller(View view, OrderDB orderDB) {
		log.info("start");
		
		this.view = view;
		this.orderDB = orderDB;
	}
	
	public void showCategoryFlow(int choice) {
		log.info("start");
		
		switch (choice) {

		case 1:
		case 2:
		case 3:
			this.view.showDetail(choice);
			break;
		case 4:
			this.view.checkOrder();
			break;
		case 5:
			this.view.showCancelView();
			

		} // switch
	}

	public void beforeAddCartFlow(int choiceNum, int choice, int numOfFood) {
		log.info("start");
		
		if(choiceNum==1) {
			this.orderDB.addFoodIntoCart(choice, numOfFood);
		}else if(choiceNum == 2) {
			// 가만히 내둔다. 
		}
	}

	public void checkOrderFlow(int choice) {
		log.info("start");
		
		if(choice ==1) {
			this.view.completeScreen();
			this.orderDB.setCart(new LinkedHashMap<>());;
		}
		else {
			
		}
		
	}

	public void showCancelViewFlow(int answer) {
		
		if(answer==1) {
			this.orderDB.removeAll();
			view.confirmCancelOrder();
		}
		
	}
}
