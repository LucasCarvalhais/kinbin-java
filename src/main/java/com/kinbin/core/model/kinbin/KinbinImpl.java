package com.kinbin.core.model.kinbin;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class KinbinImpl implements Kinbin {
    private static final BigDecimal DEFAULT_AGE = BigDecimal.valueOf(0);
    private static final BigDecimal DEFAULT_WEIGHT = BigDecimal.valueOf(50);
    private static final BigDecimal DEFAULT_ENERGY = BigDecimal.valueOf(50);
    private static final BigDecimal DEFAULT_FORTUNE = BigDecimal.valueOf(250);

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
        this.mood = Mood.NEUTRAL;
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

    @Override
    public Mood getMood() {
        return mood;
    }

    @Override
    public void addWeight(double weight) {
        this.weight = this.weight.add(BigDecimal.valueOf(weight));
        if (this.weight.doubleValue() <= 0) {
            isAlive = false;
            this.weight = BigDecimal.valueOf(0);
        }
    }
}