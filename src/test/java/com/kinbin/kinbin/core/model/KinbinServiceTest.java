package com.kinbin.kinbin.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KinbinServiceTest {

    Kinbin kinbin;

    @Before
    public void setUp() {
        kinbin = new Kinbin();
    }

    @Test
    public void checkInitialValues() {
        assertThat(kinbin.getEnergy(), is(50.0));
        assertThat(kinbin.getWeight(), is(50.0));
        assertThat(kinbin.getFortune(), is(1000.0));
        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void shouldIncrease5HundredthPercentOfWeight() {
        double expectedWeight = 50.025;

        kinbin.increaseWeight(0.05);
        double finalWeight = kinbin.getWeight();

        assertThat(finalWeight, is(expectedWeight));
    }

    @Test
    public void shouldDecrease5HundredthPercentOfWeight() {
        double expectedWeight = 49.975;

        kinbin.decreaseWeight(0.05);
        double finalWeight = kinbin.getWeight();

        assertThat(finalWeight, is(expectedWeight));
    }

    @Test
    public void shouldIncrease5TenthPercentOfEnergy() {
        double expectedEnergy = 50.25;

        kinbin.increaseEnergy(0.5);
        double finalEnergy = kinbin.getEnergy();

        assertThat(finalEnergy, is(expectedEnergy));
    }

    @Test
    public void shouldDecrease5TenthPercentOfEnergy() {
        double expectedEnergy = 49.75;

        kinbin.decreaseEnergy(0.5);
        double finalEnergy = kinbin.getEnergy();

        assertThat(finalEnergy, is(expectedEnergy));
    }

    @Test
    public void shouldAdd1K$ToFortune() {
        double expectedFortune = 1001;

        kinbin.addFortune(1);
        double finalFortune = kinbin.getFortune();

        assertThat(finalFortune, is(expectedFortune));
    }

    @Test
    public void shouldRemove2FromFortune() {
        double expectedFortune = 998;

        kinbin.removeFortune(2);
        double finalFortune = kinbin.getFortune();

        assertThat(finalFortune, is(expectedFortune));
    }

    @Test
    public void kinbinShouldBeDesesperateWhenFortuleIsLessThan0() {
        kinbin.increaseEnergy(100);
        kinbin.removeFortune(1100);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfFortuneIsEqualTo0() {
        kinbin.increaseEnergy(100);
        kinbin.removeFortune(1000);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfFortuneIsBetween0And100() {
        kinbin.increaseEnergy(100);
        kinbin.removeFortune(950);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfFortuneIsEqualsTo100() {
        kinbin.increaseEnergy(100);
        kinbin.removeFortune(900);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeOptisticIfFortuneIsBetween100And500() {
        kinbin.increaseEnergy(100);
        kinbin.removeFortune(750);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISTIC));
    }

    @Test
    public void kinbinShouldBeOptimisticIfFortuneIsEqualsTo500() {
        kinbin.increaseEnergy(100);
        kinbin.removeFortune(500);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISTIC));
    }

    @Test
    public void kinbinShouldBeNeutralIfFortuneIsBetween500And1500() {
        kinbin.increaseEnergy(100);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeNeutralIfFortuneIsEqualTo1500() {
        kinbin.increaseEnergy(100);
        kinbin.addFortune(500);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeHappyIfFortuneIsGreaterThan1500() {
        kinbin.increaseEnergy(100);
        kinbin.addFortune(1000);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    @Test
    public void kinbinShouldBeDesesperateIfEnergyIsLessThan15() {
        kinbin.addFortune(2000);
        kinbin.decreaseEnergy(90);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfEnergyIs15() {
        kinbin.addFortune(2000);
        kinbin.decreaseEnergy(70);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfEnergyIsBetween15And30() {
        kinbin.addFortune(2000);
        kinbin.decreaseEnergy(50);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeNeutralIfEnergyIs30() {
        kinbin.addFortune(2000);
        kinbin.decreaseEnergy(40);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeNeutralIfEnergyIsBetween30And60() {
        kinbin.addFortune(2000);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeHappyIfEnergyIsEqualTo60() {
        kinbin.addFortune(2000);
        kinbin.increaseEnergy(20);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    @Test
    public void kinbinShouldBeDesesperateIfIsOverweighted() {
        kinbin.increaseWeight(100);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfIsUnderWeight() {
        kinbin.decreaseWeight(80);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }
}
