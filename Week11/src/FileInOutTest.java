import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInOutTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("test.dat");
			for(int i = 1; i <= 10; i++) {
				fout.write(i);
			}
			
			FileInputStream fin = new FileInputStream("test.dat");
			InputStreamReader fw = new InputStreamReader(fin);
			int c;
			while((c = fw.read()) != -1) {
				System.out.println(c + " ");
			}
			fw.close();
			fout.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("파일을 스거나 읽을 수 없음");
		}
		
		
		

	}

}
