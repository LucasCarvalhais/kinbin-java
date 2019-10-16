package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.model.EnergyStatus;
import com.kinbin.kinbin.core.model.FortuneStatus;
import com.kinbin.kinbin.core.model.Mood;
import com.kinbin.kinbin.core.model.WeightStatus;

import java.rmi.UnexpectedException;

public class KinbinMood {

    private final KinbinStatus kinbinStatus;

    public KinbinMood(KinbinStatus kinbinStatus) {
        this.kinbinStatus = kinbinStatus;
    }

    public Mood determineMood() throws UnexpectedException {
        kinbinStatus.updateStatus();

        if (isKinbinDesesperate()) return Mood.DESESPERATE;
        if (isKinbinWorried()) return Mood.WORRIED;
        if (isKinbinSad()) return Mood.SAD;
        if (isKinbinAngry()) return Mood.ANGRY;
        if (isKinbinNeutral()) return Mood.NEUTRAL;
        if (isKinbinOptimism()) return Mood.OPTIMISM;
        if (isKinbinHappy()) return Mood.HAPPY;

        throw new UnexpectedException("Something went wrong while updating Kinbin's mood");
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

    boolean isKinbinOptimism() {
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

    boolean isKinbinNeutral() {
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

    boolean isKinbinAngry() {
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

    boolean isKinbinSad() {
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

    boolean isKinbinWorried() {
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

    boolean isKinbinDesesperate() {
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