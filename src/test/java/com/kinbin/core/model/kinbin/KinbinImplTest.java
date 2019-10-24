package com.kinbin.core.model.kinbin;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class KinbinImplTest {

    KinbinImpl kinbin;

    @Before
    public void setUp() {
        kinbin = new KinbinImpl();
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
    public void shouldIncrease0point1KgToWeight() {
        double expectedWeight = 50.1;

        kinbin.addWeight(0.1);
        double finalWeight = kinbin.getWeight();

        assertThat(finalWeight, is(expectedWeight));
    }

}
