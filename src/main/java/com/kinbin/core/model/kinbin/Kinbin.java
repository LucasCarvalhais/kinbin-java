package com.kinbin.core.model.kinbin;

public interface Kinbin {

    String getName();
    double getAge();
    Mood getMood();
    double getEnergy();
    double getWeight();
    double getFortune();
    boolean isAlive();
    void increasePercentWeight(double percent);
    void decreasePercentWeight(double percent);
    void increasePercentEnergy(double percent);
    void decreasePercentEnergy(double percent);
    void addFortune(double value);
    void removeFortune(double value);

}