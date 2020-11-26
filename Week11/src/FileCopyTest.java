import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {

	
	
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("data1.txt");
			FileWriter fw = new FileWriter("data2.txt");
			
			
			int c;
			while((c = fr.read()) != -1) {
				fw.write(c);
			}
			
			fr.close();
			fw.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		} 
		catch (IOException e) {
			System.out.println("파일에 출력할 수 없습니다.");
		}
		

	}

}
