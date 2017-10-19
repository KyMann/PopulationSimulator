package com.company.Monster.Herbivore;

import com.company.Monster.MobFactory;
import com.company.Places.Place;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kyle on 7/21/2017.
 */
public class Caterpie extends Herbivore {


    //fields
    protected Map<String, Integer> statMap = new HashMap<String, Integer>() {{
        put("Health", 10);
        put("Mana", 1);
    }};

    //constructor
    public Caterpie(Place aHome) {
        foodConsumption = 5;
        Name = "Caterpie";
        home = aHome;
        foodWorth = 4;
    }

    //methods
    @Override
    public void reproduce() {
        MobFactory.newCaterpie(this.getHome());
    }
}
