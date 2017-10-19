package com.company.Monster;

import com.company.Monster.Carnivore.Houndour;
import com.company.Monster.Herbivore.Caterpie;
import com.company.Places.Place;

/**
 * Created by Kyle on 7/21/2017.
 */
public class MobFactory {

    //because we always need to place the mob in it's home's list
    //classRollers
    /*public static Mob newMob(int foodConsumption, String aName, Place aHome) {
        Mob mob = new Mob(foodConsumption, aName, aHome);
        aHome.addMob(mob);
        return mob;
    }*/

    /*public static Herbivore newHerbivore(int foodConsumption, String aName, Place aHome) {
        Herbivore herbivore = new Herbivore(foodConsumption, aName, aHome);
        aHome.addMob(herbivore);
        return herbivore;
    }*/


    //IndividualRollers
    public static Caterpie newCaterpie(Place aHome) {
        Caterpie caterpie = new Caterpie(aHome);
        aHome.addMob(caterpie);
        return caterpie;
    }

    public static Houndour newHoundour(Place aHome) {
        Houndour houndour = new Houndour(aHome);
        aHome.addMob(houndour);
        return houndour;
    }

}
