package com.accolite.au.Bowler;

import java.util.List;
import com.accolite.au.ScoreCard.ScoreCard;

/**
 * Represents a bowler of a bowling game.
 */
public class Bowler {

	private String name;
	private ScoreCard scoreCard;
	
	
	public Bowler(String name) {
		this.setName(name);
		this.setScoreCard(scoreCard);
	}

	
	public Bowler(String name, List<String> rolls) {
		this.setName(name);
		this.setScoreCard(new ScoreCard(rolls));
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public ScoreCard getScoreCard() {
		return this.scoreCard;
	}

	
	public void setScoreCard(ScoreCard scoreCard) {
		this.scoreCard = scoreCard;
	}

	
	public String toString() {
		String output = "";
		output += " Final score: " + this.getScoreCard().getFinalScore();
		return output;
	}

}
