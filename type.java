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

public class type {
	static float a0 = 0;
	static float a1 = 0;
	static float a2 = 0;
	static float a3 = 0;
	static float a4 = 0;
	static float a5 = 0;
	static float a6 = 0;
	static float a7 = 0;
	static float a8 = 0;
	static float a9 = 0;
	static float a10 = 0;
	static float a11 = 0;
	static float a12 = 0;
	static float a13 = 0;
	static float a14 = 0;
	static float c0 = 0;
	static float c1 = 0;
	static float c2 = 0;
	static float c3 = 0;
	static float c4 = 0;
	static float c5 = 0;
	static float c6 = 0;
	static float c7 = 0;
	static float c8 = 0;
	static float c9 = 0;
	static float c10 = 0;
	static float c11 = 0;
	static float c12 = 0;
	static float c13 = 0;
	static float c14 = 0;

	static long total =0;
	static long average = 0;
	static BufferedReader br = null;
	 static FileWriter fw;
	 static BufferedWriter bw;
	 static FileWriter fw1;
	 static BufferedWriter bw1;

	 
	 public static void main(String[] args) throws IOException {
		 br = new BufferedReader(new FileReader("/home/user/Downloads/yoochoose-data/yoochoose-clicks.dat"));
		 fw = new FileWriter("category-values.dat");
		 bw = new BufferedWriter(fw);
		 fw1 = new FileWriter("normalized-category.dat");
		 bw1 = new BufferedWriter(fw1);

		 String line = "";
		 while((line = br.readLine())!= null)
		 {
			 	int number;
			 	String temp="";
				String[] line1 = line.split(",");
				bw.write(line1[0]);
				bw.write(",");
				bw.write(line1[2]);
				
		
			if( line1[3].equals("S"))
			{	
					temp = "14";
					a14++;
			}
			else if( line1[3].equals("s"))
			{			
				temp = "14";
				a14++;
			}
			else
				{
					number = Integer.parseInt(line1[3]);
					if(number > 12)
					{	
						temp = "13";
						a13++;
					}
					else
					{
						if(number == 0)
							a0++;
						else if(number == 1)
							a1++;
						else if(number == 2)
							a2++;
						else if(number == 3)
							a3++;
						else if(number == 4)
							a4++;
						else if(number == 5)
							a5++;
						else if(number == 6)
							a6++;
						else if(number == 7)
							a7++;
						else if(number == 8)
							a8++;
						else if(number == 9)
							a9++;
						else if(number == 10)
							a10++;
						else if(number == 11)
							a11++;
						else if(number == 12)
							a12++;

						temp =Integer.toString(number);
						
					}
					}	
				
				bw.write(",");
				bw.write(temp);
				bw.write("\n");
		 }
		 bw.close();
		 total = (long)(a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14);
		 average = (long)total /15;
		 		 c0 = a0/total;
		 		System.out.println(total);
		 		System.out.println(c0);
		 		System.out.println(a0);

		 		 c1 = (a1/total);
		 c2 = (a2/total);
		 c3 = (a3/total);
		 c4 = (a4/total);
		 c5 = (a5/total);
		 c6 = (a6/total);
		 c7 = (a7/total);
		 c8 = (a8/total);
		 c9 = (a9/total);
		 c10 = (a10/total);
		 c11 = (a11/total);
		 c12 = (a12/total);
		 c13 = (a13/total);
		 c14 = (a14/total);
		 System.out.print(total);
		 String b0 = Float.toString(c0);
		 String b1 = Float.toString(c1);
		 String b2 = Float.toString(c2);
		 String b3 = Float.toString(c3);
		 String b4 = Float.toString(c4);
		 String b5 = Float.toString(c5);
		 String b6 = Float.toString(c6);
		 String b7 = Float.toString(c7);
		 String b8 = Float.toString(c8);
		 String b9 = Float.toString(c9);
		 String b10 = Float.toString(c10);
		 String b11 = Float.toString(c11);
		 String b12 = Float.toString(c12);
		 String b13 = Float.toString(c13);
		 String b14 = Float.toString(c14);
		 bw1.write("a0");
		 bw1.write(",");
		 bw1.write(b0);
		 bw1.write("\n");
		 bw1.write("a1");
		 bw1.write(",");
		 bw1.write(b1);
		 bw1.write("\n");
		 bw1.write("a2");
		 bw1.write(",");
		 bw1.write(b2);
		 bw1.write("\n");
		 bw1.write("a3");
		 bw1.write(",");
		 bw1.write(b3);
		 bw1.write("\n");
		 bw1.write("a4");
		 bw1.write(",");
		 bw1.write(b4);
		 bw1.write("\n");
		 bw1.write("a5");
		 bw1.write(",");
		 bw1.write(b5);
		 bw1.write("\n");
		 bw1.write("a6");
		 bw1.write(",");
		 bw1.write(b6);
		 bw1.write("\n");
		 bw1.write("a7");
		 bw1.write(",");
		 bw1.write(b7);
		 bw1.write("\n");
		 bw1.write("a8");
		 bw1.write(",");
		 bw1.write(b8);
		 bw1.write("\n");
		 bw1.write("a9");
		 bw1.write(",");
		 bw1.write(b9);
		 bw1.write("\n");
		 bw1.write("a10");
		 bw1.write(",");
		 bw1.write(b10);
		 bw1.write("\n");
		 bw1.write("a11");
		 bw1.write(",");
		 bw1.write(b11);
		 bw1.write("\n");
		 bw1.write("a12");
		 bw1.write(",");
		 bw1.write(b12);
		 bw1.write("\n");
		 bw1.write("a13");
		 bw1.write(",");
		 bw1.write(b13);
		 bw1.write("\n");
		 bw1.write("a14");
		 bw1.write(",");
		 bw1.write(b14);
		 bw1.write("\n");
		 bw1.close();
	 }
}
