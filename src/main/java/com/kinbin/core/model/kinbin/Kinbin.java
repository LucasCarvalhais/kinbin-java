package com.kinbin.core.model.kinbin;

public interface Kinbin {

    String getName();
    double getAge();
    Mood getMood();
    double getEnergy();
    double getWeight();
    double getFortune();

    boolean isAlive();

    void addWeight(double weight);
}