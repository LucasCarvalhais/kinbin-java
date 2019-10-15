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
        kinbinStatus.updateStatus();

        if (isKinbinDesesperate()) {
            mood = Mood.DESESPERATE;
        } else if (isKinbinWorried()) {
            mood = Mood.WORRIED;
        } else if (isKinbinSad()) {
            mood = Mood.SAD;
        } else if (isKinbinAngry()) {
            mood = Mood.ANGRY;
        } else if (isKinbinNeutral()) {
            mood = Mood.NEUTRAL;
        } else if (isKinbinOptimism()) {
            mood = Mood.OPTIMISM;
        } else if (isKinbinHappy()) {
            mood = Mood.HAPPY;
        } else {
            // Error!
        }
    }

    private boolean isKinbinHappy() {
        return (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT);
    }

    private boolean isKinbinOptimism() {
        return (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT);
    }

    private boolean isKinbinNeutral() {
        return (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT);
    }

    private boolean isKinbinAngry() {
        return (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT);
    }

    private boolean isKinbinSad() {
        return (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE);
    }

    private boolean isKinbinWorried() {
        return (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE);
    }

    private boolean isKinbinDesesperate() {
        return (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.STARVING)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.SLIM)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.NORMAL)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OVERWEIGHT)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.RICH
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MILLIONAIRE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MEDIUM
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.LOW
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.MEDIUM
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.MISERABLE
                    && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                    && kinbinStatus.getWeightStatus() == WeightStatus.OBESE)

                || (kinbinStatus.getFortuneStatus() == FortuneStatus.POOR
                && kinbinStatus.getEnergyStatus() == EnergyStatus.TOO_HIGH
                && kinbinStatus.getWeightStatus() == WeightStatus.OBESE);
    }

}