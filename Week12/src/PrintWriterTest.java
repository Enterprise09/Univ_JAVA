import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterTest {

	public static void main(String[] args) {
		//성능이 훨씬 좋다고 합니다. 2바이트씩 출력하기 때문에
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		pw.write("자바 프로그래밍 응용");
		pw.flush();
		pw.close();

	}

}
