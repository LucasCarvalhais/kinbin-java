package com.kinbin.core.model.kinbin;

import com.kinbin.core.exception.UndefiniedMoodException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class KinbinImpl implements Kinbin {
    private static final BigDecimal DEFAULT_AGE = BigDecimal.valueOf(0);
    private static final BigDecimal DEFAULT_WEIGHT = BigDecimal.valueOf(50);
    private static final BigDecimal DEFAULT_ENERGY = BigDecimal.valueOf(50);
    private static final BigDecimal DEFAULT_FORTUNE = BigDecimal.valueOf(250);

    private final KinbinMood kinbinMood;

    private String name;
    private boolean isAlive;
    private BigDecimal age;
    private BigDecimal weight;
    private BigDecimal energy;
    private BigDecimal fortune;
    private Mood mood;

    public KinbinImpl() {
        this.name = "Kinbin Default";
        this.isAlive = true;
        this.age = DEFAULT_AGE;
        this.weight = DEFAULT_WEIGHT;
        this.energy = DEFAULT_ENERGY;
        this.fortune = DEFAULT_FORTUNE;
        kinbinMood = new KinbinMood(new KinbinStatus(this));
        updateMood();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getAge() {
        return age.doubleValue();
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public double getWeight() {
        return weight.doubleValue();
    }

    @Override
    public double getEnergy() {
        return energy.doubleValue();
    }

    @Override
    public double getFortune() {
        return fortune.doubleValue();
    }

    public Mood getMood() {
        return mood;
    }

    @Override
    public void addFortune(double fortune) {
        this.fortune = this.fortune.add(BigDecimal.valueOf(fortune));
    }

    @Override
    public void removeFortune(double fortune) {
        this.fortune = this.fortune.subtract(BigDecimal.valueOf(fortune));
    }

    @Override
    public void increasePercentWeight(double percent) {
        BigDecimal weight_percent = weight.multiply(BigDecimal.valueOf(percent/100));
        weight = weight.add(weight_percent);
    }

    @Override
    public void decreasePercentWeight(double percent) {
        BigDecimal weight_percent = weight.multiply(BigDecimal.valueOf(percent/100));
        weight = weight.subtract(weight_percent);
    }

    @Override
    public void increasePercentEnergy(double percent) {
        BigDecimal energy_percent = energy.multiply(BigDecimal.valueOf(percent/100));
        energy = energy.add(energy_percent);
    }

    @Override
    public void decreasePercentEnergy(double percent) {
        BigDecimal energy_percent = energy.multiply(BigDecimal.valueOf(percent/100));
        energy = energy.subtract(energy_percent);
    }

    public void updateMood() {
        try {
            mood = kinbinMood.determineMood();
        } catch (UndefiniedMoodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void increaseWeight(double weight) {
        this.weight = this.weight.add(BigDecimal.valueOf(weight));
    }
}