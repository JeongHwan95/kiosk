package 키오스크;

import lombok.Getter;

@Getter
public class Food extends Menu{

	private String name;
	private String description;
	private int price; 
	
	Food(String categoryName, String categoryDescription, 
			String name, String description, int price) {
		super(categoryName, categoryDescription);
		
		this.name = name;
		this.description = description; 
		this.price = price;
	} // food
}
