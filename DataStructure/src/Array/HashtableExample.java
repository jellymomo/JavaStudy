package Array;
	
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;
	
public class HashtableExample {
	public static void main(String[] args) {
		//Hashtable 컬렉션 생성
		Map<String, Integer> map = new Hashtable<>();
		
		//작업 스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				//엔트리 1000개 추가
				for (int i = 1; i <= 30; i++) {
					map.put(String.valueOf(i), i);
				}
			}
		};
		
		//작업 스레드 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				//엔트리 1000개 추가
				for (int i = 31; i <= 60; i++) {
					map.put(String.valueOf(i), i);
				}
			}
		};
		//작업 스레드 실행
		threadA.start();
		threadB.start();
		
		//작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게함
		try {
			threadA.join();
			threadB.join(); 
		} catch (Exception e) {	
		}
		
		//저장된 총 엔트리 수 얻기
		int size = map.size();
		System.out.println("총 엔트리 수: " + size);
		
		
		Set<Entry<String, Integer>> entry = map.entrySet();
		Iterator<Entry<String, Integer>> entryI = entry.iterator();
		while(entryI.hasNext()) {
			Entry<String, Integer> entryA = entryI.next();
			String k = entryA.getKey();
			Integer v = entryA.getValue();
			System.out.println(k + ":" + v);
		}
	}
}
