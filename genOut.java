import java.io.*;
import java.util.*;

public class genOut 
{
	public static void main(String args[])
	{
		try
		{/*
			BufferedReader brx=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Give path of yoochoose-test.dat");
			String path=brx.readLine();
			System.out.println("Give path of PredictedLabel file CSV!");
			String path2=brx.readLine();
			System.out.println("Give the threshold:");
			String thr=brx.readLine();
			int threshold=Integer.parseInt(thr);
			brx.close();*/
			BufferedReader br=new BufferedReader(new FileReader(new File("../dataset/yoochoose-test.dat"))); //Give test data path
			BufferedReader br1=new BufferedReader(new FileReader(new File("../FilterNewPredictedResult.csv"))); //Change name of file here
			br1.readLine();
			String line, line1;
			int i=0; long sessions=0; int counter=0;
			long start=System.currentTimeMillis();
			BufferedWriter bw =new BufferedWriter(new FileWriter(new File("./TestDataOut.dat")));
			String prev="5";
			ArrayList<String> al=new ArrayList<>();
			LinkedHashSet<String>al1=new LinkedHashSet<>();
			//int i=0;
			while((line=br.readLine())!=null)
			{
				//i+=1;
				String xx[]=line.split(",");
				line1=br1.readLine();
				String x[]=line1.split(",");
				if(!xx[0].equals(prev))
				{
					//System.out.println(xx[0]+" "+prev);
					int z=al1.size(); int count=0;
					if(z>0)
					{
						bw.write(prev+";");
						//System.out.println("Writing z");
						for(String s:al1)
						{
							bw.write(s); count++;
							if(count!=z)
								bw.write(",");
						}
						bw.write("\n");
					}
					prev=xx[0];
					al1.clear();
					/*ArrayList<String> output=new ArrayList<>();
					for(int j=0; j<i; j++)
					{
						line1=br1.readLine();
						String xx1[]=line1.split(",");
						if(ones(xx1))
						{
							output.add(al.get(j));
						}
					}
					if(output.size()>0)
					{
						bw.write(prev+";");
						for(int zz=0; zz<output.size(); zz++)
						{
							String x=output.get(zz);
							bw.write(x);
							if(zz!=output.size()-1)
								bw.write(",");
						}
						bw.write("\n");
					}
					i=0;
					al.clear();
					prev=xx[0];*/
				}	
				if(ones(x))
				{
					al1.add(xx[2]);
				}
				i++;
				if(i%1000==0)
				{
					System.out.println(i);
				}
			}
			System.out.println("Lines: "+i);
			bw.close(); br.close(); br1.close(); 
			long end=System.currentTimeMillis();
			System.out.println("Time: "+(end-start)+" ms");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	static boolean ones(String x[])
	{
		int i=0;
		for(String z:x)
		{
			if(z.equals("1"))
			{
				i++;
			}

		}
		return i>=3?true:false;
	}
	
	
}
