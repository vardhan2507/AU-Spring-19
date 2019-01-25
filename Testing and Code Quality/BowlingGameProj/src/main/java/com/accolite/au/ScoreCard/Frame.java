package com.accolite.au.ScoreCard;

/**
 * Represents an entire bowling frame in a score card.
 */
public class Frame {

    private String frameNumber;
    private int firstRoll;
    private int secondRoll;
    private int score;
    private boolean isBonus;
    private boolean isStrike;
    private boolean isSpare;

   
    public Frame() {
        this.setFrameNumber("");
    }

   
    public Frame(int frameNumber) {
        this.setFrameNumber(this.calculateFrameNumber(frameNumber));
    }

  
    public Frame(int frameNumber, int firstRoll) {
        this(frameNumber);
        this.setFirstRoll(firstRoll);
        this.setSecondRoll(-1);
    }

    
    public Frame(int frameNumber, int firstRoll, int secondRoll) {
        this(frameNumber, firstRoll);
        this.setSecondRoll(secondRoll);
    }

   
    private String calculateFrameNumber(int frameNumber) {
        String frameNumberOutput = Integer.toString(frameNumber);

        if(frameNumber > 10) {
            frameNumberOutput = "*";
            this.setIsBonus(true);
        }

        return frameNumberOutput;
    }

   
    public String getFrameNumber() {
        return this.frameNumber;
    }

   
    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    
    public int getFirstRoll() {
        return this.firstRoll;
    }

    
    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
        this.calculateFrameType();
    }

    
    public int getSecondRoll() {
        return this.secondRoll;
    }

    
    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
        this.calculateFrameType();
    }

    
    public int getScore() {
        return this.score;
    }

    
    public void setScore(int score) {
        this.score = score;
    }

  
    public boolean isStrike() {
        return this.isStrike;
    }

    
    private void setIsStrike(boolean isStrike) {
        this.isStrike = isStrike;
    }

   
    public boolean isSpare() {
        return this.isSpare;
    }

    
    private void setIsSpare(boolean isSpare) {
        this.isSpare = isSpare;
    }

    
    public boolean isBonus() {
        return this.isBonus;
    }

   
    private void setIsBonus(boolean isBonus) {
        this.isBonus = isBonus;
    }

    /**
   * Checks and sets if the rolls for the frame have a strike or spare.
     */
    private void calculateFrameType() {
        if(this.getFirstRoll() == 10) {
            this.setIsStrike(true);
        } else if(this.getFirstRoll() + this.getSecondRoll() == 10) {
            this.setIsSpare(true);
        } else {
            this.setIsStrike(false);
            this.setIsSpare(false);
        }
    }
}
