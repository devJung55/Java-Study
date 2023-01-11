package arrayListTask3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DateApp {
	ArrayList<Love> loves = DBConnecter.loves;

//	사용자가 원하는 나이의 이상형 목록 조회
	public ArrayList<Love> select(int userAge) {
		ArrayList<Love> users = new ArrayList<Love>();

		for (Love love : loves) {
			if (love.getUserAge() == userAge) {
				users.add(love);
				return users;
			}
		}
		return users;
	}

//	이상형 나이 수정
	public Love updateAge(Love love) {
		for (Love temp : loves) {
			if (temp.equals(love)) {
				temp.setUserAge(love.getUserAge());
				return temp;
			}
		}
		return null;
	}

//	이상형 나이 순 정렬
	public ArrayList<Love> orderByAge() {
		ArrayList<Integer> userAge = new ArrayList<>();
		ArrayList<Love> order = new ArrayList<Love>();

		for (Love love : loves) {
			userAge.add(love.getUserAge());
		}
		Collections.sort(userAge);

		for (int age : userAge) {
			for (int i = 0; i < loves.size(); i++) {
				if (age == loves.get(i).getUserAge()) {
					order.add(loves.get(i));
					loves.remove(loves.get(i));
				}
			}
		}
		return order;
	}
}
