package com.company.Monster.Herbivore;

import com.company.Monster.Mob;
import com.company.Places.Place;

/**
 * Created by Kyle on 7/21/2017.
 */
public abstract class Herbivore extends Mob {

    public Herbivore() {}

    public Herbivore(int foodConsumption, String aName, Place ahome) {
        foodConsumption = foodConsumption;
        Name = aName;
        home = ahome;
    }


}
