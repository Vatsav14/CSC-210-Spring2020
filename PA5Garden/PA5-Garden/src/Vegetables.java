/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Trees.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Vegetables object. Each Vegetables object primarily consists
 * of a name . It contains information to initialize 
 * a Vegetables object and specific methods that are to be processed on a Vegetables object.
 * 
 * 
 * EXAMPLE CALL TO THE TREE CONSTRUCTOR:
 * Plant newTree = new Vegetables("yam");
 * 
 * This creates a new vegetable
 */

import java.util.ArrayList;
import java.util.List;

public class Vegetables extends Plant {

    /**
     * COnstructor for vegetables
     * 
     * @param name
     */
    public Vegetables(String name) {
        super(name);
    }

    /**
     * Purpose: The grow function for vegetables
     */
    public List<Coordinates> grow(Coordinates current) {
        List<Coordinates> spotsToAdd = new ArrayList<Coordinates>();
        spotsToAdd.add(new Coordinates(current.getR() + 1, current.getC()));
        return spotsToAdd;
    }
}