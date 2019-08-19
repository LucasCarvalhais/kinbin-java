package com.kinbin.kinbin.core.model;

public class Kinbin {
    public static final double DEFAULT_WEIGHT = 100;
    public static final double DEFAULT_ENERGY = 50;
    public static final double DEFAYLT_FORTUNE = 100;

    private double weight;
    private double energy;
    private double fortune;
    private Mood mood;

    public Kinbin() {
        this.weight = DEFAULT_WEIGHT;
        this.energy = DEFAULT_ENERGY;
        this.fortune = DEFAYLT_FORTUNE;
        this.mood = Mood.NEUTRAL;
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

    public void addFortune(int value) {
        fortune += value;
    }

    public void removeFortune(int value) {
        fortune -= value;
    }

    public Mood getMood() {
        return mood;
    }

    public void updateMood() {
        if (fortune < 0) {
            mood = Mood.DESESPERATE;
        }
        if (fortune >= 0 && fortune <= 100) {
            mood = Mood.WORRIED;
        }
        if (fortune > 100 && fortune <= 500) {
            mood = Mood.OPTIMISTIC;
        }
        if (fortune > 500 && fortune <= 1500) {
            mood = Mood.NEUTRAL;
        }
        if (fortune > 1500) {
            mood = Mood.HAPPY;
        }
    }
}
