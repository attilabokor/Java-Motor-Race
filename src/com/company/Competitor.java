package com.company;

abstract class Competitor {
    String name, type;
    int distanceTraveled;

    abstract void moveForAnHour();
    abstract void limitSpeed();
    abstract void setNormalSpeed();
}
