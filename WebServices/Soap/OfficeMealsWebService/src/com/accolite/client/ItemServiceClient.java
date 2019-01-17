package com.accolite.client;

import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.accolite.beans.Item;
import com.accolite.service.*;

public class ItemServiceClient {

	public static void main(String[] args) throws Exception {
		   
		URL url = new URL("http://localhost:9999/service/item?wsdl");
		
	        
	        QName qname = new QName("http://service.accolite.com/", "ItemServiceImplService");

	        Service service = Service.create(url, qname);

	        ItemService itemService = service.getPort(ItemService.class);
	        Scanner scan=new Scanner(System.in);

	       while(true) {
	    	   System.out.println("\n1.Add Item\n2.Delete Item\n3.Get Item\n4.Get all Items\n5.Exit");
	    	   int choice=scan.nextInt();
	    	   
	    	   switch(choice)
	    	   {
	    	   
	    	   case 1:
	    		   System.out.println("\nEnter the id, name, price of the item\n");
	    		   int tempID=scan.nextInt();
	    		   String tempName=scan.next();
	    		   int tempPrice=scan.nextInt();
	    		   Item i=new Item(tempID, tempName, tempPrice);
	    		   itemService.addItem(i);
	    		   break;
	    		   
	    	   case 2:
	    		   System.out.println("\nEnter the id of the item\n");
	    		   int tempID1=scan.nextInt();
	    		   itemService.deleteItem(tempID1);
	    		   break;
	    		   
	    	   case 3:
	    		   System.out.println("\nEnter the id of the item\n");
	    		   int tempID2=scan.nextInt();
	    		   Item j=itemService.getItem(tempID2);
	    		   System.out.println("\n"+j.getId()+"\n"+j.getName()+"\n"+j.getPrice()+"\n");
	    		   break;
	    		   
	    	   case 4:
	    		   Item k[]=itemService.getAllItems();
	    		   for(Item r:k) {
	    			   System.out.println("\n"+r.getId()+"\n"+r.getName()+"\n"+r.getPrice()+"\n");
	    		   }
	    		   break;
	    		   
	    	   case 5:
	    		   return;
	    		   
	    		   default:
	    			   System.out.println("\nPlease check your input!!!\n");
	    	   }
	    	   
	       }
	    }
}
