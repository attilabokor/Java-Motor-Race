package com.company;

import java.util.Random;

class Car extends Competitor {
    private int normalSpeed, actualSpeed;

    Car() {
        this.name = generateName() + " " + generateName();
        this.type = "Car";
        this.distanceTraveled = 0;
        this.normalSpeed = generateSpeed();
        this.actualSpeed = normalSpeed;
    }

    private int generateSpeed() {
        Random rnd = new Random();
        return rnd.nextInt(31) + 80;
    }

    private String generateName() {
        Random rnd = new Random();
        String[] carNames = {"Blast","Hollow","Wolf","Fang","Eagle","Blade","Adventure","Aeon","Alabaster","Albatross",
                "Apex","Astral","Augury","Aura","Aurora","Avalanche","Baron","Barrage","Basilisk",
                "Behemoth","Blaze","Blend","Bliss","Blitz","Blizzard","Bolt","Buffalo","Bullet","Capital",
                "Catalyst","Celestial","Centaur","Centurion","Charm","Chase","Climax","Cobra","Conqueror",
                "Corsair","Cosmos","Crest","Crown","Crusader","Crux","Curiosity","Dawn","Daydream",
                "Deputy","Desire","Dominion","Dragon","Dusk","Dynamics","Dynamo","Elysium","Eminence",
                "Empire","Empyrean","Encounter","Enigma","Eon","Eos","Epiphany","Epitome","Escape",
                "Essence","Eternity","Ethereal","Evolution","Excursion","Expedition","Falcon","Ferocity"
                };
        return carNames[rnd.nextInt(carNames.length)];
    }

    void moveForAnHour() {
        distanceTraveled += actualSpeed;
    }

    void limitSpeed() {
        actualSpeed = 70;
    }

    void setNormalSpeed() {
        actualSpeed = normalSpeed;
    }
}
