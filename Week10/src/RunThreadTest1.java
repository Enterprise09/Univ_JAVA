


public class RunThreadTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest1 t1 = new ThreadTest1("First Thread");
		ThreadTest1 t2 = new ThreadTest1("Second Thread");
		
		t1.start();
		t2.start();
	}

}
