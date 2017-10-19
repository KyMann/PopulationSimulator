package com.company;

import com.company.Monster.Mob;
import com.company.Monster.MobFactory;
import com.company.Places.Place;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //landscape setup
        Place firstPlace =  new Place("FirstPlace", 10000);
        MobFactory.newCaterpie(firstPlace);
        MobFactory.newCaterpie(firstPlace);



        Random random = new Random();

        //running system
        System.out.println("sim starting");
        while (!firstPlace.getResidentMobs().isEmpty()) {
            System.out.println(firstPlace.getResidents());
            firstPlace.foodTick();
            //the reproduction code has to be able to reference individual mobs
            //thus the reproduction code has to act from the place's residentmobs - where we have mob by mob access
            HashMap<String, Integer> residentSpeciesCounts = firstPlace.makeResidentSpeciesCount();
            ArrayList<Mob> pregnantList = new ArrayList<Mob>();
            for (Mob mob: firstPlace.getResidentMobs()) {
                //random gives a 50% chance of pregnancy -
                //this represents the gender ratio, and the ability to not get pregnant
                if (residentSpeciesCounts.get(mob.getClass().getSimpleName()) >= mob.getReproductionNum() && random.nextBoolean()) {
                    pregnantList.add(mob);
                }
            }
            //concurrent modification is a fatal error - we would be impregnating babies as they are born
            for (Mob mob: pregnantList) {
                mob.reproduce();
            }
            /*if (residentSpeciesCount.isEmpty()) {
                System.out.println("no mobs found!");
            }*/

        }


    }
}
