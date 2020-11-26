import java.io.OutputStreamWriter;

public class OutputWriterTest {

	public static void main(String[] args) {
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		try {
			ow.write("자바 프로그래밍 응용");
			ow.flush();
		} catch (Exception e) {
			
		}
		

	}

}
