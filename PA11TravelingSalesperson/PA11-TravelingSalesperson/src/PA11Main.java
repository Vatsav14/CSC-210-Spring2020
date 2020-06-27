/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: PA11Main.java
 * ASSIGNMENT: Programming Assignment 11 - TravellingSalesperson
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file contains the main method which runs the entire process for the PA. It reads in
 * command line arguments and redirects control to the parts of the program that handle the specific
 * commands. It contains three methods to calculate the salesperson's path: (1) Heuristic approach
 * (2) Backtracking approach (3) My approach (personal algorithm)
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PA11Main {

    /**
     * This is the main method of the class. Serves as the control center
     * for the entire program
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        MTXReader m = new MTXReader();
        String method = args[1];
        m.read(args[0]);
        DGraph graph = m.graph;

        // Case in which the HEURISTIC approach is called
        if (method.equalsIgnoreCase("HEURISTIC"))
            System.out.println(heuristicApproach(graph).toString(graph));

        // Case in which the BACKTRACKING approach is called
        else if (method.equalsIgnoreCase("BACKTRACK"))
            System.out.println(backtrackingApproach(graph).toString(graph));

        // Case in which the MINE approach is called
        else if (method.equalsIgnoreCase("MINE"))
            System.out.println(myApproach(graph).toString(graph));

        // Case in which the TIME command is called
        else if (method.equalsIgnoreCase("TIME"))
            time(graph);
    }

    /**
     * This method contains the heuristic approach to the Traveling Salesperson
     * problem. Works by finding the smallest distance between two adjacent
     * nodes
     * 
     * @param graph
     * @return One of the possible trips that satisfies the conditions
     *         In this case, the one in which the distance between the adjacent
     *         nodes is the least and the starting node is 1
     */
    public static Trip heuristicApproach(DGraph graph) {
        Trip trip = new Trip(graph.getNumNodes());
        int currCity = 1;
        trip.chooseNextCity(1);
        for (int k = 2; k <= graph.getNumNodes(); k++) {
            double min = Double.MAX_VALUE;
            int c = 0;

            // Finds the shortest distance between consecutive nodes
            for (Integer each : graph.getNeighbors(currCity)) {
                if (trip.isCityAvailable(each)
                        && min > graph.getWeight(currCity, each)) {
                    min = graph.getWeight(currCity, each);
                    c = each;
                }
            }

            // Change the current node to the closest node founds
            trip.chooseNextCity(c);
            currCity = c;
        }
        return trip;
    }

    /**
     * This function contains the recursive backtracking approach to the
     * Traveling Salesperson problem. It is a brute-force method that searches
     * for the shortest path assuming 1 to be the first node
     * 
     * @param graph
     * @return The shortest possible trip that the Salesperson can take assuming
     *         that they start from city 1
     */
    private static Trip backtrackingApproach(DGraph graph) {
        Trip trip = new Trip(graph.getNumNodes());
        trip.chooseNextCity(1);
        // Advance the problem to the helper to get the result
        trip = recHelper(graph, trip, new Trip(graph.getNumNodes()));
        return trip;
    }

    /**
     * This is a helper function for the recursive method. It takes as
     * parameters
     * the current trip, the shortest possible path made and the graph
     * 
     * @param graph
     * @param currTrip
     * @param minTrip
     * 
     * @return The shortest possible trip that the Salesperson can take assuming
     *         that they start from city 1
     */
    private static Trip recHelper(DGraph graph, Trip currTrip, Trip minTrip) {
        if (currTrip.citiesLeft().isEmpty()) {
            if (currTrip.tripCost(graph) < minTrip.tripCost(graph))
                minTrip.copyOtherIntoSelf(currTrip);
            return minTrip;
        }
        if (currTrip.tripCost(graph) < minTrip.tripCost(graph)) {
            for (Integer each : currTrip.citiesLeft()) {
                currTrip.chooseNextCity(each);
                minTrip = recHelper(graph, currTrip, minTrip);
                currTrip.unchooseLastCity();
            }
        }
        return minTrip;
    }

    /**
     * This method contains my personal approach to the Traveling Salesperson
     * problem. This closely follows the heuristic approach, but it differs from
     * it in the fact that it doesn't assume that the salesperson will be
     * starting from city 1
     * 
     * @param graph
     * @return The best possible path for the Salesperson with the condition
     *         that the distance between adjacent nodes is the least possible
     */
    private static Trip myApproach(DGraph graph) {
        Trip minTrip = new Trip(graph.getNumNodes());

        // Changing the starting city for the salesperson
        for(int i = 1; i <= graph.getNumNodes(); i++) {
            Trip trip = new Trip(graph.getNumNodes());
            int currCity = i;
            trip.chooseNextCity(i);

            // Same as the Heuristic approach
            for (int k = 1; k <= graph.getNumNodes(); k++) {
                if(i == k)  continue;
                double min = Double.MAX_VALUE;
                int c = 0;
                for (Integer each : graph.getNeighbors(currCity)) {
                    if (trip.isCityAvailable(each)
                            && min > graph.getWeight(currCity, each)) {
                        min = graph.getWeight(currCity, each);
                        c = each;
                    }
                }
                trip.chooseNextCity(c);
                currCity = c;
            }

            // Change the minimum trip if the current trip is cheaper
            // than the current cheapest trip
            if (trip.tripCost(graph) < minTrip.tripCost(graph))
                minTrip.copyOtherIntoSelf(trip);

        }
        return minTrip;
    }

    /**
     * This function finds the run time for every approach to solve the
     * Traveling Salesperson.
     * 
     * @param graph
     */
    private static void time(DGraph graph) {
        Trip trip = new Trip(graph.getNumNodes());

        for (int i = 0; i < 10; i++) {

            // Timing the Heuristic approach
            long startTime = System.nanoTime();
            trip = heuristicApproach(graph);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            System.out.println("heuristic: cost = " + trip.tripCost(graph)
                    + ", " + duration + " milliseconds");

            // Timing my personal approach
            startTime = System.nanoTime();
            trip = myApproach(graph);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("mine     : cost = " + trip.tripCost(graph)
                    + ", "
                    + duration + " milliseconds");

            // Timing the recursive backtracking approach
            startTime = System.nanoTime();
            trip = backtrackingApproach(graph);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("backtrack: cost = " + trip.tripCost(graph)
                    + ", " + duration + " milliseconds\n\n");

        }

    }

    /*
     * This class is used to read in a matrix and produce a graph representation
     * of the sparse matrix.
     * 
     * Sample usage:
     * MTXReader m = new MTXReader();
     * DGraph graph = m.read(filename)
     */
    private static class MTXReader {
        private DGraph graph;

        /**
         * This method reads in a .mtx file and uses the contents to create
         * a graph representation of it
         * 
         * @param filename
         * @throws FileNotFoundException
         */
        public void read(String filename) throws FileNotFoundException {
            Scanner sc = new Scanner(new File(filename));
            String line = "";
            boolean comment = true;

            while (comment) {
                line = sc.nextLine();
                comment = line.startsWith("%");
            }

            String str[] = line.split("\\s+");
            int rows = Integer.valueOf(str[0].trim()).intValue();

            graph = new DGraph(rows);
            while (sc.hasNext()) {
                line = sc.nextLine();
                str = line.split("\\s+");
                int node1 = (Integer.valueOf(str[0].trim())).intValue();
                int node2 = (Integer.valueOf(str[1].trim())).intValue();
                double weight = (Double.valueOf(str[2].trim())).doubleValue();
                graph.addEdge(node1, node2, weight);
            }

            sc.close();
        }
    }
}
