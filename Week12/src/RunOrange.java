
public class RunOrange {

	public static void main(String[] args) {
		WThread t1 = new WThread("���ϳ�");
		WThread t2 = new WThread("�ڼ���");
		WThread t3 = new WThread("�տ���");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
