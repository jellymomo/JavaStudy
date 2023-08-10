package Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class HashMapExample {

	public static void main(String[] args) {
		//Map 컬렉션 새성
		Map<String, Integer> map = new HashMap<>();
		
		//객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 Entry 수:" + map.size());
		System.out.println();
		
		//키로 값 얻기
		String key = "홍길동";
		int value = map.get(key);
		System.out.println(key + ": " + value);
		System.out.println();
		
		//키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			String k = keyIterator.next();
			Integer v = map.get(k);
			System.out.println(k + " : " + v);
		}
		System.out.println();
		
		//엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k + " : " + v);
		}
		System.out.println();
		
		
		//키로 엔트리 삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수: " + map.size());
		System.out.println();
	}

}

/*
 
 import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

    public static void main(String[] args) {
        // HashMap 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();
        
        // 객체 저장
        map.put("신용권", 85); // "신용권"이라는 키에 85라는 값을 저장
        map.put("홍길동", 90); // "홍길동"이라는 키에 90이라는 값을 저장
        map.put("동장군", 80); // "동장군"이라는 키에 80이라는 값을 저장
        map.put("홍길동", 95); // "홍길동"이라는 키에 95라는 값을 저장 (이미 존재하는 키의 값을 덮어씀)
        System.out.println("총 Entry 수:" + map.size()); // 현재 맵에 저장된 엔트리의 수 출력
        System.out.println();
        
        // 키로부터 값 얻기
        String key = "홍길동";
        int value = map.get(key); // "홍길동"이라는 키에 해당하는 값 95를 가져옴
        System.out.println(key + ": " + value);
        System.out.println();
        
        // 키 Set 컬렉션을 얻고, 반복하여 키와 값을 얻기
        Set<String> keySet = map.keySet(); // 맵의 모든 키들을 Set으로 반환
        Iterator<String> keyIterator = keySet.iterator(); // 키들을 반복하기 위한 Iterator 생성
        while (keyIterator.hasNext()) {
            String k = keyIterator.next(); // 다음 키를 가져옴
            Integer v = map.get(k); // 해당 키에 대응하는 값을 가져옴
            System.out.println(k + " : " + v);
        }
        System.out.println();
        
        // 엔트리 Set 컬렉션을 얻고, 반복하여 키와 값을 얻기
        Set<Entry<String, Integer>> entrySet = map.entrySet(); // 모든 엔트리(키-값 쌍)들을 Set으로 반환
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator(); // 엔트리들을 순회하기 위한 Iterator 생성
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next(); // 다음 엔트리를 가져옴
            String k = entry.getKey(); // 엔트리의 키를 가져옴
            Integer v = entry.getValue(); // 엔트리의 값(키에 대응하는 값)을 가져옴
            System.out.println(k + " : " + v);
        }
        System.out.println();
        
        // 키로 엔트리 삭제
        map.remove("홍길동"); // "홍길동"이라는 키에 대응하는 엔트리 삭제
        System.out.println("총 Entry 수: " + map.size()); // 삭제 후 맵에 남은 엔트리의 수 출력
        System.out.println();
    }
}

 
 
 */
