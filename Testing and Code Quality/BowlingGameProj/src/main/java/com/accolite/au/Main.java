package com.accolite.au;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import com.accolite.au.BowlingGame.BowlingGame;

public class Main {
	
	  static Logger log = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Enter the bowler name:");
    	String bowlerName=scan.next();
    	String rolls[]=new String[21];
    	System.out.println("Enter the no of pins fell for each frame");
    	for(int i=1;i<21;i++) {
    		rolls[i]=scan.next();
    	}
    	rolls[0]=bowlerName;
        BowlingGame game = new BowlingGame(rolls);
        System.out.println(game);
        log.info(game);
        log.debug(game);
    }
    
}
