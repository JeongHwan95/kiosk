package 키오스크;

import lombok.Getter;

@Getter
public class Menu {
	
	private String categoryName;
	private String categoryDescription;
	
	Menu(String categoryName, String categoryDescription){
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}
	
}
