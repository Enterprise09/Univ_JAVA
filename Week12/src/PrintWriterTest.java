import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterTest {

	public static void main(String[] args) {
		//������ �ξ� ���ٰ� �մϴ�. 2����Ʈ�� ����ϱ� ������
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		pw.write("�ڹ� ���α׷��� ����");
		pw.flush();
		pw.close();

	}

}
