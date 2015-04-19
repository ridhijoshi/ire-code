import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class functions {
	static BufferedReader br1 = null;
	 static FileWriter fw1;
		static BufferedReader br2 = null;
		 static FileWriter fw2;
		 static BufferedWriter bw1;
		 static BufferedWriter bw2;
		 
	public static void main(String[] args) throws IOException {
		br1 = new BufferedReader(new FileReader("/home/user/Downloads/yoochoose-data/yoochoose-buys.dat"));
		br2 = new BufferedReader(new FileReader("/home/user/workspace/iremajor/category-values.dat"));
		fw1 = new FileWriter("new-buys.dat");
		bw1 = new BufferedWriter(fw1);
		String line = "";
		int condition = 0;
		TreeMap<String,String> output = new TreeMap<String,String>();
		 while((line = br2.readLine())!= null)
		 {
			 String[] line1 = line.split(",");
			 if(!output.containsKey(line1[1]))
			 {
				 output.put(line1[1], line1[2]);
			 }
		 }
		 String aa = "214757390";
		 System.out.println(aa);
		 String bb = "214848658";
		 String fr1 = (String)output.get(aa);
			System.out.println("this is" +fr1);
			String fr2 = (String)output.get(bb);
			System.out.println("this is" +fr2);

		String line3 = "";
		 while((line3 = br1.readLine())!= null)
		 {
			 
			 String[] line4 = line3.split(",");
			 condition = 0;
			 String val = (String)output.get(line4[2]);
			 System.out.println(val);
			 bw1.write(line4[0]);
			 bw1.write(",");
			 bw1.write(line4[1]);
			 bw1.write(",");
			 bw1.write(line4[2]);
			 bw1.write(",");
			 bw1.write(line4[3]);
			 bw1.write(",");
			 bw1.write(line4[4]);
			 bw1.write(",");
			 bw1.write(val);
			 bw1.write("\n");
		 }
		 bw1.close();
	
			 //	 System.out.println(line1[2]);
		//	 br2.mark(2);
		//	 br2.reset();
			// br2 = new BufferedReader(new FileReader("/home/user/workspace/iremajor/category-values.dat"));
			// while((line2 = br2.readLine())!= null)
			// {
			//	 if(condition == 0)
			//	 { 
					 
				//	 String[] inner = line2.split(",");
				//	 System.out.println(inner[2]);

			/*		 if(line1[2].equals(inner[1]))
					 {
						 condition = 1;
						 bw1.write(line1[0]);
						 bw1.write(",");
						 bw1.write(line1[1]);
						 bw1.write(",");
						 bw1.write(line1[2]);
						 bw1.write(",");
						 bw1.write(line1[3]);
						 bw1.write(",");
						 bw1.write(line1[4]);
						 bw1.write(",");
						 bw1.write(inner[2]);
						 bw1.write("\n");



						 System.out.println(inner[2]);
					 }
*/
			//	 }
//				 else 
	//				 continue;
			// }
			// br2.reset();
		// }
		 
	}
	

}
