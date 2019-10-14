package com.kinbin.kinbin.core.model;

public class KinbinStatus {
    private final Kinbin kinbin;
    private FortuneStatus fortuneStatus;
    private EnergyStatus energyStatus;

    public KinbinStatus(Kinbin kinbin) {
        this.kinbin = kinbin;
    }

    public void updateStatus() {
        updateFortuneStatus();
        updateEnergyStatus();
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
        if (kinbin.getEnergy() > 80 && kinbin.getEnergy() < 100) {
            energyStatus = EnergyStatus.TOO_HIGH;
        }
        if (kinbin.getEnergy() >= 100) {
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
}
