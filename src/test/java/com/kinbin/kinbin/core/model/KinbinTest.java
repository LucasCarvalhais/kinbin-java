package com.kinbin.kinbin.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KinbinTest {

    Kinbin kinbin;

    @Before
    public void setUp() {
        kinbin = new Kinbin();
    }

    @Test
    public void checkDefaultValues() {
        assertThat(kinbin.getEnergy(), is(50.0));
        assertThat(kinbin.getWeight(), is(50.0));
        assertThat(kinbin.getFortune(), is(250.0));
    }

    @Test
    public void shouldIncrease5HundredthPercentOfWeight() {
        double expectedWeight = 50.025;

        kinbin.increasePercentWeight(0.05);
        double finalWeight = kinbin.getWeight();

        assertThat(finalWeight, is(expectedWeight));
    }

    @Test
    public void shouldDecrease5HundredthPercentOfWeight() {
        double expectedWeight = 49.975;

        kinbin.decreasePercentWeight(0.05);
        double finalWeight = kinbin.getWeight();

        assertThat(finalWeight, is(expectedWeight));
    }

    @Test
    public void shouldIncrease5TenthPercentOfEnergy() {
        double expectedEnergy = 50.25;

        kinbin.increasePercentEnergy(0.5);
        double finalEnergy = kinbin.getEnergy();

        assertThat(finalEnergy, is(expectedEnergy));
    }

    @Test
    public void shouldDecrease5TenthPercentOfEnergy() {
        double expectedEnergy = 49.75;

        kinbin.decreasePercentEnergy(0.5);
        double finalEnergy = kinbin.getEnergy();

        assertThat(finalEnergy, is(expectedEnergy));
    }

    @Test
    public void shouldAdd1$ToFortune() {
        double expectedFortune = 251;

        kinbin.addFortune(1);
        double finalFortune = kinbin.getFortune();

        assertThat(finalFortune, is(expectedFortune));
    }

    @Test
    public void shouldRemove2$FromFortune() {
        double expectedFortune = 248;

        kinbin.removeFortune(2);
        double finalFortune = kinbin.getFortune();

        assertThat(finalFortune, is(expectedFortune));
    }

}
