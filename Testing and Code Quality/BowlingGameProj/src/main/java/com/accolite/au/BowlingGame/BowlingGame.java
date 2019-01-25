package com.accolite.au.BowlingGame;

import com.accolite.au.Bowler.Bowler;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bowling game.
 */
public class BowlingGame {

	public Bowler bowler;

	
	public BowlingGame(String[] args) {
		String name = args[0];
		List<String> rolls = new ArrayList<String>();

		for (int i = 1; i < args.length; i++) {
			rolls.add(args[i]);
		}

		bowler = new Bowler(name, rolls);
	}

	public String toString() {
		String output = "";

		if (bowler != null) {
			output = bowler.toString();
		}

		return output;
	}
}
