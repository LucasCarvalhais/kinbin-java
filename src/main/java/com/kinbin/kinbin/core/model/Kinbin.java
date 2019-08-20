package com.kinbin.kinbin.core.model;

public class Kinbin {
    public static final double DEFAULT_WEIGHT = 50;
    public static final double DEFAULT_ENERGY = 50;
    public static final double DEFAULT_FORTUNE = 1000;
    public static final Mood DEFAULT_MOOD = Mood.NEUTRAL;

    public static final double MIN_FORTUNE = 0;
    public static final double MIN_MED_FORTUNE = 100;
    public static final double MAX_MED_FORTUNE = 500;
    public static final double MAX_FORTUNE = 1500;

    public static final double MIN_ENERGY = 15;
    public static final double MED_ENERGY = 30;
    public static final double MAX_ENERGY = 60;

    public static final double OVERWEIGHT = 80;
    public static final double UNDERWEIGHT = 20;

    private double weight;
    private double energy;
    private double fortune;
    private Mood mood;

    public Kinbin() {
        this.weight = DEFAULT_WEIGHT;
        this.energy = DEFAULT_ENERGY;
        this.fortune = DEFAULT_FORTUNE;
        this.mood = DEFAULT_MOOD;
    }

    public double getWeight() {
        return weight;
    }

    public double getEnergy() {
        return energy;
    }

    public double getFortune() {
        return fortune;
    }

    public Mood getMood() {
        return mood;
    }

    public void increaseWeight(double percent) {
        weight += weight * (percent/100);
    }

    public void decreaseWeight(double percent) {
        weight -= weight * (percent/100);
    }

    public void increaseEnergy(double percent) {
        energy += energy * (percent/100);
    }

    public void decreaseEnergy(double percent) {
        energy -= energy * (percent/100);
    }

    public void addFortune(double value) {
        fortune += value;
    }

    public void removeFortune(double value) {
        fortune -= value;
    }

    public void updateMood() {
        if (isPoorOrExhaustedOrOverweightedOrUnderWeighted()) {
            mood = Mood.DESESPERATE;
        } else if (hasLittleMoneyOrIsTired()) {
            mood = Mood.WORRIED;
        } else if (hasReasonableMoney()) {
            mood = Mood.OPTIMISTIC;
        } else if (hasSufficientMoneyOrIsActive()) {
            mood = Mood.NEUTRAL;
        } else if (isRichOrEnergized()) {
            mood = Mood.HAPPY;
        }
    }

    private boolean isRichOrEnergized() {
        return (fortune > MAX_FORTUNE) || (energy >= MAX_ENERGY);
    }

    private boolean hasSufficientMoneyOrIsActive() {
        return (fortune > MAX_MED_FORTUNE && fortune <= MAX_FORTUNE)
                || (energy >= MED_ENERGY && energy < MAX_ENERGY);
    }

    private boolean hasReasonableMoney() {
        return fortune > MIN_MED_FORTUNE && fortune <= MAX_MED_FORTUNE;
    }

    private boolean hasLittleMoneyOrIsTired() {
        return (fortune >= MIN_FORTUNE && fortune <= MIN_MED_FORTUNE)
                || (energy >= MIN_ENERGY && energy < MED_ENERGY);
    }

    private boolean isPoorOrExhaustedOrOverweightedOrUnderWeighted() {
        return fortune < MIN_FORTUNE
                || energy < MIN_ENERGY
                || weight > OVERWEIGHT
                || weight < UNDERWEIGHT;
    }
}
