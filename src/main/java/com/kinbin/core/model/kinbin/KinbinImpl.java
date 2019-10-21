package com.kinbin.core.model.kinbin;

import org.springframework.stereotype.Component;

import java.rmi.UnexpectedException;

@Component
public class KinbinImpl implements Kinbin {
    private static final double DEFAULT_WEIGHT = 50;
    private static final double DEFAULT_ENERGY = 50;
    private static final double DEFAULT_FORTUNE = 250;

    private final KinbinMood kinbinMood;
    private String name;
    private double weight;
    private double energy;
    private double fortune;
    private Mood mood;
    private boolean isAlive;

    public KinbinImpl() {
        this.name = "Kinbin Default";
        this.isAlive = true;
        this.weight = DEFAULT_WEIGHT;
        this.energy = DEFAULT_ENERGY;
        this.fortune = DEFAULT_FORTUNE;
        kinbinMood = new KinbinMood(new KinbinStatus(this));
        updateMood();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public double getFortune() {
        return fortune;
    }

    public Mood getMood() {
        return mood;
    }

    @Override
    public void addFortune(double fortune) {
        this.fortune += fortune;
    }

    @Override
    public void removeFortune(double fortune) {
        this.fortune -= fortune;
    }

    @Override
    public void increasePercentWeight(double percent) {
        double weight_percent = weight * (percent/100);
        weight += weight_percent;
    }

    @Override
    public void decreasePercentWeight(double percent) {
        double weight_percent = weight * (percent/100);
        weight -= weight_percent;
    }

    @Override
    public void increasePercentEnergy(double percent) {
        double energy_percent = energy * (percent/100);
        energy += energy_percent;
    }

    @Override
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