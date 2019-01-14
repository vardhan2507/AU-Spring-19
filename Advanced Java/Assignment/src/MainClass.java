import java.util.*;

public class MainClass {
	
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("1.Export Employee XML info to Databse\n2.Import Department data into XML file\n");
		int choice=scan.nextInt();
		if(choice==1)
		{
			XMLParser parser=new XMLParser();
			parser.parse();
		}
		else if(choice==2)
		{
			ExtractIntoXML extractor=new ExtractIntoXML();
			extractor.extract();
		}
		else
		{
			System.out.println("Check your input. Please enter either 1 or 2");
		}
	}

}
