
public class RunOrange {

	public static void main(String[] args) {
		WThread t1 = new WThread("박하나");
		WThread t2 = new WThread("박세리");
		WThread t3 = new WThread("손예진");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
