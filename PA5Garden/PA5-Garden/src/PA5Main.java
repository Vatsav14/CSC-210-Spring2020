
/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: PA5Main.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file contains the main method of the entire project. It reads in the name of the file 
 * containing commands to be executed on a Garden object and proceeds to execute each of these commands
 * in order
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PA5Main {

    /**
     * Purpose: This is the main method for the project. It acts as the
     * backbone of the project and directs the flow of the program. It takes in
     * the file to be read and passes control to the part of the program
     * responsible for handling each individual command
     * 
     * @param
     * args
     *            contains the name of the file to be read
     * 
     * @return No return value
     * @throws FileNotFoundException
     */
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));

        String rowLine[] = sc.nextLine().split(" ");
        String colLine[] = sc.nextLine().split(" ");

        int rows = Integer.parseInt(rowLine[1]);
        int cols = Integer.parseInt(colLine[1]);

        if (cols > 16) {
            System.out.println("Too many plot columns.");
            return;
        }

        Garden myGarden = new Garden(rows, cols);

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String command[] = line.split(" ");
            line = formatOutput(command);

            if (command == null) {
                continue;
            }

            if (command[0].equalsIgnoreCase("plant")) {
                handlePlant(command, myGarden);
            } else if (command[0].equalsIgnoreCase("print")) {
                System.out.println("> " + line);
                handlePrint(command, myGarden);
            } else if (command[0].equalsIgnoreCase("grow")) {
                System.out.println("> " + line + "\n");
                handleGrow(command, myGarden);
            } else if (command[0].equalsIgnoreCase("harvest")) {
                System.out.println("> " + line + "\n");
                handleHarvest(command, myGarden);
            } else if (command[0].equalsIgnoreCase("pick")) {
                System.out.println("> " + line + "\n");
                handlePick(command, myGarden);
            } else if (command[0].equalsIgnoreCase("cut")) {
                System.out.println("> " + line + "\n");
                handleCut(command, myGarden);
            }
        }
    }

    /**
     * Purpose: This function is responsible for handling the plant command
     * 
     * @param command:
     *            The plant command that was passed in
     * @param myGarden:
     *            A Garden object that is to be manipulated
     * 
     * @return No return type
     */
    static void handlePlant(String[] command, Garden myGarden) {
        String rc = command[1];
        int rowcol[] = formatCoordinates(command[1]);
        int row = rowcol[0];
        int col = rowcol[1];

        String plant = command[2].toLowerCase();
        Plant toPlant = Plot.createPlant(plant);
        myGarden.plant(row, col, toPlant);
    }

    /**
     * Purpose: This function is responsible for handling the print command
     * 
     * @param command:
     *            The print command that was passed in
     * @param myGarden:
     *            The current Garden object that is to be manipulated
     */
    static void handlePrint(String[] command, Garden myGarden) {
        System.out.println(myGarden);
    }

    /**
     * Purpose: This function is responsible for handling each of the grow
     * commands
     * 
     * @param command:
     *            The grow command that was passed in
     * @param myGarden:
     *            The current Garden object that is to be manipulated
     */
    static void handleGrow(String[] command, Garden myGarden) {
        int times = Integer.parseInt(command[1]);

        if (command.length == 2) {
            myGarden.grow(times);
        }

        else {
            if (command[2].charAt(0) == '(') {
                int rowcol[] = formatCoordinates(command[2]);
                int row = rowcol[0];
                int col = rowcol[1];
                myGarden.growSpecificPlot(times, row, col);
            } else {
                if (!checkIfCategory(command[2])) {
                    myGarden.growSpecificPlant(times, command[2]);
                } else {
                    myGarden.growCategory(times, command[2]);
                }
            }
        }
    }

    /**
     * Purpose: This function checks if a given string is the name of a
     * category, namely 'vegetable', 'tree' or 'flower'
     * 
     * @param name:
     *            The String that is to be checked
     * 
     * @return Boolean value indicating whether a given string is the name of a
     *         category or not
     */
    public static boolean checkIfCategory(String name) {
        if(name.equalsIgnoreCase("vegetable") || name.equalsIgnoreCase("tree") || name.equalsIgnoreCase("flower")) {
            return true;
        }

        else {
            return false;
        }
    }

    /**
     * Purpose: This function handles each of the harvest commands
     * 
     * @param command:
     *            The harvest command that was passed in
     * @param myGarden:
     *            The current Garden object that is to be manipulated
     */
    private static void handleHarvest(String[] command, Garden myGarden) {
        if (command.length == 1) {
            myGarden.harvest();
        }

        else {
            if (command[1].charAt(0) == '(') {
                int rowcol[] = formatCoordinates(command[1]);
                int row = rowcol[0];
                int col = rowcol[1];
                myGarden.harvestSpecificPlot(row, col);
            } else {
                myGarden.harvestSpecificType(command[1]);
            }
        }
    }

    /**
     * Purpose: This method handles each of the various pick commands
     * 
     * @param command:
     *            The pick command that was passed in
     * @param myGarden:
     *            The current Garden that is to be manipulated
     */
    private static void handlePick(String[] command, Garden myGarden) {
        if (command.length == 1) {
            myGarden.pick();
        }

        else {
            if (command[1].charAt(0) == '(') {
                int rowcol[] = formatCoordinates(command[1]);
                int row = rowcol[0];
                int col = rowcol[1];
                myGarden.pickSpecificPlot(row, col);
            } else {
                myGarden.pickSpecificType(command[1]);
            }
        }
    }

    /**
     * Purpose: This method handles each of the cut commands
     * 
     * @param command:
     *            The cut command that was just passed in
     * @param myGarden:
     *            The current Garden object that is to be manipulated
     */
    private static void handleCut(String[] command, Garden myGarden) {
        if (command.length == 1) {
            myGarden.cut();
        }

        else {
            if (command[1].charAt(0) == '(') {
                int rowcol[] = formatCoordinates(command[1]);
                int row = rowcol[0];
                int col = rowcol[1];
                myGarden.cutSpecificPlot(row, col);
            } else {
                myGarden.cutSpecificType(command[1]);
            }
        }
    }

    /**
     * Purpose: This method formats the commadn provided to make it display in
     * the appropriate manner
     * 
     * @param command:
     *            The String containing the command to be formatted
     * 
     * @return line: The String that contains the command to be displayed
     */
    private static String formatOutput(String[] command) {
        String line = command[0].toUpperCase();

        if (command.length > 1) {
            for (int i = 1; i < command.length; i++) {
                line += " " + command[i].toLowerCase();
            }
        }

        return line;
    }

    /**
     * Purpose: This method reads in a String of the form '(x,y)' where x and y
     * are numbers and returns an integer array containing x and y
     * 
     * @param c:
     *            The String that is to be converted into the desired format
     * 
     * @return rowcol: The integer array containing the numbers in the
     *         parentheses separated by a colon
     */
    private static int[] formatCoordinates(String c) {
        c = c.substring(1, c.length() - 1);
        String rc[] = c.split(",");
        int rowcol[] = new int[2];

        for (int i = 0; i <= 1; i++) {
            rowcol[i] = Integer.parseInt(rc[i]);
        }

        return rowcol;
    }

}
