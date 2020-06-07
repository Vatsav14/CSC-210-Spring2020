/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Plot.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Plot object. Each Plot object primarily consists
 * of a 2D array of Plant objects. It contains information to initialize a Plot object and specific 
 * methods that are to be processed on a Plot object.
 * 
 * 
 * EXAMPLE CALL TO THE PLOT CONSTRUCTOR:
 * Plot newPlot = new Plot();
 * 
 * This creates a new plot containing 5 rows and 5 columns of objects which are initially null, but
 * later initialized with plant objects as required
 */

import java.util.ArrayList;
import java.util.List;

public class Plot {

    private Plant[][] plot;
    private int rows = 5, cols = 5;
    private int growNumber;
    private String plant;

    /**
     * Purpose: This is the plant constructor creates a new plot containing 5
     * rows and 5 columns of objects which are initially null, but
     * later initialized with plant objects as required
     */
    public Plot() {
        plot = new Plant[5][5];
        for (Plant[] each : plot) {
            for (Plant eachPosition : each) {
                eachPosition = null;
            }
        }
        growNumber = 0;
    }

    /**
     * Purpose: This method checks if the plot being referenced currently has
     * any plants in it or not
     * 
     * @return: Whether the current plot has any plants or not
     */
    public boolean isEmpty() {
        if (growNumber == 0)
            return true;

        else
            return false;
    }

    /**
     * Purpose: This method checks whether the plot currently has a vegetable in
     * it
     * 
     * @return: A boolean that represents whether the plant is a vegetable or
     *          not
     */
    public boolean isVegetable() {
        return Plant.checkIfVegetable(plant);
    }

    /**
     * Purpose: This method checks whether the plot currently has a flower in
     * it
     * 
     * @return: A boolean that represents whether the plant is a flower or
     *          not
     */
    public boolean isFlower() {
        return Plant.checkIfFlower(plant);
    }

    /**
     * Purpose: This method checks whether the plot currently has a tree in
     * it
     * 
     * @return: A boolean that represents whether the plant is a tree or
     *          not
     */
    public boolean isTree() {
        return Plant.checkIfTree(plant);
    }

    /**
     * Purpose: This is a getter method to access the 2D array of plants that
     * represents the plot
     * 
     * @return: The 2D array representing the plot
     */
    public Plant[][] getPlot() {
        return plot;
    }

    /**
     * Purpose: This method handles the plant functionality of the plot
     * 
     * @param toPlant:
     *            The plant object that is to be planted in the plot
     */
    public void plant(Plant toPlant) {
        plant = toPlant.getPlantName();
        if (Plant.checkIfVegetable(plant)) {
            plot[0][2] = toPlant;
        } else if (Plant.checkIfTree(plant)) {
            plot[4][2] = toPlant;
        } else {
            plot[2][2] = toPlant;
        }
        growNumber = 1;
    }

    /**
     * Purpose: This method removes all of the plant objects in the class and
     * replaces them with null
     */
    public void removeAll() {
        for (int i = 0; i < plot.length; i++) {
            for (int j = 0; j < plot[i].length; j++) {
                plot[i][j] = null;
            }
        }
        growNumber = 0;
    }

    /**
     * Purpose: This method handles the harvest functionality of the plot
     */
    public void harvest() {
        assert isVegetable() == true;
        removeAll();
    }

    /**
     * Purpose: This method handles the pick functionality of the plot
     */
    public void pick() {
        assert isFlower() == true;
        removeAll();
    }

    /**
     * Purpose: This method handles the cut functionality of the plot
     */
    public void cut() {
        assert isTree() == true;
        removeAll();
    }

    /**
     * Purpose: This method handles the harvest functionality when a specific type is provided
     * @param type
     */
    public void harvestSpecificType(String type) {
        if (type.equalsIgnoreCase(plant)) {
            removeAll();
        }
    }

    /**
     * Purpose: This method handles the pick functionality when a specific type
     * is provided
     * 
     * @param type
     */
    public void pickSpecificType(String type) {
        if (type.equalsIgnoreCase(plant)) {
            removeAll();
        }
    }

    /**
     * Purpose: This method handles the cut functionality when a specific type
     * is provided
     * 
     * @param type
     */
    public void cutSpecificType(String type) {
        if (type.equalsIgnoreCase(plant)) {
            removeAll();
        }
    }

    /**
     * Purpose: This method returns a String representation of a specific row of
     * the plot
     * 
     * @param row:
     *            The row which is to be represented as a String
     * @return: The String which represents the specific row of the plot
     */
    public String getString(int row) {
        String retval = "";
        for (int j = 0; j < 5; j++) {
            if (plot[row][j] == null) {
                retval += ".";
            } else {
                retval += plot[row][j].toString();
            }
        }
        return retval;
    }

    /**
     * Purpose: This method creates a plant object based on the specific type of
     * plant provided
     * 
     * @param type:
     *            The String that represents the type of the plant to be created
     * @return: A plant object that was to be created
     */
    public static Plant createPlant(String type) {
        if (Plant.checkIfFlower(type))
            return new Flowers(type);
        else if (Plant.checkIfTree(type))
            return new Trees(type);
        else if (Plant.checkIfVegetable(type))
            return new Vegetables(type);
        return null;
    }

    /**
     * Purpose: This method gets all of the coordinates at which plants were
     * present in the plot
     * 
     * @return: A list of Coordinates where plants where present in the plot
     */
    public List<Coordinates> getPlantCoordinates() {
        List<Coordinates> plantsPresent = new ArrayList<Coordinates>();
        for (int i = 0; i < plot.length; i++) {
            for (int j = 0; j < plot[i].length; j++) {
                if (plot[i][j] != null) {
                    plantsPresent.add(new Coordinates(i, j));
                }
            }
        }
        return plantsPresent;
    }

    /**
     * Purpose: This method gets a list of coordinates containing the places at
     * which new plants have to be added
     * 
     * @param plantsPresent:
     *            A list of coordinates where plants are already present
     * @return: A list of coordinates where new plants have to be added
     */
    public List<Coordinates> getPlacesToAddNewPlants(
            List<Coordinates> plantsPresent) {
        List<Coordinates> addPlants = new ArrayList<Coordinates>();
        for (Coordinates each : plantsPresent) {
            addPlants.addAll(plot[each.getR()][each.getC()].grow(each));
        }
        return addPlants;
    }

    /**
     * Purpose: This method handles the grow functionality of the plot
     * 
     * @param times:
     *            The number of times a plant has to be grown
     */
    public void grow(int times) {
        // TODO: Complete the grow method
        while (times > 0 && growNumber < 5) {
            List<Coordinates> plantsPresent = getPlantCoordinates();
            List<Coordinates> addPlants = getPlacesToAddNewPlants(
                    plantsPresent);
            for (Coordinates each : addPlants) {
                Plant newToBeAdded = createPlant(plant);
                plot[each.getR()][each.getC()] = newToBeAdded;
            }
            times--;
            growNumber++;
        }

    }

    /**
     * Purpose: This method handles the grow functionality of a specific type of
     * plant
     * 
     * @param times:
     *            The number of times the plant has to grow
     * @param type:
     *            The type of plant which has to grow
     */
    public void growIfCorrectType(int times, String type) {
        // TODO: Complete the method
        if (type.equalsIgnoreCase(plant)) {
            grow(times);
        }
    }

    /**
     * Purpose: This method handles the grow functionality of a specific
     * category of plant
     * 
     * @param times:
     *            The number of times the plant has to grow
     * @param category:
     *            The category of plants which needs to grow
     */
    public void growIfCorrectCategory(int times, String category) {
        // TODO: Grow if correct category
        if (category.equalsIgnoreCase("vegetable") && isVegetable()) {
            grow(times);
        }
        if (category.equalsIgnoreCase("tree") && isTree()) {
            grow(times);
        }
        if (category.equalsIgnoreCase("flower") && isFlower()) {
            grow(times);
        }
    }
}