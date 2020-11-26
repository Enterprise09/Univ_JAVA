import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuffereadReaderTest {
	
	public BuffereadReaderTest() {
		
	}

	public static void main(String[] args) {
		InputStreamReader rIn = new InputStreamReader(System.in);
		BufferedReader bIn = new BufferedReader(rIn);
		
		try {
			String line = bIn.readLine();
			System.out.println("Ãâ·Â : " + line);
		} catch (Exception e) {
			
		}
		
		
		
	}

}
