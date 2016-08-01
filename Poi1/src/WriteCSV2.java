import java.util.*;

import com.opencsv.CSVWriter;

import java.io.*;

public class WriteCSV2 {

	public static void main(String[] args) {
		try {
			CSVWriter csvw = new CSVWriter(new FileWriter("writecsv1.csv"));
			List <String[]> l = new ArrayList<String[]>();
			l.add(new String[]{"1","dsa","dsa"});
			l.add(new String[]{"2","re","rere"});
			l.add(new String[]{"3","refs","refd"});
			csvw.writeAll(l);
			csvw.close();
			System.out.println("done");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
