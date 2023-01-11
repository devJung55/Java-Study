package arrayListTask2;

public class Food {
	private String foodName;
	private int foodPrice;
	private String kindOfFood;

	public Food() {;}
	
	public Food(String foodName, int foodPrice, String kindOfFood) {
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.kindOfFood = kindOfFood;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getKindOfFood() {
		return kindOfFood;
	}

	public void setKindOfFood(String kindOfFood) {
		this.kindOfFood = kindOfFood;
	}

	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodPrice=" + foodPrice + ", kindOfFood=" + kindOfFood + "]";
	}

}
