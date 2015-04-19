package feat1;
import java.io.*;
import java.util.*;
public class MainClass 
{
	
	public static void main(String args[])
	{
		try
		{
			long start=System.currentTimeMillis();
			BufferedReader br=new BufferedReader(new FileReader(new File("/home/pawan/IRE/majorproject/yoochoose-data/yoochoose-clicks.dat")));
			String line; 
			//boolean sorted=true;
			//long prev=0;
			LinkedHashMap <String, LinkedHashMap<String, Integer>> hm = new LinkedHashMap<>();
			/*if(hm.get("x1")==null)
			{
				hm.put("x1", new TreeMap<String, Integer>());
				hm.get("x1").put("x11", 1);
			}
			System.out.println(hm);*/
			int i=0; boolean toChange=false;
			String prev="";
			int counter=0;
			while((line=br.readLine())!=null)
			{
				//System.out.println(line);
				String xx[]=line.split(",");
				if(toChange)
				{
					if(!prev.equals(xx[0]))
					{
						write(hm);
						hm.clear();
						counter++;
						System.out.println(counter);
						toChange=false;
						i=0;
					}
				}
				if(hm.get(xx[0])==null)
				{
					hm.put(xx[0], new LinkedHashMap<String, Integer>());
					hm.get(xx[0]).put(xx[2], 1);
					hm.get(xx[0]).put("tot", 0);
				}
				else
				{
					if(hm.get(xx[0]).get(xx[2])==null)
					{
						hm.get(xx[0]).put(xx[2], 1);
					}
					else
					{
						int x=hm.get(xx[0]).get(xx[2]);
						x++;
						hm.get(xx[0]).put(xx[2], x);
					}
				}
				int z=hm.get(xx[0]).get("tot");
				z++;
				hm.get(xx[0]).put("tot", z);
				i++;
				if(i==50000)
				{
					toChange=true;
				}
				prev=xx[0];
			}
			br.close();
			write(hm);
			//System.out.println("Number of session IDs "+hm.size());
			long end=System.currentTimeMillis();
			//end=System.currentTimeMillis();
			System.out.println("Time: "+(end-start)+" ms");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void write(LinkedHashMap <String, LinkedHashMap<String, Integer>> hm)
	{
		try
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter(new File("output1"), true));
			//System.out.println("Time for reading: "+(end-start)+" ms");
			Iterator it = hm.entrySet().iterator();
			while (it.hasNext()) 
		    {
		        Map.Entry pairs = (Map.Entry)it.next();
		        //bw.write(pairs.getKey()+","+pairs.getValue()+"\n");
		        Iterator it1=((LinkedHashMap)pairs.getValue()).entrySet().iterator();
		        int z=hm.get(pairs.getKey()).get("tot");
		        while(it1.hasNext())
		        {
		        	Map.Entry pairs1 = (Map.Entry)it1.next();
		        	double ratio=((int)pairs1.getValue())/((double)z);
		        	if(!pairs1.getKey().equals("tot"))
		        		bw.write(pairs.getKey()+","+pairs1.getKey()+","+ratio+"\n");
		        }
		    
		    }
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
