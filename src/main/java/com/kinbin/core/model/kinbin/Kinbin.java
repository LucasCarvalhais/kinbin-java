package com.kinbin.core.model.kinbin;

public interface Kinbin {

    void setName(String name);
    double getEnergy();
    String getName();
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
