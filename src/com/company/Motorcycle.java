package com.company;


import java.util.Random;

class Motorcycle extends Competitor {
    private static int instances = 0;
    private int speed;

    Motorcycle() {
        instances++;
        this.name = "Motorcycle " + instances;
        this.type = "Motorcycle";
        this.distanceTraveled = 0;
        this.speed = 100;
    }

    void moveForAnHour() {
        distanceTraveled += speed;
    }

    void limitSpeed() {
        Random r = new Random();
        speed -= r.nextInt(46) + 5;
    }

    void setNormalSpeed() {
        speed = 100;
    }
}