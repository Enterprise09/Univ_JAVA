import java.io.File;

public class FileTest {

	
	
	public static void main(String[] args) {
		File file = new File("temp/test.txt");
		if(file.exists()) {
			System.out.println("* ���� �̸� : " + file.getName());
			System.out.println("* ��� ��� : " + file.getPath());
			System.out.println("* ���� ��� : " + file.getAbsolutePath());
			System.out.println("* ���� ���� : " + file.canWrite());
			System.out.println("* �б� ���� : " + file.canRead());
			System.out.println("* ���� ���� : " + file.isFile());
			System.out.println("* ���� ���� : " + file.isDirectory());
			System.out.println("* ���� ũ�� : " + file.length() + "bytes");
		}else {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
//		System.out.println(file.exists());

	}

}
