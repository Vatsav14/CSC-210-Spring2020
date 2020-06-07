/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Garden.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Garden object. Each Garden object primarily consists
 * of a 2D array of Plot objects. It contains information to initialize a Garden object and specific 
 * methods that are to be processed on a Garden object.
 * 
 * 
 * EXAMPLE CALL TO THE GARDEN CONSTRUCTOR:
 * Garden myGarden = new Garden(4,5);
 * 
 * This creates a new garden which is 4 plots tall and 5 plots wide
 */

public class Garden {

    private Plot[][] myGarden;
    private static final int MAX_COLS = 16;
    private int rows, cols;

    /**
     * Purpose: This is the constructor for the Garden class. It creates a new
     * garden with the rows and columns passed in as parameters
     * 
     * @param rows:
     *            An integer representing the number of rows in the Garden
     * @param cols:
     *            An integer representing the number of columns in the Garden
     */
    public Garden(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        assert (cols <= MAX_COLS);

        myGarden = new Plot[this.rows][this.cols];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                myGarden[i][j] = new Plot();
            }

        }
    }

    /**
     * Purpose: This method handles plants a plant at a certain location in the
     * Garden
     * 
     * @param row:
     *            An integer representing the row number at which to plant the
     *            Plant
     * @param col:
     *            An integer representing the columns number at which to plant
     *            the Plant
     * @param toPlant:
     *            The plant object which is to be planted in the plot
     */
    public void plant(int row, int col, Plant toPlant) {
        if ((row < rows && row >= 0) && (col < cols && col >= 0)) {
            myGarden[row][col].plant(toPlant);
        }
    }

    /**
     * Purpose: This function handles the general grow functionality of the
     * garden
     * 
     * @param times:
     *            An integer representing the number of times the plants in the
     *            Garden have to be grown
     */
    public void grow(int times) {
        for (Plot[] each : myGarden) {

            for (Plot everyPlot : each) {
                everyPlot.grow(times);
            }

        }
    }
    
    /**
     * Purpose: This function handles the grow functionality of a specific plot
     * in the Garden
     * 
     * @param times:
     *            The integer representing the number of times the plants in the
     *            Garden have to be grown
     * @param row:
     *            An integer representing the row number of the Plot that is to
     *            be grown
     * @param col:
     *            An integer representing the column number of the Plot that is
     *            to be grown
     */
    public void growSpecificPlot(int times, int row, int col) {
        if(row>=rows || row<0 || col>=cols || col<0) {
            System.out.println("Can't grow there.\n");
        }
        else if(myGarden[row][col].isEmpty()) {
            System.out.println("Can't grow there.\n");
        }
        else {
            myGarden[row][col].grow(times);
        }
    }
    
    /**
     * Purpose: This function handles the grow functionality when a specific
     * plant is to be grown
     * 
     * @param times:
     *            The integer representing the number of times the plants in the
     *            Garden have to be grown
     * @param plant:
     *            The String representing the type of plant that has to be grown
     */
    public void growSpecificPlant(int times, String plant) {
        for (Plot[] each : myGarden) {

            for (Plot eachPlot : each) {
                eachPlot.growIfCorrectType(times, plant);
            }

        }
    }

    /**
     * Purpose:This function handles the grow functionality when a specific
     * class of Plants have to be grown
     * 
     * @param times:
     *            The integer representing the number of times the plants in the
     *            garden have to be grown
     * @param category:The
     *            String representing the category of plants that have to be
     *            grown
     */
    public void growCategory(int times, String category) {
        for (Plot[] each : myGarden) {
            for (Plot eachPlot : each) {
                eachPlot.growIfCorrectCategory(times, category.toLowerCase());
            }
        }
    }

    /**
     * Purpose: This method handles the harvest functionality of the garden.
     */
    public void harvest() {
        for (Plot[] each : myGarden) {
            for (Plot eachPlot : each) {
                if (eachPlot.isVegetable())
                    eachPlot.harvest();
            }
        }
    }

    /**
     * Purpose:This function handles the harvest functionality when the plot to
     * be harvested is given
     * 
     * @param row:
     *            The integer representing the row at which the plot to be
     *            harvested is present
     * @param col:
     *            The integer representing the column at which the plot to be
     *            harvested is present
     */
    public void harvestSpecificPlot(int row, int col) {
        if (row >= rows || row < 0 || col >= cols || col < 0) {
            System.out.println("Can't harvest there.\n");
        } else if (myGarden[row][col].isEmpty()
                || (!myGarden[row][col].isVegetable())) {
            System.out.println("Can't harvest there.\n");
        } else {
            myGarden[row][col].harvest();
        }
    }

    /**
     * Purpose: The function which handles the harvest functionality when the
     * type of vegetable to be harvested is provided
     * 
     * @param type:
     *            The String representing the type of vegetable to be harvested
     */
    public void harvestSpecificType(String type) {
        for (Plot[] each : myGarden) {
            for (Plot eachPlot : each) {
                if (eachPlot.isVegetable()) {
                    eachPlot.harvestSpecificType(type);
                }
            }
        }
    }

    /**
     * Purpose: This method handles the pick functionality of the garden
     */
    public void pick() {
        for (Plot[] each : myGarden) {
            for (Plot eachPlot : each) {
                if (eachPlot.isFlower()) {
                    eachPlot.pick();
                }
            }
        }
    }

    /**
     * Purpose: This method handles the pick functionality of the garden when
     * the plot that is to be picked is provided
     * 
     * @param row:
     *            The integer representing the row at which the plot to be
     *            picked is present
     * @param col:
     *            The integer representing the row at which the plot to be
     *            picked is present
     */
    public void pickSpecificPlot(int row, int col) {
        if (row >= rows || row < 0 || col >= cols || col < 0) {
            System.out.println("Can't pick there.\n");
        } else if (myGarden[row][col].isEmpty()
                || (!myGarden[row][col].isFlower())) {
            System.out.println("Can't pick there.\n");
        } else {
            myGarden[row][col].pick();
        }
    }

    /**
     * Purpose: This function handles the pick functionality when the plot to
     * be harvested is given
     * 
     * @param type:
     *            The String representing the type of flower to be picked
     */
    public void pickSpecificType(String type) {
        for (Plot[] each : myGarden) {
            for (Plot eachPlot : each) {
                if (eachPlot.isFlower()) {
                    eachPlot.pickSpecificType(type);
                }
            }
        }
    }

    /**
     * Purpose: This method handles the cut functionality of the garden
     */
    public void cut() {
        for (Plot[] each : myGarden) {
            for (Plot eachPlot : each) {
                if (eachPlot.isTree())
                    eachPlot.cut();
            }
        }
    }

    /**
     * Purpose: This function handles the cut functionality of the garden when
     * the coordinates of the plot to be picked are provided
     * 
     * @param row:
     *            The integer representing the row at which the plot to be cut
     *            is present
     * @param col:
     *            The integer representing the row at which the plot to be cut
     *            is present
     */
    public void cutSpecificPlot(int row, int col) {
        if (row >= rows || row < 0 || col >= cols || col < 0) {
            System.out.println("Can't cut there.\n");
        } else if (myGarden[row][col].isEmpty()
                || (!myGarden[row][col].isTree())) {
            System.out.println("Can't cut there.\n");
        } else {
            myGarden[row][col].cut();
        }
    }

    /**
     * Purpose: This method handles the cut functionality of the garden when the
     * specific type of plant to be cut is provided
     * 
     * @param type:
     *            The String representing the type of tree that is to be cut
     */
    public void cutSpecificType(String type) {
        for (Plot[] each : myGarden) {
            for (Plot eachPlot : each) {
                if (eachPlot.isTree()) {
                    eachPlot.cutSpecificType(type);
                }
            }
        }
    }

    /**
     * Purpose: This function returns a String representation of the Garden
     * objects in which each of the plots and plants are visible to the user
     * 
     * @return Returns a String representation of the Garden objects
     */
    public String toString() {
        String retval = "";

        for (int i = 0; i < myGarden.length; i++) {

            for (int plotRows = 0; plotRows < 5; plotRows++) {

                for (int j = 0; j < myGarden[i].length; j++) {
                    retval += myGarden[i][j].getString(plotRows);
                }

                retval += "\n";
            }

        }

        return retval;
    }
}