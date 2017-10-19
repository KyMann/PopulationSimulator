package com.company.Places;

import com.company.Monster.Carnivore.Carnivore;
import com.company.Monster.Herbivore.Herbivore;
import com.company.Monster.Mob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Kyle on 6/26/2017.
 */
public class Place {
    //variables
    private int plantFood;
    private ArrayList<Mob> residentMobs = new ArrayList<Mob>();
    private String Name;

    //constructor

    public Place(String aName, int afood) {
        Name = aName;
        plantFood = afood;
    }

    //getters and setters
    public int getPlantFood() {
        return plantFood;
    }

    public void setPlantFood(int plantFood) {
        this.plantFood = plantFood;
    }

    public ArrayList<Mob> getResidentMobs() {
        return residentMobs;
    }

    public void addMob(Mob aMob) {
        residentMobs.add(aMob);
    }

    public String getName() {
        return Name;
    }

    public void setName(String aName) {
        Name = aName;
    }

    //methods
    public String getResidents() {
        //this produces a string containing the class name and amount of every mob in residentmobs arraylist
        String residentNameString = "";
        HashMap<String, Integer> residentSpeciesCount = makeResidentSpeciesCount();
        Iterator it = residentSpeciesCount.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry species = (Map.Entry)it.next();
            String newString = species.getKey() + " " + species.getValue();
            residentNameString += newString + " ";
            it.remove(); //remove avoids ConcurrentModivication Exceptions
        }
        return residentNameString;
    }

    public HashMap<String, Integer> makeResidentSpeciesCount() {

        HashMap<String, Integer> residentSpeciesCount = new HashMap<String, Integer>();
        for (Mob mob: residentMobs) {
            residentSpeciesCount.put(mob.getClass().getSimpleName(), residentSpeciesCount.getOrDefault(mob.getClass().getSimpleName(), 0) +1);
        }
        return residentSpeciesCount;
    }

    public void foodTick() {
        //this ticks the plantFood consumption
        //every tick the plantFood consumption starts at 0 - for now
        int foodConsumption = 0;
        int carnivoreFood = 0;
        String message;
        if (!residentMobs.isEmpty()) {
            //we need to figure out the food tied up in the mobs before they start eating and dying
            for (Mob mob : residentMobs) {
                //add up plantFood consumption for every mob
                if (mob instanceof Herbivore) {
                    carnivoreFood += mob.getFoodWorth();
                }
            }
            for (Mob mob : residentMobs) {
                foodConsumption += mob.getFoodConsumption();
                if (mob instanceof Herbivore) {
                    if (foodConsumption > plantFood) {
                        //if there is a plantFood deficit
                        // TODO: should a dying mob still eat some plantFood
                        // foodConsumption -= mob.getFoodConsumption();
                        //remove the dying mob
                        // TODO: make the mob die a method so that mobs can die differently
                        message = mob.die();
                    }
                }
                if (mob instanceof Carnivore) {
                    if (mob.getFoodConsumption() > carnivoreFood) {
                        mob.die();
                    } else {
                        return;
                    }
                }
            }

            //we need to increment down plantFood consumption, otherwise plantFood is forever the same
            //TODO: why don't we decremnt plantFood in the Herbivore if statement?
            plantFood -= foodConsumption;
        }
    }
}
