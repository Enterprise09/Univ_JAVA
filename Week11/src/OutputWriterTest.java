import java.io.OutputStreamWriter;

public class OutputWriterTest {

	public static void main(String[] args) {
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		try {
			ow.write("�ڹ� ���α׷��� ����");
			ow.flush();
		} catch (Exception e) {
			
		}
		

	}

}
