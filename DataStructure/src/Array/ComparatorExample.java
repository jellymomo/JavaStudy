package Array;

import java.util.TreeSet;

public class ComparatorExample {

	public static void main(String[] args) {
		
		//비교자를 제공한 TreeSet 컬렉션 생성
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());
		
		//객체 저장
		treeSet.add(new Fruit("grape", 3000));
		treeSet.add(new Fruit("atermelon", 10000));
		treeSet.add(new Fruit("strawberry", 6000));
		
		//객체를 하나씩 가져오기
		for(Fruit fruit : treeSet) {
			System.out.println(fruit.name + ":" + fruit.price);
		}
		
	}

}
