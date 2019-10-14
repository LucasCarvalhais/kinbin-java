package com.kinbin.kinbin.core.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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

        assertThat(kinbinStatus.getFortuneStatus(), is(FortuneStatus.MISERABLE));
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
        kinbin.decreaseEnergy(100);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.TOO_LOW));
    }

    @Test
    public void kinbinSHouldHaveEnergyStatusAsTooLowIfItIsEquals20() {
        kinbin.decreaseEnergy(60);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.TOO_LOW));
    }

    @Test
    public void kinbinSHouldHaveEnergyStatusAsLowIfItIsBetween20And40() {
        kinbin.decreaseEnergy(40);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.LOW));
    }

    @Test
    public void kinbinSHouldHaveEnergyStatusAsLowIfItIsEquals40() {
        kinbin.decreaseEnergy(20);
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
        kinbin.increaseEnergy(20);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.MEDIUM));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsHighIfItIsBetween60And80() {
        kinbin.increaseEnergy(40);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.HIGH));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsHighIfItiSEquals80() {
        kinbin.increaseEnergy(60);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.HIGH));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAdTooHighIfItIsBetween80And100() {
        kinbin.increaseEnergy(80);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.TOO_HIGH));
    }

    @Test
    public void kinbinShouldHaveEnergyStatusAsDangerZoneIfItIsGreaterThan100() {
        kinbin.increaseEnergy(100);
        initializeKinbinStatus();

        kinbinStatus.updateStatus();
        assertThat(kinbinStatus.getEnergyStatus(), is(EnergyStatus.DANGER_ZONE));
    }

}
