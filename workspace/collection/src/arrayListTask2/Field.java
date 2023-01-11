package arrayListTask2;

public class Field {

	public static void main(String[] args) {
		Food bulgogi = new Food("불고기 전골", 30000, "한식");
		Food bibibab = new Food("전주 비빔밥", 12000, "한식");
		Restaurant restaurant = new Restaurant();

//		음식 추가 테스트
		restaurant.insertFood(bulgogi);
		System.out.println(bulgogi);

		restaurant.insertFood(bibibab);
		System.out.println(bibibab);

//		음식 이름으로 음식 종류 조회 테스트
		System.out.println(restaurant.selectkindOfFood("불고기 전골"));

//		사용자가 원하는 종류의 음식 전체 조회 테스트
		System.out.println(restaurant.selectAll("한식"));

//		음식 종류 수정 후 가격 10% 상승
		System.out.println(restaurant.updateFood(bibibab, "양식"));

//		사용자가 원하는 종류의 음식 개수 조회
		System.out.println(restaurant.selectCountFood("한식"));
	}

}
