import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterTest {

	public BufferedWriterTest() {


	}
	
	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write("버퍼를 사용한 출력");
			bw.flush();
			bw.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
