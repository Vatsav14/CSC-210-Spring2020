/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Trees.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Tree object. Each Flower object primarily consists
 * of a name . It contains information to initialize 
 * a Flower object and specific methods that are to be processed on a Flower object.
 * 
 * 
 * EXAMPLE CALL TO THE FLOWER CONSTRUCTOR:
 * Plant newTree = new Flowers("lily");
 * 
 * This creates a new flower
 */

import java.util.ArrayList;
import java.util.List;

public class Flowers extends Plant {

    /**
     * Constructor for plants
     * 
     * @param name
     */
    public Flowers(String name) {
        super(name);
    }

    /**
     * Purpose: The grow function for flowers
     */
    public List<Coordinates> grow(Coordinates current) {
        List<Coordinates> spotsToAdd = new ArrayList<Coordinates>();
        if (current.getR() - 1 >= 0) {
            spotsToAdd.add(new Coordinates(current.getR() - 1, current.getC()));
        }
        if (current.getR() + 1 < 5) {
            spotsToAdd.add(new Coordinates(current.getR() + 1, current.getC()));
        }
        if (current.getC() - 1 >= 0) {
            spotsToAdd.add(new Coordinates(current.getR(), current.getC() - 1));
        }
        if (current.getC() + 1 < 5) {
            spotsToAdd.add(new Coordinates(current.getR(), current.getC() + 1));
        }
        return spotsToAdd;
    }
}