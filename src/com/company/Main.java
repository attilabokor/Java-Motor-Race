package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final static int RaceHours = 50;
    private static int rainyLaps = 0, limitedLaps = 0;


    public static void main(String[] args) {

        ArrayList<Competitor> racers = createAllCompetitors();
        simulateRace(racers);
        printRaceResults(racers);
        limitAndRainChanceCounter();

    }


    private static ArrayList createAllCompetitors() {

        ArrayList<Competitor> racingCompetitors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            racingCompetitors.add(new Motorcycle());
            racingCompetitors.add(new Truck());
            racingCompetitors.add(new Car());
        }
        return racingCompetitors;
    }

    private static void simulateRace(ArrayList<Competitor> racers) {
        boolean raining, limit;

        for (int hour = 0; hour < RaceHours; hour++) {
            raining = limitAndRainChanceCounter();
            limit = limitAndRainChanceCounter();
            if (raining) rainyLaps++;
            if (limit) limitedLaps++;
            for (Competitor racer : racers) {
                if (racer.type.equals("Motorcycle")) {
                    if (raining) {
                        racer.limitSpeed();
                    } else {
                        racer.setNormalSpeed();
                    }
                }
                if (racer.type.equals("Car")) {
                    if (limit) {
                        racer.limitSpeed();
                    } else {
                        racer.setNormalSpeed();
                    }
                }
                racer.moveForAnHour();
            }
        }
    }


    private static void printRaceResults(ArrayList<Competitor> racers) {
        System.out.println(String.format(ANSI_GREEN + "%-25s| %-40s|%18s", "Competitor", "Competitor Class", "Distance travelled" + ANSI_RESET));
        System.out.println(ANSI_BLUE + "########################################################################################" + ANSI_RESET);
        for (Competitor racer : racers) {
            System.out.println(String.format("%-25s| %-40s|%10d km", racer.name, racer.type, racer.distanceTraveled ));
        }
    }


    public static boolean limitAndRainChanceCounter() {
        int chanceOfRainig = 0;
        boolean stillRaining = false;

        Random r = new Random();
        chanceOfRainig = r.nextInt(10) + 1;

        if (chanceOfRainig <= 3) {
            stillRaining = true;
        } else {
            stillRaining = false;
        }

        return stillRaining;
    }

}





