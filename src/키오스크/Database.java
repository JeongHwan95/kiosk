package 키오스크;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Database {
	
	private List<Food> listForBurgers;
	private List<Food> listForForzenCustard;
	private List<Food> listForDrinks;
	
	Database(){
		
		listForBurgers = new ArrayList<>();
		listForForzenCustard = new ArrayList<>();
		listForDrinks = new ArrayList<>();
		
		listForBurgers.add(new Food("Burgers", "앵거스 비프 통살을 다져만든 버거", "ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6900));
		listForBurgers.add(new Food("Burgers", "앵거스 비프 통살을 다져만든 버거", "SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8900));
		listForBurgers.add(new Food("Burgers", "앵거스 비프 통살을 다져만든 버거", "Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9400));
		listForBurgers.add(new Food("Burgers", "앵거스 비프 통살을 다져만든 버거", "Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6900));
		listForBurgers.add(new Food("Burgers", "앵거스 비프 통살을 다져만든 버거", "Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5400));
		
		listForForzenCustard.add(new Food("Forzen Custard", "매장에서 신선하게 만드는 아이스크림", "딸기 아이스크림", "녹진한 딸기를 갈아만든 아이스크림", 4000));
		listForForzenCustard.add(new Food("Forzen Custard", "매장에서 신선하게 만드는 아이스크림", "우유 아이스크림", "신선한 우유로 만든 아이스크림", 4000));
		listForForzenCustard.add(new Food("Forzen Custard", "매장에서 신선하게 만드는 아이스크림", "초코 아이스크림", "녹진한 초코를 넣은 아이스크림", 4000));
		
		listForDrinks.add(new Food("Drinks", "매장에서 판매하는 신선한 음료", "콜라", "콜라", 2500));
		listForDrinks.add(new Food("Drinks", "매장에서 판매하는 신선한 음료", "사이타", "사이다", 2500));
		listForDrinks.add(new Food("Drinks", "매장에서 판매하는 신선한 음료", "환타", "환타", 2500));
	}
}
