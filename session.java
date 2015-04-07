import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class session {
	 static BufferedReader br = null;
	 static FileWriter fw;
	 static BufferedWriter bw;

	 
	 public static void main(String[] args) throws IOException {
		 br = new BufferedReader(new FileReader("/home/user/Downloads/yoochoose-data/yoochoose-test.dat"));
		 fw = new FileWriter("sessionclicksTest.dat");
		 bw = new BufferedWriter(fw);

		 String line;
		String temp="abcbcc";
		int count = 0;
		 
		while((line=br.readLine())!= null)
		{
			//System.out.println(line);
			String[] line1 = line.split(",");
			if(!line1[0].equals(temp))
			{
				String tcount = Integer.toString(count);
		//		System.out.println(temp + " " + count);
				bw.write(temp);
				bw.write(",");
				bw.write(tcount);
				bw.write("\n");
				count =1;
				temp = line1[0];
			}
			else
				count++;
		}
		String tcount = Integer.toString(count);		
		bw.write(temp);
		bw.write(",");
		bw.write(tcount);
		bw.write("\n");
		
	//	System.out.println(count);
		bw.close();
	}
		
}
