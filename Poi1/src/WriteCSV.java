import java.util.*;

import com.opencsv.CSVWriter;

import java.io.*;

public class WriteCSV {

	public static void main(String[] args) {
		
		
		
try {
			
			String fileHeader = "id,name,price,quantity,creationDate";
			List<Pojo> list = new ArrayList<Pojo>();
			list.add(new Pojo(1, "food", 10, 20, new Date()));
			list.add(new Pojo(2, "juice", 90, 22, new Date()));
			list.add(new Pojo(3, "pepsi", 20, 21, new Date()));
			list.add(new Pojo(4, "chepsy", 40, 26, new Date()));
			FileWriter fw = new FileWriter("writecsv.csv");
			fw.append(fileHeader);
			for (Pojo p : list) {
				fw.append("\n");
				fw.append(String.valueOf(p.getId()));
				fw.append(",");
				fw.append(p.getName());
				fw.append(",");
				fw.append(String.valueOf(p.getPrice()));
				fw.append(",");
				fw.append(String.valueOf(p.getQuantity()));
				fw.append(",");
				fw.append(p.getCreationDate().toString());
				
				
				}
			fw.flush();
			fw.close();
			System.out.println("saved");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		
		}

			
	}

}
