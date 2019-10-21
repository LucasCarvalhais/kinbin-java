package com.kinbin.core.model.kinbin;

import com.kinbin.core.model.kinbin.KinbinImpl;
import com.kinbin.core.model.kinbin.Mood;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KinbinMoodTest {

    KinbinImpl kinbin;

    @Before
    public void setUp() {
        kinbin = new KinbinImpl();
    }

    private void makeMiserable() {
        kinbin.removeFortune(300);
    }

    private void makePoor() {
        kinbin.removeFortune(200);
    }

    private void makeRich() {
        kinbin.addFortune(500);
    }

    private void makeMillionaire() {
        kinbin.addFortune(1000);
    }

    private void makeEnergyTooLow() {
        kinbin.decreasePercentEnergy(80);
    }

    private void makeEnergyLow() {
        kinbin.decreasePercentEnergy(40);
    }

    private void makeEnergyHigh() {
        kinbin.increasePercentEnergy(40);
    }

    private void makeEnergyTooHigh() {
        kinbin.increasePercentEnergy(80);
    }

    private void makeStarving() {
        kinbin.decreasePercentWeight(80);
    }

    private void makeSlim() {
        kinbin.decreasePercentWeight(30);
    }

    private void makeOverweight() {
        kinbin.increasePercentWeight(30);
    }

    private void makeObese() {
        kinbin.increasePercentWeight(70);
    }

    // Starving && Too Low //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDTooLowANDStarving() {
        makeMiserable();
        makeEnergyTooLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), CoreMatchers.is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDTooLowANDStarving() {
        makePoor();
        makeEnergyTooLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsMediumANDTooLowANDStarving() {
        makeEnergyTooLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsRichANDTooLowANDStarving() {
        makeRich();
        makeEnergyTooLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsMillionaireANDTooLowANDStarving() {
        makeMillionaire();
        makeEnergyTooLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    // Starving && Low //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDLowANDStarving() {
        makeMiserable();
        makeEnergyLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDLowANDStarving() {
        makePoor();
        makeEnergyLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsMediumANDLowANDStarving() {
        makeEnergyLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsRichANDLowANDStarving() {
        makeRich();
        makeEnergyLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMillionaireANDLowANDStarving() {
        makeMillionaire();
        makeEnergyLow();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    // Starving && Medium //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDMediumANDStarving() {
        makeMiserable();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDMediumANDStarving() {
        makePoor();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMediumANDMediumANDStarving() {
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsRichANDMediumANDStarving() {
        makeRich();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMillionaireANDMediumANDStarving() {
        makeMillionaire();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    // Starving && High //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDHighANDStarving() {
        makeMiserable();
        makeEnergyHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDHighANDStarving() {
        makePoor();
        makeEnergyHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMediumANDHighANDStarving() {
        makeEnergyHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsRichANDHighANDStarving() {
        makeRich();
        makeEnergyHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMillionaireANDHighANDStarving() {
        makeMillionaire();
        makeEnergyHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    // Starving && Too High //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDTooHighANDStarving() {
        makeMiserable();
        makeEnergyTooHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDTooHighANDStarving() {
        makePoor();
        makeEnergyTooHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMediumANDTooHighANDStarving() {
        makeEnergyTooHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsRichANDTooHighANDStarving() {
        makeRich();
        makeEnergyTooHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMillionaireANDTooHighANDStarving() {
        makeMillionaire();
        makeEnergyTooHigh();
        makeStarving();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    // Slim && Too Low
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDTooLowANDSlim() {
        makeMiserable();
        makeEnergyTooLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDTooLowANDSlim() {
        makePoor();
        makeEnergyTooLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMediumANDTooLowANDSlim() {
        makeEnergyTooLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsRichANDTooLowANDSlim() {
        makeRich();
        makeEnergyTooLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMillionaireANDTooLowANDSlim() {
        makeMillionaire();
        makeEnergyTooLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    // Slim && Low
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDLowANDSlim() {
        makeMiserable();
        makeEnergyLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsPoorANDLowANDSlim() {
        makePoor();
        makeEnergyLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMediumANDLowANDSlim() {
        makeEnergyLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsRichANDLowANDSlim() {
        makeRich();
        makeEnergyLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptmismIfItIsMillionaireANDLowANDSlim() {
        makeMillionaire();
        makeEnergyLow();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    // Slim && Medium
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDMediumANDSlim() {
        makeMiserable();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsPoorANDMediumANDSlim() {
        makePoor();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDMediumANDSlim() {
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDMediumANDSlim() {
        makeRich();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDMediumANDSlim() {
        makeMillionaire();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Slim && High
    @Test
    public void kinbinShouldBeAngryIfItIsMiserableANDHighANDSlim() {
        makeMiserable();
        makeEnergyHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.ANGRY));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDHighANDSlim() {
        makePoor();
        makeEnergyHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDHighANDSlim() {
        makeEnergyHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDHighANDSlim() {
        makeRich();
        makeEnergyHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDHighANDSlim() {
        makeMillionaire();
        makeEnergyHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Slim && TooHigh
    @Test
    public void kinbinShouldBeAngryIfItIsMiserableANDTooHighANDSlim() {
        makeMiserable();
        makeEnergyTooHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.ANGRY));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDTooHighANDSlim() {
        makePoor();
        makeEnergyTooHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDTooHighANDSlim() {
        makeEnergyTooHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDTooHighANDSlim() {
        makeRich();
        makeEnergyTooHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDTooHighANDSlim() {
        makeMillionaire();
        makeEnergyTooHigh();
        makeSlim();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Normal && Too Low
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDTooLowANDNormal() {
        makeMiserable();
        makeEnergyTooLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsPoorANDTooLowANDNormal() {
        makePoor();
        makeEnergyTooLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMediumANDTooLowANDNormal() {
        makeEnergyTooLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsRichANDTooLowANDNormal() {
        makeRich();
        makeEnergyTooLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsMillionaireANDTooLowANDNormal() {
        makeMillionaire();
        makeEnergyTooLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    // Normal && Low
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDLowANDNormal() {
        makeMiserable();
        makeEnergyLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDLowANDNormal() {
        makePoor();
        makeEnergyLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDLowANDNormal() {
        makeEnergyLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDLowANDNormal() {
        makeRich();
        makeEnergyLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDLowANDNormal() {
        makeMillionaire();
        makeEnergyLow();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Normal && Medium
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDMediumANDNormal() {
        makeMiserable();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsPoorANDMediumANDNormal() {
        makePoor();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDMediumANDNormal() {
        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDMediumANDNormal() {
        makeRich();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDMediumANDNormal() {
        makeMillionaire();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Normal && High
    @Test
    public void kinbinShouldBeAngryIfItIsMiserableANDHighANDNormal() {
        makeMiserable();
        makeEnergyHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.ANGRY));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDHighANDNormal() {
        makePoor();
        makeEnergyHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDHighANDNormal() {
        makeEnergyHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDHighANDNormal() {
        makeRich();
        makeEnergyHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDHighANDNormal() {
        makeMillionaire();
        makeEnergyHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Normal && Too High
    @Test
    public void kinbinShouldBeAngryIfItIsMiserableANDTooHighANDNormal() {
        makeMiserable();
        makeEnergyTooHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.ANGRY));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDTooHighANDNormal() {
        makePoor();
        makeEnergyTooHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDTooHighANDNormal() {
        makeEnergyTooHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDTooHighANDNormal() {
        makeRich();
        makeEnergyTooHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDTooHighANDNormal() {
        makeMillionaire();
        makeEnergyTooHigh();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Overweight && Too Low
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDTooLowANDOverweight() {
        makeMiserable();
        makeEnergyTooLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDTooLowANDOverweight() {
        makePoor();
        makeEnergyTooLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMediumANDTooLowANDOverweight() {
        makeEnergyTooLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsRichANDTooLowANDOverweight() {
        makeRich();
        makeEnergyTooLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMillionaireANDTooLowANDOverweight() {
        makeMillionaire();
        makeEnergyTooLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    // Overweight && Low
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDLowANDOverweight() {
        makeMiserable();
        makeEnergyLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsPoorANDLowANDOverweight() {
        makePoor();
        makeEnergyLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMediumANDLowANDOverweight() {
        makeEnergyLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsRichANDLowANDOverweight() {
        makeRich();
        makeEnergyLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsMillionaireANDLowANDOverweight() {
        makeMillionaire();
        makeEnergyLow();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    // Overweight && Medium
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDMediumANDOverweight() {
        makeMiserable();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsPoorANDMediumANDOverweight() {
        makePoor();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDMediumANDOverweight() {
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDMediumANDOverweight() {
        makeRich();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDMediumANDOverweight() {
        makeMillionaire();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Overweight && High
    @Test
    public void kinbinShouldBeAngryIfItIsMiserableANDHighANDOverweight() {
        makeMiserable();
        makeEnergyHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.ANGRY));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDHighANDOverweight() {
        makePoor();
        makeEnergyHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDHighANDOverweight() {
        makeEnergyHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDHighANDOverweight() {
        makeRich();
        makeEnergyHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDHighANDOverweight() {
        makeMillionaire();
        makeEnergyHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Overweight && TooHigh
    @Test
    public void kinbinShouldBeAngryIfItIsMiserableANDTooHighANDOverweight() {
        makeMiserable();
        makeEnergyTooHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.ANGRY));
    }

    @Test
    public void kinbinShouldBeSadIfItIsPoorANDTooHighANDOverweight() {
        makePoor();
        makeEnergyTooHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeNeutralIfItIsMediumANDTooHighANDOverweight() {
        makeEnergyTooHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.NEUTRAL));
    }

    @Test
    public void kinbinShouldBeOptimismIfItIsRichANDTooHighANDOverweight() {
        makeRich();
        makeEnergyTooHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.OPTIMISM));
    }

    @Test
    public void kinbinShouldBeHappyIfItIsMillionaireANDTooHighANDOverweight() {
        makeMillionaire();
        makeEnergyTooHigh();
        makeOverweight();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.HAPPY));
    }

    // Obese && Too Low //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDTooLowANDObese() {
        makeMiserable();
        makeEnergyTooLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDTooLowANDObese() {
        makePoor();
        makeEnergyTooLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsMediumANDTooLowANDObese() {
        makeEnergyTooLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsRichANDTooLowANDObese() {
        makeRich();
        makeEnergyTooLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsMillionaireANDTooLowANDObese() {
        makeMillionaire();
        makeEnergyTooLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    // Obese && Low //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDLowANDObese() {
        makeMiserable();
        makeEnergyLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDLowANDObese() {
        makePoor();
        makeEnergyLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsMediumANDLowANDObese() {
        makeEnergyLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsRichANDLowANDObese() {
        makeRich();
        makeEnergyLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMillionaireANDLowANDObese() {
        makeMillionaire();
        makeEnergyLow();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    // Obese && Medium //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDMediumANDObese() {
        makeMiserable();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDMediumANDObese() {
        makePoor();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeWorriedIfItIsMediumANDMediumANDObese() {
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.WORRIED));
    }

    @Test
    public void kinbinShouldBeSadIfItIsRichANDMediumANDObese() {
        makeRich();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMillionaireANDMediumANDObese() {
        makeMillionaire();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    // Obese && High //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDHighANDObese() {
        makeMiserable();
        makeEnergyHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDHighANDObese() {
        makePoor();
        makeEnergyHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMediumANDHighANDObese() {
        makeEnergyHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeSadIfItIsRichANDHighANDObese() {
        makeRich();
        makeEnergyHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMillionaireANDHighANDObese() {
        makeMillionaire();
        makeEnergyHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    // Obese && Too High //
    @Test
    public void kinbinShouldBeDesesperateIfItIsMiserableANDTooHighANDObese() {
        makeMiserable();
        makeEnergyTooHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeDesesperateIfItIsPoorANDTooHighANDObese() {
        makePoor();
        makeEnergyTooHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.DESESPERATE));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMediumANDTooHighANDObese() {
        makeEnergyTooHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeSadIfItIsRichANDTooHighANDObese() {
        makeRich();
        makeEnergyTooHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

    @Test
    public void kinbinShouldBeSadIfItIsMillionaireANDTooHighANDObese() {
        makeMillionaire();
        makeEnergyTooHigh();
        makeObese();

        kinbin.updateMood();

        assertThat(kinbin.getMood(), is(Mood.SAD));
    }

}
