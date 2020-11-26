import java.util.Random;

public class WThread extends Thread {

	public WThread(String name) {
		super(name);
				
		
	}
	
	@Override
	public void run() {
		
		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			try {
				sleep(500);
				
			} catch (InterruptedException e) {
				return;				
			}
			
			if(Orange.orangeCount == 0) {
				System.out.println("¿À·»Áö¸¦ ´Ù ¸Ô¾ú³×¿ä.");
				return;
			}
			
			Orange.takeOut(getName(), Math.abs(r.nextInt()%7));
			
		}
		
	}
	
	
}
