/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Coordinates.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Coordinate object. Each Coordinate object primarily consists
 * of an x and y coordinate. It contains information to initialize 
 * a coordinate object and specific methods that are to be processed on a Plot object.
 * 
 * 
 * EXAMPLE CALL TO THE COORDINATE CONSTRUCTOR:
 * Coordinates c = new Coordinates(5,6);
 * 
 * This creates a new coordinate (5, 6)
 */

public class Coordinates {

    private int row;
    private int col;

    /**
     * Constructor for Coordinates
     * 
     * @param row
     * @param col
     */
    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Getter method
     * 
     * @return
     */
    public int getR() {
        return row;
    }

    /**
     * Getter method
     * 
     * @return
     */
    public int getC() {
        return col;
    }
}