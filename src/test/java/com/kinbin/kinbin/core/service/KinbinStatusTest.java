package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.model.EnergyStatus;
import com.kinbin.kinbin.core.model.FortuneStatus;
import com.kinbin.kinbin.core.model.Kinbin;
import com.kinbin.kinbin.core.model.WeightStatus;
import com.kinbin.kinbin.core.service.KinbinStatus;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class KinbinStatusTest {

    private Kinbin kinbin = new Kinbin();
    private KinbinStatus kinbinStatus;

    private void initializeKinbinStatus() {
        kinbinStatus = new KinbinStatus(kinbin);
    }

    @Test
    public void kinbinShouldBeMiserableIfFortuneIsLessThan0() {
        kinbin.removeFortune(300);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), CoreMatchers.is(FortuneStatus.MISERABLE));
    }

    @Test
    public void kinbinShouldBeMiserableIfFortuneIsEquals0() {
        kinbin.removeFortune(250);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.MISERABLE));
    }

    @Test
    public void kinbinShouldBePoorIfFortuneIsBetween0And100() {
        kinbin.removeFortune(200);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.POOR));
    }

    @Test
    public void kinbinShouldBePoorIfFortuneIsEquals100() {
        kinbin.removeFortune(150);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.POOR));
    }

    @Test
    public void kinbinShouldBeMediumIfFortuneIsBetween100And500() {
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.MEDIUM));
    }

    @Test
    public void kinbinShouldBeMediumIfFortuneIsEquals500() {
        kinbin.addFortune(250);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.MEDIUM));
    }

    @Test
    public void kinbinShouldBeRichIfFortuneIsBetween500And1000() {
        kinbin.addFortune(500);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.RICH));
    }

    @Test
    public void kinbinShouldBeRichIfFortuneIsEquals1000() {
        kinbin.addFortune(750);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.RICH));
    }

    @Test
    public void kinbinShouldBeMillionaireIfFortuneIsGreaterThan1000() {
        kinbin.addFortune(1000);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.MILLIONAIRE));
    }

    @Test
    public void kinbinSHouldHaveEnergyStatusAsTooLowIfItIsLessThan20() {
        kinbin.decreasePercentEnergy(100);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), CoreMatchers.is(EnergyStatus.TOO_LOW));
    }

    @Test
    public void kinbinSHouldHaveEnergyStatusAsTooLowIfItIsEquals20() {
        kinbin.decreasePercentEnergy(60);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.TOO_LOW));
    }

    @Test
    public void kinbinSHouldHaveEnergyStatusAsLowIfItIsBetween20And40() {
        kinbin.decreasePercentEnergy(40);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.LOW));
    }

    @Test
    public void kinbinSHouldHaveEnergyStatusAsLowIfItIsEquals40() {
        kinbin.decreasePercentEnergy(20);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.LOW));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsMediumIfItIsBetween40And60() {
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.MEDIUM));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsMediumIfItIsEquals60() {
        kinbin.increasePercentEnergy(20);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.MEDIUM));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsHighIfItIsBetween60And80() {
        kinbin.increasePercentEnergy(40);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.HIGH));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsHighIfItiSEquals80() {
        kinbin.increasePercentEnergy(60);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.HIGH));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAdTooHighIfItIsBetween80And100() {
        kinbin.increasePercentEnergy(80);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.TOO_HIGH));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsTooHighIfItIsEquals100() {
        kinbin.increasePercentEnergy(100);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.TOO_HIGH));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsDangerZoneIfItIsGreaterThan100() {
        kinbin.increasePercentEnergy(120);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.DANGER_ZONE));
    }

    @Test
    public void kinbinShouldBeDeadIfWeightIsEquals0() {
        kinbin.decreasePercentWeight(100);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), CoreMatchers.is(WeightStatus.DEAD));
    }

    @Test
    public void kinbinShouldBeStarvingIfWeightIsBetween0And30() {
        kinbin.decreasePercentWeight(80);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.STARVING));
    }

    @Test
    public void kinbinShouldBeSlimIfWeightIsEquals30() {
        kinbin.decreasePercentWeight(40);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.SLIM));
    }

    @Test
    public void kinbinShouldBeSlimIfWeightIsBetween30And40() {
        kinbin.decreasePercentWeight(30);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.SLIM));
    }

    @Test
    public void kinbinShouldBeNormalIfWeightIsEquals40() {
        kinbin.decreasePercentWeight(20);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.NORMAL));
    }

    @Test
    public void kinbinShouldBeNormalIfWeightIsBetween40And60() {
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.NORMAL));
    }

    @Test
    public void kinbinShouldBeOverweightIfWeightIsEquals60() {
        kinbin.increasePercentWeight(20);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.OVERWEIGHT));
    }

    @Test
    public void kinbinShouldBeOverweightIfWeightIsBetween60And70() {
        kinbin.increasePercentWeight(30);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.OVERWEIGHT));
    }

    @Test
    public void kinbinShouldBeObeseIfWeightIsEquals70() {
        kinbin.increasePercentWeight(40);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.OBESE));
    }

    @Test
    public void kinbinShouldBeObeseIfWeightIsBetween70And100() {
        kinbin.increasePercentWeight(70);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.OBESE));
    }

    @Test
    public void kinbinShouldBeInDangerZoneIfWeightIsEquals100() {
        kinbin.increasePercentWeight(100);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.DANGER_ZONE));
    }

    @Test
    public void KinbinShouldBeInDangerZoneIfWeightIsGreaterThan100() {
        kinbin.increasePercentWeight(120);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();

        assertThat(kinbinStatus.getWeightStatus(), is(WeightStatus.DANGER_ZONE));
    }

}
