package com.company.Monster;

import com.company.Places.Place;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by Kyle on 6/26/2017.
 */
public abstract class Mob {

    Random ran = new Random();

    //variables
    protected int foodConsumption;
    protected int Id = ran.nextInt(5);
    //TODO: change ID to be dependent on inheritor name?
    protected String Name;
    //TODO: change Name to be a species name
    protected Place home;
    protected Map<String, Integer> statMap = new HashMap<String, Integer>() {{
        put("Health", 0);
        put("Mana", 0);
    }};
    protected int reproductionNum = 2;
    protected int foodWorth;



    //constructor
    public Mob () {}

    //Mobs should only be made with a MobFactory - this
    // will keep them in their home place's residentMobs arrayList
    public Mob(int foodConsumption, String aName, Place ahome) {
        this.foodConsumption = foodConsumption;
        Name = aName;
        home = ahome;
    }

    //getters and setters
    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getFoodConsumption() {
        return foodConsumption;
    }

    public void setFoodConsumption(int foodConsumption) {
        this.foodConsumption = foodConsumption;
    }

    public Place getHome() {return home;}

    public void setHome(Place aPlace) {this.home = aPlace;}

    public int getReproductionNum() {return this.reproductionNum;}

    public void setReproductionNum(int lovelyparents) {this.reproductionNum = lovelyparents;}

    public int getFoodWorth() {return this.foodWorth;}

    public void setFoodWorth(int foodWorth) {this.foodWorth = foodWorth;}

    //methods
    public String die() {
        //this is creating an error, will be removed when databases are implemented
        home.getResidentMobs().remove(this);
        return this.Name + " died and dropped nothing";
    }

    public abstract void reproduce();

    public void migrate() {}

    //methods

}
