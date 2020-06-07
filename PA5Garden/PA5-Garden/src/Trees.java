/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Trees.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Tree object. Each Plant object primarily consists
 * of a name . It contains information to initialize 
 * a Tree object and specific methods that are to be processed on a Plot object.
 * 
 * 
 * EXAMPLE CALL TO THE TREE CONSTRUCTOR:
 * Plant newTree = new Trees("oak");
 * 
 * This creates a new tree
 */

import java.util.ArrayList;
import java.util.List;

public class Trees extends Plant {

    /**
     * Constructor for trees
     * 
     * @param name
     */
    public Trees(String name) {
        super(name);
    }

    /**
     * Purpose: The grow function for Trees
     */
    public List<Coordinates> grow(Coordinates current) {
        List<Coordinates> spotsToAdd = new ArrayList<Coordinates>();
        spotsToAdd.add(new Coordinates(current.getR() - 1, current.getC()));
        return spotsToAdd;
    }
}