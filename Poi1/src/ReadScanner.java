import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadScanner {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("csv1.csv"));
			sc.useDelimiter(",");
			while (sc.hasNext()) {
				String s = sc.next();
				System.out.print(s + "*");
				
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
