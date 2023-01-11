package arrayListTask1;

import java.util.ArrayList;

public class Market {
	ArrayList<Fruit> fruits = DBConnecter.fruits;
	int total = 0;
	int average = 0;

//	���� �̸� �ߺ��˻�
	public Fruit checkFruitName(String fruitName) {
		Fruit fruit = null;

		for (Fruit temp : fruits) {
			if (temp.getFruitName().equals(fruitName)) {
				fruit = temp;
				return fruit;
			}
		}
		return fruit;
	}

//	���� �߰�
	public void insertFruit(Fruit fruit) {
		fruits.add(fruit);
	}

//	���� ����
	public void deleteFruit(Fruit fruit) {
		fruits.remove(fruit);
	}

//	���� ������ ��� ���ݺ��� ���� �� �˻�
	public boolean checkPrice(String fruitName, int fruitPrice) {
		boolean result = false;

		for (Fruit temp : fruits) {
			total = temp.getFruitPrice();
			average = total / fruits.size();

			if (temp.getFruitName().equals(fruitName)) {
				result = average > temp.getFruitPrice() ? true : false;
				return result;
			}
		}
		return result;
	}

//	���� ��ü ��ȸ
	public void selectAll() {
		for (Fruit temp : fruits) {
			System.out.println(temp);
		}
	}

//	���� �̸����� ���� ��ȸ
	public int selectPrice(String fruitsName) {
		for (Fruit temp : fruits) {
			if (temp.getFruitName().equals(fruitsName)) {
				return temp.getFruitPrice();
			}
		}
		return 0;
	}

}

//package arrayListTask;
//
//import java.util.ArrayList;
//
//public class Market {
//   public ArrayList<Fruit> fruits = DBConnecter.fruits;
//   
//// ���� �˻�
//   public Fruit checkFruit(String name) {
//      for (Fruit fruit : fruits) {
//         if(fruit.getName().equals(name)) {
//            return fruit;
//         }
//      }
//      return null;
//   }
//   
////   ���� �߰�
//   public void add(Fruit fruit) {
//      fruits.add(fruit);
//   }
//   
////   ���� ����
//   public void remove(String name) {
//      Fruit fruit = checkFruit(name);
//      fruits.remove(fruit);
//   }
//   
////   ���� ������ ��� ���ݺ��� ���� �� �˻�
//   public boolean checkPrice(int price) {
//      return getAverage() > price;
//   }
//   
////   ��� ����
//   private double getAverage() {
//      int total = 0;
//      
//      for (Fruit fruit : fruits) {
//         total += fruit.getPrice();
//      }
//      
//      return (double)total / fruits.size();
//   }
//   
////   ���� ��ü ��ȸ
//   public ArrayList<Fruit> selectAll() {
//      return fruits;
//   }
//   
////   ���� �̸����� ���� ��ȸ
//   public int findByName(String name) {
//      return checkFruit(name).getPrice();
//   }
//}










