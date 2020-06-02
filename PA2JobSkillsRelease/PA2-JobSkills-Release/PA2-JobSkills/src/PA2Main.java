/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: PA2Main.java
 * ASSIGNMENT: Programming Assignment 2 - Job Skills
 * PURPOSE: This program takes in a comma separated file and a command
 * (either CATCOUNT or LOCATION) and displays the result of the operation
 * 
 * CATCOUNTS: This command gives the total number of times each category is present
 * in the given file.
 * 
 * LOCATION: This command gives the displays all the various locations of a certain category 
 * and the number of times they are present in the file
 * 
 * -----------------------------EXAMPLE INPUT-----------------------------

 * Input File:
 * ----------------------------------------------------------------------- 
 * Company  Title   Category   Location  Responsibilities  Minimum Qualifications  Preferred Qualifications
 * Google  TitleA  CategoryX   Tel Aviv    Everything and the rest  BS                   MS
 * Google  TitleB  CategoryX   Tel Aviv    Everything and the rest  BS                   MS
 * Google  TitleB  CategoryY   Houston     Everything and the rest  BS                   MS
 * Google  TitleC  CategoryX   Jonesboro   Everything and the rest  BS                   MS 
 * 
 * Output for CATCOUNT:
 * Number of positions for each category
 * -------------------------------------
 * CategoryX, 3
 * CategoryY, 1
 * 
 * Output for LOCATIONS CategoryX:
 * LOCATIONS for category: CategoryX
 * -------------------------------------
 * Jonesboro, 1
 * Tel Aviv, 2
 * 
 * ---------------------------------------------------------------------------------------------
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PA2Main {
    public static void main(String[] args) throws FileNotFoundException {

        /*
         * Purpose: This method is the main method that calls the rest of the
         * functions in the required order.
         * 
         * @param
         * args: contains the files locations and the command to be executed
         * 
         * @return void: No return values.
         */

        /*
         * File inputFile = new File(args[0]);
         * String command = args[1];
         * Map<String, List> jobCategories = mapMaker(inputFile);
         * 
         * if (command.equals("CATCOUNT")) {
         * catcountsHandler(jobCategories);
         * }
         * 
         * else if (command.equals("LOCATIONS")) {
         * if (jobCategories.containsKey(args[2])) {
         * locationHandler(jobCategories.get(args[2]), args[2]);
         * }
         * else {
         * // if the location is invalid, send locationHandler an empty
         * // list so as to display no results
         * List<String> empty = new LinkedList<String>();
         * locationHandler(empty, args[2]);
         * }
         * }
         * 
         * else {
         * System.out.println("Invalid Command");
         * }
         */
        
        int ans = reorderer(12, 7);
        System.out.println(ans);
    }

    private static int reorderer(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        else {
            return reorderer(y, x % y);
        }
    }

    private static Map<String, List> mapMaker(File inputFile)
            throws FileNotFoundException {

        /*
         * Purpose: This function constructs the Map that contains the name of
         * the various categories and a List of the various locations that are
         * associated with it
         * 
         * @param
         * inputFile: The comma separated file that was passed in as an argument
         * 
         * @return
         * jobCategories: The map which connects the various categories with the
         * locations that they are associated with
         */

        Scanner fileReader = new Scanner(inputFile);
        Map<String, List> jobCategories = new TreeMap<String, List>();
        fileReader.nextLine(); // this is to account for the column headers
        // so as to skip over the entire first line of the file.

        while (fileReader.hasNext()) {
            String[] line = fileReader.nextLine().split(",");
            String cat = line[2], location = line[3];

            if (!jobCategories.containsKey(cat)) {
                List<String> temp = new LinkedList<String>();
                temp.add(location);
                jobCategories.put(cat, temp);
            }
            else {
                jobCategories.get(cat).add(location);
            }

        }

        fileReader.close();

        return jobCategories;
    }

    private static void catcountsHandler(Map<String, List> jobCategories) {

        /*
         * Purpose: This function simply displays the result of the CATCOUNT
         * command in the required format
         * 
         * @param
         * jobCategories: The map which maps the categories to the various
         * locations
         * 
         * @return
         * No return values
         */

        System.out.println("Number of positions for each category");
        System.out.println("-------------------------------------");

        for (String each : jobCategories.keySet()) {
            int count = jobCategories.get(each).size();
            System.out.println(each + ", " + count);
        }
    }

    private static void locationHandler(List locations, String categ) {

        /*
         * Purpose: This function simply displays the result of the LOCATIONS
         * command in the required format
         * 
         * @param
         * jobCategories: The map which maps the categories to the various
         * locations
         * categ: The category whose locations are being displayed
         * 
         * @return
         * No return values
         */

        Map<String, Integer> locationMap = locationMapMaker(locations);
        System.out.println("LOCATIONS for category: " + categ);

        System.out.println("-------------------------------------");
        for (String each : locationMap.keySet()) {
            System.out.println(each + ", " + locationMap.get(each));
        }
    }

    private static Map<String, Integer> locationMapMaker(
            List<String> locations) {
        /*
         * Purpose: This function takes in the list of various locations of a
         * certain category and creates a Map recording the number of times each
         * of the element is present.
         * 
         * @param
         * locations: A list containing the various locations related to a
         * certain category
         * 
         * @return
         * locationMap: A map relating a location to the number of times it is
         * present in the list
         */

        Map<String, Integer> locationMap = new TreeMap<String, Integer>();

        for (String each : locations) {
            if (locationMap.containsKey(each)) {
                locationMap.put(each, locationMap.get(each) + 1);
                // this simply increments the number of occurrences of the
                // location in the list by 1
            } else {
                locationMap.put(each, 1);
            }
        }

        return locationMap;
    }
}

