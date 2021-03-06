import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {

	public static void main(String[] args) {
		byte[] b = {11, 55, 22, 33, 77, 21, 31, 10};
		
		try {
			RandomAccessFile raf = new RandomAccessFile("temp/test2.txt", "rw");
			raf.write(b);
			
			for (int i = b.length - 1; i >= 0; i--) {
				raf.seek(i);
				System.out.println(raf.read());				
			}
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
