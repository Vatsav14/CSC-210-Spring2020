/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: DGraph.java
 * ASSIGNMENT: Programming Assignment 11 - TravellingSalesperson
 * COURSE: CSc 210 Spring 2020
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DGraph.java
 * 
 * Represents a directed graph. The nodes are represented as
 * integers ranging from 1 to num_nodes inclusive.
 * The weights are assumed to be >= zero.
 * 
 * Usage instructions:
 * 
 * Construct a DGraph
 * DGraph graph = new DGraph(numNodes);
 * 
 * Add an edge
 * graph.addEdge(v, w, weight);
 * 
 * Other useful methods:
 * graph.getWeight(v,w)
 * graph.getNumNodes()
 * List<Integer> list = graph.getNeighbors(v);
 * 
 */
public class DGraph {

    private List<Edge> edges;
    private final int numNodes;

    /*
     * Constructs an instance of the DGraph class with # nodes numNodes.
     */
    public DGraph(int numNodes) {
        edges = new ArrayList<Edge>();
        this.numNodes = numNodes;
    }

    /**
     * Adds the directed edge (v,w) to the graph including updating the node
     * count appropriately.
     * 
     * @param v
     * @param w
     */
    public void addEdge(int v, int w, double distance) {
        Edge toAdd = new Edge(v, w, distance);
        edges.add(toAdd);
        Collections.sort(edges);
        // The node count is not being updated since the constructor
        // already gives the final value of the number of nodes in the graph
    }

    /*
     * Returns the number of nodes in this graph.
     */
    public int getNumNodes() {
        return this.numNodes;
    }

    // Returns the weight for the given edge.
    // Returns -1 if there is no edge between the nodes v and w.
    public double getWeight(int v, int w) {

        // This Edge is created just to check the Lexicographical
        // ordering of the edges to get the weight
        Edge checker = new Edge(v, w, 0.0); // Dummy value of weight 0.0 used
        
        for(Edge each : edges) {
            if (each.equals(checker))
                return each.weight;
        }

        return -1;
    }

    /**
     * For a given node returns a sorted list of all its neighbors.
     * 
     * @param v
     *            Node identifier
     * @return A sorted list of v's neighbors.
     */
    public List<Integer> getNeighbors(int v) {
        Set<Integer> allNeighbors = new HashSet<Integer>();
        for (Edge each : edges) {
            if (each.node1 == v)
                allNeighbors.add(each.node2);
            if (each.node2 == v)
                allNeighbors.add(each.node1);
        }
        List<Integer> sortedN = new ArrayList<Integer>();
        sortedN.addAll(allNeighbors);
        Collections.sort(sortedN);
        return sortedN;
    }

    /* --------------------------------------- */
    /*
     * You should not need to touch anything below this line,
     * except for maybe the name edges in the for each loop just below
     * in the toDotString method if you named your collection of edges
     * differently.
     */
    // Create a dot representation of the graph.
    public String toDotString() {
        String dot_str = "digraph {\n";
        // Iterate over the edges in order.
        for (Edge e : edges) {
            dot_str += e.toDotString() + "\n";
        }
        return dot_str + "}\n";
    }

    /**
     * Immutable undirected edges.
     */
    public class Edge implements Comparable<Edge> {

        // Nodes in edge and weight on edge
        private final int node1;
        private final int node2;
        private final double weight;
        
        /**
         * Stores the given nodes with smaller id first.
         * 
         * @param node1
         * @param node2
         */
        public Edge(int node1, int node2, double weight) {
            assert weight >= 0.0;
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        /**
         * @return an directed edge string in dot format
         */
        public String toDotString() {
            return "" + node1 + " -> " + node2 + " [label=\"" + weight
                    + "\"];";
        }

        /**
         * Lexicographical ordering on edges (node1,node2).
         */
        public int compareTo(Edge other) {
            if (this.equals(other)) {
                return 0; // this and other are equal
            } else if ((node1 < other.node1)
                    || (node1 == other.node1 && node2 < other.node2)) {
                return -1; // this is less than other
            } else {
                return 1; // this is greater than other
            }
        }

        /**
         * Lexicographical ordering on edges (node1,node2).
         */
        public boolean equals(Object o) {
            if (!(o instanceof Edge)) {
                return false;
            }
            Edge other = (Edge) o;
            return (node1 == other.node1) && (node2 == other.node2);
        }

        /**
         * Know number of nodes when read in input file, so can give each edge a
         * unique hash code.
         */
        public int hashCode() {
            return getNumNodes() * node1 + node2;
        }
    }

}
