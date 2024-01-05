package 키오스크;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Log
public class OrderDB {
	
	Database db;
	OrderDB orderDB;
	@Setter Map<Food, Integer> cart;
	@Setter int orderNumber ;
	
	public OrderDB() {
		log.info("start");
		
		this.orderNumber = 0;
		this.cart = new LinkedHashMap<>();
		this.db = new Database();
		this.orderDB = this;
	}
	
	public void addFoodIntoCart(int choice, int numOfFood) {
		log.info("start");
		
		if(choice == 1) {
			Food wantedFood = db.getListForBurgers().get(numOfFood);
			cart.put(wantedFood, cart.getOrDefault(wantedFood, 0)+1);
			
			log.info("hanburger (choice==1)을 성공적으로 넣음");
		}else if(choice == 2 ) {
			Food wantedFood = db.getListForForzenCustard().get(numOfFood);
			cart.put(wantedFood, cart.getOrDefault(wantedFood, 0)+1);
			
			log.info("ForzenCustard (choice==2)을 성공적으로 넣음");
		}else if(choice == 3) {
			Food wantedFood = db.getListForDrinks().get(numOfFood);
			cart.put(wantedFood, cart.getOrDefault(wantedFood, 0)+1);
			
			log.info("Drinks (choice==3)을 성공적으로 넣음");
		}
	
	}

	public void removeAll() {
		log.info("start");
		
		this.cart = new LinkedHashMap<>();
		log.info("성공적으로 cart 내용을 없앤다. ");
	} // removeAll()
}
