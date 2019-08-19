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
        assertThat(kinbin.getWeight(), is(100.0));
        assertThat(kinbin.getFortune(), is(100.0));
        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void shouldIncrease5HundredthPercentOfWeight() {
        double expectedWeight = 100.05;

        kinbin.increaseWeight(0.05);
        double finalWeight = kinbin.getWeight();

        assertThat(finalWeight, is(expectedWeight));
    }

    @Test
    public void shouldDecrease5HundredthPercentOfWeight() {
        double expectedWeight = 99.95;

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
        double expectedFortune = 101;

        kinbin.addFortune(1);
        double finalFortune = kinbin.getFortune();

        assertThat(finalFortune, is(expectedFortune));
    }

    @Test
    public void shouldRemove2FromFortune() {
        double expectedFortune = 98;

        kinbin.removeFortune(2);
        double finalFortune = kinbin.getFortune();

        assertThat(finalFortune, is(expectedFortune));
    }

    @Test
    public void kinbinShouldBeDesesperateWhenFortuleIsLessThan0() {
        kinbin.removeFortune(110);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfFortuneIsEqualTo0() {
        kinbin.removeFortune(100);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfFortuneIsBetween0And100() {
        kinbin.removeFortune(50);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfFortuneIsEqualsTo100() {
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeOptisticIfFortuneIsBetween100And500() {
        kinbin.addFortune(200);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISTIC));
    }

    @Test
    public void kinbinShouldBeOptimisticIfFortuneIsEqualsTo500() {
        kinbin.addFortune(400);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISTIC));
    }

    @Test
    public void kinbinShouldBeNeutralIfFortuneIsBetween500And1500() {
        kinbin.addFortune(900);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeNeutralIfFortuneIsEqualTo1500() {
        kinbin.addFortune(1400);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeHappyIfFortuneIsGreaterThan1500() {
        kinbin.addFortune(2000);
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

}
