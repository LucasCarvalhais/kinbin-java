package com.kinbin.kinbin.core.model;

import com.kinbin.kinbin.core.service.KinbinMood;
import com.kinbin.kinbin.core.service.KinbinStatus;

import java.rmi.UnexpectedException;

public class Kinbin {
    private static final double DEFAULT_WEIGHT = 50;
    private static final double DEFAULT_ENERGY = 50;
    private static final double DEFAULT_FORTUNE = 250;

    private final KinbinMood kinbinMood;
    private double weight;
    private double energy;
    private double fortune;
    private Mood mood;

    public Kinbin() {
        this.weight = DEFAULT_WEIGHT;
        this.energy = DEFAULT_ENERGY;
        this.fortune = DEFAULT_FORTUNE;
        kinbinMood = new KinbinMood(new KinbinStatus(this));
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

    public void addFortune(double fortune) {
        this.fortune += fortune;
    }

    public void removeFortune(double fortune) {
        this.fortune -= fortune;
    }

    public void increasePercentWeight(double percent) {
        double weight_percent = weight * (percent/100);
        weight += weight_percent;
    }

    public void decreasePercentWeight(double percent) {
        double weight_percent = weight * (percent/100);
        weight -= weight_percent;
    }

    public void increasePercentEnergy(double percent) {
        double energy_percent = energy * (percent/100);
        energy += energy_percent;
    }

    public void decreasePercentEnergy(double percent) {
        double energy_percent = energy * (percent/100);
        energy -= energy_percent;
    }

    public void updateMood() {
        try {
            mood = kinbinMood.determineMood();
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }

}