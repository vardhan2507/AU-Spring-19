package com.accolite.au.ScoreCard;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Represents a score card for a given game and bowler.
 */
public class ScoreCard {

	private List<Integer> rolls;
	private List<Frame> frames;

	public ScoreCard() {
	}

	public ScoreCard(List<String> rolls) {
		this.generateIntegerRolls(rolls);
		this.generateFrames();
	}

	public int getFinalScore() {
		List<Frame> frames = this.getFrames();
		int i = frames != null ? frames.size() - 1 : -1;
		int score = 0;

		if (i >= 0) {
			Frame lastFrame = frames.get(i);

			while (lastFrame.isBonus() && i > 1) {
				lastFrame = frames.get(--i);
			}

			score = lastFrame.getScore();
		}

		return score;
	}

	private List<Integer> getRolls() {
		return this.rolls;
	}

	private void setRolls(List<Integer> rolls) {
		this.rolls = rolls;
	}

	private List<Frame> getFrames() {
		return this.frames;
	}

	private void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	private void generateIntegerRolls(List<String> stringRolls) {
		List<Integer> rolls = new ArrayList<Integer>();
		int i;

		for (i = 0; i < stringRolls.size(); i++) {
			String roll = stringRolls.get(i);
			int rollValue;
			rollValue = Integer.parseInt(roll);
			rolls.add(rollValue);
		}
		this.setRolls(rolls);
	}

	/**
	 * This creates the frames for the score card and bowling game, built upon the
	 * rolls for the bowler.
	 */
	private void generateFrames() {
		List<Integer> rolls = this.getRolls();
		List<Frame> frames = new ArrayList<Frame>();
		int i;
		int currentScore = 0;

		if (rolls != null) {
			for (i = 0; i < rolls.size(); i++) {
				int firstRoll = rolls.get(i);
				int secondRoll;
				int frameScore = currentScore + firstRoll;

				Frame frame = new Frame(frames.size() + 1, firstRoll);

				if (firstRoll != 10 && ++i < rolls.size()) {
					secondRoll = rolls.get(i);
					frameScore += secondRoll;
					frame.setSecondRoll(secondRoll);
				}

				if ((frame.isSpare() || frame.isStrike()) && (i + 1 < rolls.size())) {
					frameScore += rolls.get(i + 1);

					if (frame.isStrike() && (i + 2 < rolls.size())) {
						frameScore += rolls.get(i + 2);
					}
				}

				frame.setScore(frameScore);
				currentScore = frameScore;

				frames.add(frame);
			}
		}

		this.setFrames(frames);
	}

}
