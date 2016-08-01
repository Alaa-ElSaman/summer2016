import java.util.*;

import java.io.*;

import com.opencsv.CSVReader;

public class CSV {

	public static void main(String[] args) throws FileNotFoundException  {
		//reading existing csv file
		String[] row = null;
		String file = "csv1.csv";
		CSVReader csv;
		
			try {
				csv = new CSVReader(new FileReader(file));
				List all = csv.readAll();
				
				for (Object obj : all) {
					row =(String[]) obj;
					System.out.println(row[0] +"\t*"+ row[1] +"\t*" +row[2]+ "\t*"+ row[3]);
				}
				csv.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			
}
}