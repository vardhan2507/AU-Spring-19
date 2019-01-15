
public class EvenOddTest
{
	public static int number = 0;
	public static void main(String[] args)
	{
		EvenOddTest evenodd = new EvenOddTest();
		new Thread(() -> {
			for(int i=0;i<10;i++)
			evenodd.printEvenNos();
		}).start();
		
		new Thread(() -> {
			for(int i=0;i<10;i++)
			evenodd.printOddNos();
		}).start();
	}
	
	public  synchronized void printEvenNos() {
		for(int i = 0; i < 100; i++)
		{
		while(number % 2 == 1)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{

			}
		}
		}

		System.out.println("Even: " + number++);
		notify();
		
	}
	public synchronized void printOddNos() {
		for(int i = 0; i < 100; i++)
		{
			
		while(number % 2 == 0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{

			}
		}

		System.out.println("Odd: " + number++);
		notify();
		}
	}
	
}


