import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class result {
	 static BufferedReader br = null;
	 static FileWriter fw;
	 static BufferedWriter bw;
	 public static void main(String[] args) throws IOException {
		 br = new BufferedReader(new FileReader("temporaryfile"));
		 fw = new FileWriter("result.dat");
		 bw = new BufferedWriter(fw);
		 String line;
		 int count = 0;
		 int i=0;
			while((line=br.readLine())!= null)
			{
				count = 0;
				String[] line1 = line.split(",");
				String sessionid = line1[0];
				for(i=1;i<12;i++)
				{
					if(line1[i].equals("1"))
						count++;
				}	
				bw.write(line1[0]);
				bw.write(",");
				if(count >= 3)
				{
					bw.write("1");
				}
				else
					bw.write("0");
				bw.write("\n");
			}
			bw.close();
	 }
}
