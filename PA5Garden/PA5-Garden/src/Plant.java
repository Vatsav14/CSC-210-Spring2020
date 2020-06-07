/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Plant.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Plant object. Each Plant object primarily consists
 * of a name and a type (namely a vegetable, tree or flower). It contains information to initialize 
 * a Plant object and specific methods that are to be processed on a Plot object.
 * 
 * 
 * EXAMPLE CALL TO THE PLOT CONSTRUCTOR:
 * Plot newPlot = new Plot();
 * 
 * This creates a new plant containing 5 rows and 5 columns of objects which are initially null, but
 * later initialized with plant objects as required
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Plant {

    private String type;
    private String name;

    /**
     * Constructor for plants
     * 
     * @param plant
     */
    public Plant(String plant) {
        name = plant.toLowerCase();
        if (checkIfVegetable(plant)) {
            type = "vegetable";
        } else if (checkIfFlower(plant)) {
            type = "flower";
        } else {
            type = "tree";
        }
    }

    /**
     * Checks if its a vegetable
     * 
     * @param plantName
     * @return
     */
    public static boolean checkIfVegetable(String plantName) {
        Set<String> veggies = new HashSet<String>();
        veggies.add("garlic");
        veggies.add("zucchini");
        veggies.add("tomato");
        veggies.add("yam");
        veggies.add("lettuce");
        return veggies.contains(plantName);
    }

    /**
     * Checks if its a flower
     * 
     * @param plantName
     * @return
     */
    public static boolean checkIfFlower(String plantName) {
        Set<String> flowers = new HashSet<String>();
        flowers.add("iris");
        flowers.add("lily");
        flowers.add("rose");
        flowers.add("daisy");
        flowers.add("tulip");
        flowers.add("sunflower");
        return flowers.contains(plantName);
    }

    /**
     * Checks if its a tree
     * 
     * @param plantName
     * @return
     */
    public static boolean checkIfTree(String plantName) {
        Set<String> trees = new HashSet<String>();
        trees.add("oak");
        trees.add("willow");
        trees.add("banana");
        trees.add("coconut");
        trees.add("pine");
        return trees.contains(plantName);
    }

    /**
     * 
     * @return
     */
    public String getPlantName() {
        return name;
    }

    /**
     * 
     */
    public String toString() {
        return name.substring(0, 1);
    }

    /**
     * 
     * @param current
     * @return
     */
    public List<Coordinates> grow(Coordinates current) {
        return new ArrayList();
    }

}