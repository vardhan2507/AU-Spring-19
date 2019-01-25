import org.junit.*;

import com.accolite.au.Bowler.Bowler;
import com.accolite.au.BowlingGame.BowlingGame;
import com.accolite.au.ScoreCard.Frame;
import com.accolite.au.ScoreCard.ScoreCard;

import static org.junit.Assert.assertEquals;


import java.util.*;

public class AppTest {
	String[] rollsArray={ "6", "2", "7", "1", "10", "9", "0", "8", "2", "10", "10", "3", "5",
			"7", "2", "5", "5", "8" };
	List<String> rolls=null;
	int finalScore=0;
	
	@Before
	public void initialize() {
		
		rolls = new ArrayList<String>(Arrays.asList(rollsArray));
		finalScore=140;
		
	}
	
	@Test(timeout=1000)
    public void testScoreCard() {
        ScoreCard scoreCard = new ScoreCard(rolls);
        System.out.println(scoreCard.toString());
        Assert.assertEquals(finalScore, scoreCard.getFinalScore());
    }

	@Test
	public void testBowler() {
		
		Bowler bowler1=new Bowler("vardhan",rolls);
		Bowler bowler2=new Bowler("Kasturi");
		System.out.println(bowler1.toString());
		Assert.assertEquals("Kasturi",bowler2.getName());
		Assert.assertEquals(140,bowler1.getScoreCard().getFinalScore());
		
		
	}
	
	@Test
	public void testBowlingGame() {
		String [] args=new String[19];
		args[0]="vardhan";
		for(int i=1;i<19;i++) {
			args[i]=rollsArray[i-1];
		}
		BowlingGame bowlingGame=new BowlingGame(args);
		System.out.println(bowlingGame.toString());
		Assert.assertEquals("vardhan",bowlingGame.bowler.getName());
	}
	
	@Test
	public void testFrame() {
		Frame frame1 = new Frame(5, 3);
        Assert.assertEquals(3, frame1.getFirstRoll());
        
        Frame frame2 = new Frame(5, 3, 5);
        Assert.assertEquals(5, frame2.getSecondRoll());
	}
	
	@After
	public void destroyObjects() {
		
		System.gc();
	}
	
}