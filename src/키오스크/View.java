package 키오스크;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
public class View {

	Database db;
	OrderDB orderDB;
	@Setter Controller controller;
	List<Food> listForBurgers;
	List<Food> listForForzenCustard;
	List<Food> listForDrinks;

	
	public View(OrderDB orderDB) {
		log.info("start");
		this.orderDB = orderDB;
		this.db = new Database();
		this.listForBurgers = db.getListForBurgers();
		this.listForForzenCustard = db.getListForForzenCustard();
		this.listForDrinks = db.getListForDrinks();
	}

	public void showCategory() {
		log.info("start");
		
		System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다. ");
		System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요. ");
		System.out.println();

		System.out.println("[ SHAKESHACK MENU ]");
		System.out.println("1. " + listForBurgers.get(0).getCategoryName() + " | "
				+ listForBurgers.get(0).getCategoryDescription());
		System.out.println("2. " + listForForzenCustard.get(0).getCategoryName() + " | "
				+ listForForzenCustard.get(0).getCategoryDescription());
		System.out.println("3. " + listForDrinks.get(0).getCategoryName() + " | "
				+ listForDrinks.get(0).getCategoryDescription());

		
		System.out.println("[ ORDER MENU ]");
		System.out.println("4. Order");
		System.out.println("5. Cancel");
		
		
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
	
		this.controller.showCategoryFlow(answer);
	}



	public void checkOrder() {
		log.info("check Order start");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아래와 같이 주문 하시겠습니까? ");
		System.out.println("[ Order ]");
		int sum = 0;
		Map<Food, Integer> cart = this.orderDB.getCart();
		List<Food> keySet = new ArrayList<>(cart.keySet());
		for(int i=0; i<keySet.size(); i++) {
			
			Food food = keySet.get(i);
			int numOfFood = cart.get(food);
			
			System.out.println(food.getName() + " | "+ numOfFood +"개 | "+ food.getPrice() + " | "
					+ food.getDescription()+" | " );
			
			sum = sum + (numOfFood * food.getPrice());
		}
		
		System.out.println("[ Total ] ");
		System.out.println(sum + "원");
		System.out.println("1. 주문 \t\t 2.메뉴판");
		
		int answer = sc.nextInt();
		this.controller.checkOrderFlow(answer);
		
	}

	public void showDetail(int choice) {
		log.info("start");
		
		Scanner sc = new Scanner(System.in);
		
		if (choice == 1) {
			System.out.println("""
					SHAKESHACK BURGER 에 오신걸 환영합니다.
					아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.

					[ Burgers MENU ]
										""");
			for(int i=0; i<listForBurgers.size(); i++) {
				
				System.out.println(i+". " + listForBurgers.get(i).getName() + " | "+
				listForBurgers.get(i).getPrice() + " | " + listForBurgers.get(i).getDescription());
			} // for
		} //if
		else if(choice == 2) {

			System.out.println("""
					SHAKESHACK BURGER 에 오신걸 환영합니다.
					아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.

					[ Forzen Custard MENU ]
										""");
			for(int i=0; i<listForForzenCustard.size(); i++) {
				
				System.out.println(i+". " + listForForzenCustard.get(i).getName() + " | "+
				listForForzenCustard.get(i).getPrice() + " | " + listForForzenCustard.get(i).getDescription());
			}
		}else if(choice == 3) {


			System.out.println("""
					SHAKESHACK BURGER 에 오신걸 환영합니다.
					아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.

					[ Drinks Custard MENU ]
										""");
			for(int i=0; i<listForDrinks.size(); i++) {
				
				System.out.println(i+". " + listForDrinks.get(i).getName() + " | "+
				listForDrinks.get(i).getPrice() + " | " + listForDrinks.get(i).getDescription());
			}
		}
		
		int answer = sc.nextInt();
		
		System.out.println();
		System.out.println();
		this.beforeAddCart(choice, answer);
	}

	private void beforeAddCart(int choice, int numOfFood) {
		log.info("start");
		
		Scanner sc = new Scanner(System.in);

		List<Food> food ;
		
		if(choice==1) {
			food = this.listForBurgers;
		}else if(choice == 2) {
			food = this.listForForzenCustard;
		}else{
			food = this.listForDrinks;
		}
		
		System.out.println(food.get(numOfFood).getName() + " | " + food.get(numOfFood).getPrice()+ " | " + food.get(numOfFood).getDescription());
		System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
		System.out.println("1. 확인 \t\t 2.취소");
		
		int answer = sc.nextInt();
		
		controller.beforeAddCartFlow(answer, choice, numOfFood);
			
	}

	public void completeScreen() {
		
		System.out.println("주문이 완료되었습니다. ");
		
		System.out.println("대기번호는 [ " + this.orderDB.getOrderNumber() + " ] 번 입니다.");
		this.orderDB.setOrderNumber(this.orderDB.getOrderNumber()+1);
		System.out.println("3초후 메뉴판으로 돌아갑니다. ");
		
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showCancelView() {
		
		
		System.out.println("진행하던 주문을 취소하시겠습니까? ");
		System.out.println("1. 확인 \t\t 2.취소");
		
		Scanner sc  = new Scanner(System.in);
		int answer = sc.nextInt();
		controller.showCancelViewFlow(answer);
		
	}

	public void confirmCancelOrder() {
		log.info("start");
		System.out.println("진행하시던 주문이 취소되었습니다. ");
	}
}
