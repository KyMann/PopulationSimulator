package com.company.Monster.Carnivore;

import com.company.Places.Place;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kyle on 7/21/2017.
 */
public class Houndour extends Carnivore{

    //fields
    protected Map<String, Integer> statMap = new HashMap<String, Integer>() {{
        put("Health", 15);
        put("Mana", 10);
    }};

    //constructor
    public Houndour(Place aHome) {
        foodConsumption = 10;
        Name = "Houndour";
        home = aHome;
        foodWorth = 6;
    }


    @Override
    public void reproduce() {

    }
}
