
public class Orange {
	public static int orangeCount = 50;
	
	public static synchronized void takeOut(String name, int num) {
		
		
		
		if(num <= orangeCount ) {
			orangeCount -= num;
			System.out.println(name + " : " + num + "개의 오렌지를 꺼내감");
		}
		else {
			System.out.println("오렌지가 부족합니다.");
		}
		
		System.out.println("현재 남은 오렌지의 개수는 : " + orangeCount);
		
		
	}
	
	
}
