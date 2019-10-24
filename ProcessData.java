package FlamesGame;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProcessData 
{
	
	static
	{
		String info = "Hi welcome to our childhood game \"FLAMES \" .This game is most funny and time pass game we played in our childhood.\nSo, let's Start the game and"
				+ " again go back to childhood & remember our childhood \" GirlFriend | BoyFriend \"";
		System.out.println("\n\t\t========== FLAMES GAME ===========\n");
		for(int i=0;i<info.length();i++)
		{
			System.out.print(info.charAt(i));
			waitingtime(100);
		}
		
		System.out.print("\n\n\tLoading");
		for(int i =0;i<=10;i++)
		{
			if(i>=9)
				waitingtime(1000);
			else
			waitingtime(100);
			System.out.print(".");
		}
		System.out.println("\n");
		
	}
	
	Scanner sc = new Scanner(System.in);
	boolean checking;
	String returnName;
	String fname, sname;
	String errorfix;
	
	/*THIS METHOD IS TO START*/
	public void start()
	{
		int fname_length , sname_length;
	
		first_Name();
		second_Name();
		sc.close();
		
		/*WELL I CONSIDER LENGTH ALSO i.e.. TWO STRING LENGTHS
		 * BCZ WE NEED TO CONSIDER LOW LENGTH TO PROCESSING PUPROSE. WHY WE NEED TO CONSIDER LOW LENGTH ONLY ?
		 * IF I CONSIDER LOW LENGTH THEN MY PROCESS WILL COMPLETE QUICKLY.
		 * EX:- "kumar*, "amar" I CONSIDER TWO STRINGS WELL HERE 
		 * kumar = 5 & amar = 4 CONSIDER "4" BCZ IF I CONSIDER "5" IT WILL TAKE TIME
		 * WELL IF YOU CONSIDER "4" IT WILL NOT TAKE MUCH TIME BCS ONLY FEW CHAR ONLY*/
		fname_length = this.fname.length();
		sname_length = this.sname.length();
				
		if(fname_length < sname_length)
		{
			process(this.fname, this.sname);
		}
		else if(sname_length < fname_length)
		{
			process(this.sname, this.fname);
		}
		else if(fname_length==sname_length)
		{
			/*THIS IF BLOCK IS USED TO CHECK , BOTH NAME ARE SAME OR NOT 
			 * IF NOT NO NEED TO PROCESS*/
			if(fname.contains(sname))
			{
				FinallResult.errorMessage = "BOTH NAMES ARE SAME. SO, NO RESULT";
				FinallResult.fname = this.fname;
				FinallResult.sname = this.sname;
				FinallResult.remaningCharacters = 1;
			}
			if(checking(this.fname, this.sname))
			{
				FinallResult.errorMessage = "NO OUTPUT BCZ BOTH ARE LOOK SAME (\" PAILNDROME \")";
				FinallResult.fname = this.fname;
				FinallResult.sname = this.sname;
				FinallResult.remaningCharacters = 1;
			}
			else
			{
				process(this.fname, this.sname);
			}	
		}
	}
	
	/*I AM REVERSING ONE STRING AND CHECKING WETHER 
	 * WHETHER BOTH ARE SAME OR NOT*/
	public boolean checking(String name1,String name2)
	{		
		StringBuffer fname = new StringBuffer(name1);
		StringBuffer sname = new StringBuffer(name2);
		boolean check = new StringBuffer(fname).reverse().toString().equalsIgnoreCase(new StringBuffer(sname).toString());
		if(check)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*THIS IS MAIN METHOD BCZ ALL PROCESS WE GOING TO HAPPEN IN THIS METHOD ONLY.*/
	public void process(String name1,String name2)
	{
		/*HERE I TAKE STRINGBUFFER BCZ WE CAN DELETE THE CHAR WITHOUT OTHER OBJECT CREATING 
		 * BCZ STRINGBUFFER ARE MUTUABLE. BUT IF WE CONSIDER STRING EVERY TIME A NEW OBJECT WILL BE CREATED
		 * WELL WE STRINGS ARE IMMUTUABLE */
		StringBuffer sb1 = new StringBuffer(name1);
		StringBuffer sb2 = new StringBuffer(name2);
		
		/*THIS IF BLOCK IS FOR SOMETIMES BOTH WILL BE SAME WHEN WE REVERSE THE WORD EX:-"amar", "rama"
		 * HERE BOTH ARE SOME, NO NEED TO PROCESS
		 * DIRECTLY WE CAN SAY IT WILL BE ZERO*/
		if(!checking(name1, name2) && !(fname.contains(sname)))
		{
			/*THIS LOOP IS TO CHECK FOR TWO TIMES, BCZ SOMETIMES WE DON'T GET EXACT OUPUT, AGAIN I AM CHECKING*/
			for(int loop = 1 ;loop<=2 ; loop++) 
			{
				/*FOR NORMAL CANCELATION OF THE ALPHABETS*/
				for(int i=0;i<sb1.length();i++) 
				{
					Character ch = sb1.charAt(i);
					if(sb2.indexOf(ch.toString()) != -1)
					{
						int index = sb1.indexOf(ch+"");
						int index2 = sb2.indexOf(ch+"");
						sb1.deleteCharAt(index);
						sb2.deleteCharAt(index2);
					}
				}
			}	
			FinallResult.remaningCharacters = sb1.length()+sb2.length();
			FinallResult.fname = this.fname;
			FinallResult.sname = this.sname;	
		}					
	}
	
	/*I CONSIDER TWO METHODS TO TAKE THE INPUT i.e.. FIRST AND SECOND NAMES
	 * WELL WE CAN INSTED OF TWO METHODS WE CAN CONSIDER ONE METHOD ALSO.*/
	public void first_Name()
	{
		do
		{
			System.out.println("enter your name :");
			returnName = sc.nextLine();
			checking = validateNames(returnName);
		}while(!checking);
		this.fname = returnName.trim().toLowerCase();
	}
	
	public void second_Name()
	{
		do
		{
			System.out.println("\nenter your GF/BF name :");
			returnName = sc.nextLine();
			checking = validateNames(returnName);
		}while(!checking);
		this.sname = returnName.trim().toLowerCase();
	}
	
	/*IN THIS METHOD I AM CHECKING THE INPUT STRING
	 * WETHER IT CONTAINS ALPHATES OR NOT
	 * IF NOT IT SHOW ERROR*/
	public boolean validateNames(String name) 
	{
		boolean first_Name_Validation = Pattern.matches("[a-zA-Z]+", name);

		if(first_Name_Validation)
		{
			return true;
		}
		else
		{
			System.out.println("\n error [enter only alphabets (nospaces, cammas , etc..)]");
			return false;
		}
	}
	
	public static void waitingtime(int seconds)
	{
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {}
		
	}
}
