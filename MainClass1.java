package prepData;
import java.io.*;
import java.util.*;

public class MainClass 
{
	static void mergeAll()
	{
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(new File("/home/pawan/finDataTest1.dat")));
			HashMap <String, String> hm1=new HashMap<>();
			String linx;
			long start=System.currentTimeMillis();
			while((linx=br.readLine())!=null)
			{
				String xx[]=linx.split(",");
				hm1.put(xx[0], xx[1]+","+xx[2]);
			}
			long end=System.currentTimeMillis();
			System.out.println("Reading time:"+(end-start)+" ms");
			br=new BufferedReader(new FileReader(new File("/home/pawan/finDataTest2.dat")));
			BufferedWriter bw =new BufferedWriter(new FileWriter(new File("/home/pawan/finDataTest3.dat")));
			while((linx=br.readLine())!=null)
			{
				String xx[]=linx.split(",");
				String value=hm1.get(xx[0]);
				float x=(float)Math.log(Float.parseFloat(xx[2]));
				bw.write(x+","+xx[3]+","+value+"\n");
			}
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		mergeAll();
		//finDataBuys();
		//BuysId();
	}
	static void finDataBuys()
	{
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(new File("/home/pawan/IRE/majorproject/yoochoose-data/yoochoose-buys.dat")));
		TreeMap<String, String> hm1=new TreeMap<>();
		String linx;
		long start=System.currentTimeMillis();
		while((linx=br.readLine())!=null)
		{
			String xx[]=linx.split(",");
			hm1.put((xx[0]+","+xx[2]), "1");
		}
		long end=System.currentTimeMillis();
		System.out.println("Reading time: "+(end-start)+" ms");
		System.out.println(hm1.size());
		/*br=new BufferedReader(new FileReader(new File("/home/pawan/finData.dat")));
		BufferedWriter bw =new BufferedWriter(new FileWriter(new File("/home/pawan/finData2.dat")));
		int i=0;
		while((linx=br.readLine())!=null)
		{
			String xx[]=linx.split(",");
			if(hm1.get(xx[0]+","+xx[1])!=null)
			{
				bw.write(linx+","+"1"+"\n");
				//if(i%100==0)
					//System.out.println(linx);
				i++;
			}
			else
			{
				bw.write(linx+","+"0"+"\n");
			}
		}
		
		System.out.println("No. of buys:"+i);
		bw.close();
		br.close();*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void mergeDat()
	{
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(new File("/home/pawan/IRE/majorproject/yoochoose-data/yoochoose-buys.dat")));
		BufferedReader br1=new BufferedReader(new FileReader(new File("/home/pawan/IRE/majorproject/reqdata/sID,SIC.dat")));
		String line, line1;
		int i=0; long sessions=0;
		LinkedHashMap<String, String> hm=new LinkedHashMap<>();
		String prev="1";
		long start=System.currentTimeMillis();
		while((line=br.readLine())!=null)
		{
			String xx[]=line.split(",");
			if(!xx[0].equals(prev))
			{
				BufferedWriter bw =new BufferedWriter(new FileWriter(new File("/home/pawan/finData.dat"),true));
				for(int j=0; j<i; j++)
				{
					line1=br1.readLine();
					String xx1[]=line1.split(",");
					String lin=hm.get(xx1[0]+","+xx1[1]);
					lin=lin+","+xx1[2]+"\n";
					bw.write(xx1[0]+","+xx1[1]+","+lin);
				}
				bw.close();
				prev=xx[0];
				hm.clear();
				i=0;
				sessions++;
				if(sessions%100==0)
					System.out.println(sessions);
			}
			i++;
			hm.put(xx[0]+","+xx[1], xx[2]);
		}
		BufferedWriter bw =new BufferedWriter(new FileWriter(new File("/home/pawan/finData.dat"),true));
		for(int j=0; j<i; j++)
		{
			line1=br1.readLine();
			String xx1[]=line1.split(",");
			String lin=hm.get(xx1[0]+","+xx1[1]);
			lin=lin+","+xx1[2]+"\n";
			bw.write(xx1[0]+","+xx1[1]+","+lin);
		}
		bw.close();
		//System.out.println("Total Sessions: "+sessions);
		long end=System.currentTimeMillis();
		System.out.println("Time: "+(end-start)+" ms");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void BuysId()
	{
		
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(new File("/home/pawan/IRE/majorproject/test/BuyTimeTest.dat")));
		HashMap<String, String> hm1=new HashMap<>();
		String linx;
		long start=System.currentTimeMillis();
		while((linx=br.readLine())!=null)
		{
			String xx[]=linx.split(",");
			hm1.put((xx[0]+","+xx[1]), xx[2]);
		}
		long end=System.currentTimeMillis();
		System.out.println("Reading time: "+(end-start)+" ms");
		System.out.println(hm1.size());
		br=new BufferedReader(new FileReader(new File("/home/pawan/IRE/majorproject/test/sID,sIC.dat")));
		BufferedWriter bw =new BufferedWriter(new FileWriter(new File("/home/pawan/finDataTest2.dat")));
		int i=0;
		while((linx=br.readLine())!=null)
		{
			String xx[]=linx.split(",");
			String value=hm1.get(xx[0]+","+xx[1]);
			bw.write(linx+","+value+"\n");
			i++;
		}
		
		System.out.println("No. of writes:"+i);
		bw.close();
		br.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
