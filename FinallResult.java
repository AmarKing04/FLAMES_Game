package FlamesGame;

import java.util.LinkedHashSet;

public class FinallResult implements Runnable
{
	/*DATA OF FLAMES GAME*/
	final static int[] F_DATA = {3,5,14,16,18,21,23,32,34,60,63,65,74,76,78,81,83,92,94};
	final static int[] L_DATA = {10,19,36,37,39,41,52,54,57,59,70,79,96,97,99};
	final static int[] A_DATA = {8,12,13,17,28,30,35,46,50,55,68,72,73,77,88,90,95};
	final static int[] M_DATA = {6,11,15,26,31,33,44,48,49,53,66,71,75,86,91,93};
	final static int[] E_DATA = {2,4,7,9,20,22,24,25,42,51,62,64,67,69,80,82,84,85};
	final static int[] S_DATA = {1,27,29,38,40,43,45,47,56,58,61,87,89,98,100};
	LinkedHashSet data = new LinkedHashSet();
	static String fname;
	static String sname;
	static int dataNeed;
	static int remaningCharacters;
	static String errorMessage;
	
	@Override
	public void run() 
	{
		display();
		data.clear();
	}
	
	/*THIS IS USED TO DISPLAY THE OUTPUT*/
	public void display()
	{
		String result=find();
		
		ProcessData.waitingtime(100);
		
		System.out.print("\n\tPlease wait");
		
		for(int i=1;i<=5;i++)
		{
			ProcessData.waitingtime(1000);
			System.out.print(".");
		}
		
		System.out.println();
		System.out.println("\n\tAs Per My Analysis\n");
		System.out.println("\n\t\" "+fname+" \" &  \" "+sname+" \" == \" "+result+" \"");
	}
	
	/*THIS IS IMPORTANT METHOD, IT WILL GIVE YOU RESULT*/
	public String find()
	{
		if(remaningCharacters==1)
		{
			return errorMessage;
		}
		else
		{
			String[] finalOutput = {"FRIENDS","LOVERS","AFFECTION","MARRIAGE","ENEMYS","SUPPORTIVE"};
			int indexFinalOutput=0;
			int i=1;
			int[] restdata;
			int chara = remaningCharacters;
			while(true)
			{
				restdata = data(i);
				for(int dataAdd=0;dataAdd<restdata.length;dataAdd++)
				{
					data.add(restdata[dataAdd]);
				}
				if(data.contains(chara))
				{
					return finalOutput[indexFinalOutput];
				}
				data.clear();
				i++;
				indexFinalOutput++;
			}
		}
		
	}
	
	/*BASED ON REAMNING CHARACTER IT WILL SEND THE DATA*/
	public int[] data(int dataNeed)
	{
		switch(dataNeed)
		{
			case 1:
				return F_DATA;
			case 2:
				return L_DATA;
			case 3:
				return A_DATA;
			case 4:
				return M_DATA;
			case 5:
				return E_DATA;
			case 6:
				return S_DATA;				
		}
		return null;
	}
}
