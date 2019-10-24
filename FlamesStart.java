package FlamesGame;

public class FlamesStart 
{
	public static void main(String[] args) 
	{
		ProcessData p =new ProcessData();
		FinallResult f = new FinallResult();
		Thread t = new Thread(f);
		p.start();
		t.start();
	}
}
