import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderTest {

	
	
	public InputReaderTest() {
		
	}
	
	public static void main(String[] args) {
		InputStreamReader rIn = new InputStreamReader(System.in);
		while(true) {
			try {
				int c = rIn.read();
				System.out.println((char)c);
			} catch (IOException e) {
				// TODO: handle exception
			}
			
		}

	}

}
