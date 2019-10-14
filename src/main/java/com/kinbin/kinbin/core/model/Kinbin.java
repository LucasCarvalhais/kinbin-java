package com.kinbin.kinbin.core.model;

public class Kinbin {
    private static final double DEFAULT_WEIGHT = 50;
    private static final double DEFAULT_ENERGY = 50;
    private static final double DEFAULT_FORTUNE = 250;

    private KinbinStatus kinbinStatus;
    private double weight;
    private double energy;
    private double fortune;
    private Mood mood;

    public Kinbin() {
        this.weight = DEFAULT_WEIGHT;
        this.energy = DEFAULT_ENERGY;
        this.fortune = DEFAULT_FORTUNE;

        kinbinStatus = new KinbinStatus(this);
        kinbinStatus.updateStatus();
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
        kinbinStatus.updateStatus();
    }

    public void decreaseWeight(double percent) {
        weight -= weight * (percent/100);
        kinbinStatus.updateStatus();
    }

    public void increaseEnergy(double percent) {
        energy += energy * (percent/100);
        kinbinStatus.updateStatus();
    }

    public void decreaseEnergy(double percent) {
        energy -= energy * (percent/100);
        kinbinStatus.updateStatus();
    }

    public void addFortune(double value) {
        fortune += value;
        kinbinStatus.updateStatus();
    }

    public void removeFortune(double value) {
        fortune -= value;
        kinbinStatus.updateStatus();
    }

    public void updateMood() {

    }

}