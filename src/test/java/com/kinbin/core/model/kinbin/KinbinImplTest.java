package com.kinbin.core.model.kinbin;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class KinbinImplTest {

    private static final String NAME_KINBIN = "Taichi Ohno";
    KinbinImpl kinbin;

    @Before
    public void setUp() {
        kinbin = new KinbinImpl();
    }

    @Test
    public void shouldGetKinbinsName() {
        kinbin.setName(NAME_KINBIN);
        assertThat(kinbin.getName(), is(NAME_KINBIN));
    }

    @Test
    public void kinbinShouldBeAlive() {
        assertTrue(kinbin.isAlive());
    }

    @Test
    public void checkDefaultValues() {
        assertThat(kinbin.getAge(), is(0.0));
        assertThat(kinbin.getEnergy(), is(50.0));
        assertThat(kinbin.getWeight(), is(50.0));
        assertThat(kinbin.getFortune(), is(250.0));
    }

    @Test
    public void shouldIncrease100GramsTpWeight() {
        double expectedWeight = 50.1;

        kinbin.increaseWeight(0.1);
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
