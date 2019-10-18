package com.kinbin.core.model.kinbin;

public class KinbinStatus {
    private final KinbinImpl kinbin;
    private FortuneStatus fortuneStatus;
    private EnergyStatus energyStatus;
    private WeightStatus weightStatus;

    public KinbinStatus(KinbinImpl kinbin) {
        this.kinbin = kinbin;
    }

    public void updateStatus() {
        updateFortuneStatus();
        updateEnergyStatus();
        updateWeightStatus();
    }

    private void updateWeightStatus() {
        if (kinbin.getWeight() <= 0) {
            weightStatus = WeightStatus.DEAD;
        }
        if (kinbin.getWeight() > 0 && kinbin.getWeight() < 30) {
            weightStatus = WeightStatus.STARVING;
        }
        if (kinbin.getWeight() >= 30 && kinbin.getWeight() < 40) {
            weightStatus = WeightStatus.SLIM;
        }
        if (kinbin.getWeight() >= 40 && kinbin.getWeight() < 60) {
            weightStatus = WeightStatus.NORMAL;
        }
        if (kinbin.getWeight() >= 60 && kinbin.getWeight() < 70) {
            weightStatus = WeightStatus.OVERWEIGHT;
        }
        if (kinbin.getWeight() >= 70 && kinbin.getWeight() < 100) {
            weightStatus = WeightStatus.OBESE;
        }
        if (kinbin.getWeight() >= 100) {
            weightStatus = WeightStatus.DANGER_ZONE;
        }
    }

    private void updateEnergyStatus() {
        if (kinbin.getEnergy() <= 20) {
            energyStatus = EnergyStatus.TOO_LOW;
        }
        if (kinbin.getEnergy() > 20 && kinbin.getEnergy() <= 40) {
            energyStatus = EnergyStatus.LOW;
        }
        if (kinbin.getEnergy() > 40 && kinbin.getEnergy() <= 60) {
            energyStatus = EnergyStatus.MEDIUM;
        }
        if (kinbin.getEnergy() > 60 && kinbin.getEnergy() <= 80) {
            energyStatus = EnergyStatus.HIGH;
        }
        if (kinbin.getEnergy() > 80 && kinbin.getEnergy() <= 100) {
            energyStatus = EnergyStatus.TOO_HIGH;
        }
        if (kinbin.getEnergy() > 100) {
            energyStatus = EnergyStatus.DANGER_ZONE;
        }
    }

    private void updateFortuneStatus() {
        if (kinbin.getFortune() <= 0) {
            fortuneStatus = FortuneStatus.MISERABLE;
        }
        if (kinbin.getFortune() > 0 && kinbin.getFortune() <= 100) {
            fortuneStatus = FortuneStatus.POOR;
        }
        if (kinbin.getFortune() > 100 && kinbin.getFortune() <= 500) {
            fortuneStatus = FortuneStatus.MEDIUM;
        }
        if (kinbin.getFortune() > 500 && kinbin.getFortune() <= 1000) {
            fortuneStatus = FortuneStatus.RICH;
        }
        if (kinbin.getFortune() > 1000) {
            fortuneStatus = FortuneStatus.MILLIONAIRE;
        }
    }

    public FortuneStatus getFortuneStatus() {
        return fortuneStatus;
    }

    public EnergyStatus getEnergyStatus() {
        return energyStatus;
    }

    public WeightStatus getWeightStatus() {
        return weightStatus;
    }
}
