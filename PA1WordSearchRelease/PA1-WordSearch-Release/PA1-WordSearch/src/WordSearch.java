/* 
 * AUTHOR: Vatsav Sethupathi
 * FILE: WordSearch.java
 * ASSIGNMENT: Programming Assignment 1 - Word Search
 * PURPOSE: This program reads in two files, a grid containing words to be found
 * and a dictionary which includes the list of valid words. It then proceeds to 
 * find the words hidden in the grid by comparing them to the words in the 
 * dictionary and displays the words that it found
 * 
 * 
 * -----------------------------EXAMPLE INPUT-----------------------------
 * Input File containing the grid:
 * -----------------------------------------------------------------------
 * 6
 * 6
 * y c o d e j
 * h s e y p k
 * l p h b w a
 * l o b w x z
 * w o b a a i
 * p l y y c g
 * -----------------------------------------------------------------------
 * The output for the following input will be the list of words found in the grid
 * following a specific order, namely, Left to right, right to left, top to bottom and
 * bottom to top. Therefore, the first word to be displayed in this case will be cod
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSearch {

    private static final int MIN_WORD_LENGTH = 3;

    static public void main(String[] args) throws FileNotFoundException {

        /*
         * Purpose: This method is the main method that calls the rest of the
         * functions in the
         * required order and displays the final output.
         * 
         * @param
         * args: contains the files locations that contain the grid and the
         * dictionary to be used.
         * 
         * @return void: No return values.
         */

        List<String> wordsFound = new ArrayList<String>();
        List<String> dictionary = new ArrayList<String>();
        dictionary = dictReader(args[0]);

        String[] grid = gridMaker(args[1]);
        String[] reverseGrid = new String[grid.length];
        for (int control = 0; control < grid.length; control++)
            reverseGrid[control] = reverse(grid[control]);

        String[] topDownGrid = topDownConverter(grid);
        String[] downTopGrid = new String[topDownGrid.length];
        for (int control = 0; control < topDownGrid.length; control++)
            downTopGrid[control] = reverse(topDownGrid[control]);

        // This finds the various orientations of the grid that we need
        List<String> leftToRight = new ArrayList<String>();
        List<String> rightToLeft = new ArrayList<String>();
        List<String> topToBottom = new ArrayList<String>();
        List<String> bottomToTop = new ArrayList<String>();

        leftToRight.addAll(getAllSubstrings(grid)); // This gets all the valid
        rightToLeft.addAll(getAllSubstrings(reverseGrid)); // words that we need
        topToBottom.addAll(getAllSubstrings(topDownGrid)); // to search for in
        bottomToTop.addAll(getAllSubstrings(downTopGrid)); // the dictionary.

        wordsFound.addAll(searchForWords(leftToRight, dictionary));
        wordsFound.addAll(searchForWords(rightToLeft, dictionary));
        wordsFound.addAll(searchForWords(topToBottom, dictionary));
        wordsFound.addAll(searchForWords(bottomToTop, dictionary));

        for (String each : wordsFound) // loop which displays the final output
            System.out.println(each);
    }

    private static List<String> dictReader(String filename)
            throws FileNotFoundException {

        /*
         * Purpose: This is a helper function that takes the file location of
         * the dictionary and returns it
         * as an ArrayList which we can later use in the program.
         * 
         * @param
         * filename: This is the String that contains the file location of the
         * dictionary.
         * 
         * @return
         * dictionary: An ArrayList that serves as the dictionary containing all
         * the required values.
         */

        Scanner fileInput = new Scanner(new File(filename));
        List<String> dictionary = new ArrayList<String>();

        while (fileInput.hasNext())
            dictionary.add(fileInput.nextLine().toLowerCase());
            // Converting to lower case due to arbitrary capital words in the
            // dictionary.

        return dictionary;
    }

    private static String[] gridMaker(String filename)
            throws FileNotFoundException {

        /*
         * Purpose: This is a helper function that takes in the file location of
         * the grid and returns it as a
         * String array which we can manipulate as per our requirements.
         * 
         * @param
         * filename: This is the String that contains the file location of the
         * grid.
         * 
         * @return
         * retGrid: The String array containing all the rows of the input file
         * that are a part of the grid.
         */

        Scanner fileInput = new Scanner(new File(filename));
        int width, height, loopControl = 0;
        width = fileInput.nextInt();
        height = fileInput.nextInt();
        char[][] grid = new char[width][height];

        while (fileInput.hasNext()) {
            char[] line = fileInput.nextLine().replace(" ", "").toCharArray();
            // .replace is to remove the spaces in the grid

            if (line.length != 0) {
                grid[loopControl] = line;
                loopControl++;
            }

        }

        // This procedure is to condense the 2D character array into a 1D String
        // Array
        String[] retGrid = new String[grid.length];
        loopControl = 0;
        for (char[] each : grid) {
            retGrid[loopControl] = String.valueOf(each);
            loopControl++;
        }

        return retGrid;
    }

    private static String reverse(String word) {

        /*
         * Purpose: This is a helper function that simply reverses the string
         * that it is given.
         * 
         * @param
         * word: The string that we need to reverse.
         * 
         * @return
         * reverse: The reversed form of the string that we were given.
         */

        String reverse = "";
        for (int index = word.length() - 1; index >= 0; index--)
            reverse += word.charAt(index);
        return reverse;
    }

    private static List<String> getAllSubstrings(String[] grid) {

        /*
         * Purpose: This function takes the grid and produces the set of all
         * possible substrings within the
         * valid length permitted.
         * 
         * @param
         * grid: An array of Strings representing the grid of words given.
         * 
         * @return
         * words: The list of possible substrings that can be produced.
         */

        List<String> words = new ArrayList<String>();
        for (String line : grid) {
            for (int start = 0; start < line.length(); start++) {
                for (int next = start + MIN_WORD_LENGTH; next <= line
                        .length(); next++) {
                    // This is because we don't want words less than 3
                    // characters long
                    words.add(line.substring(start, next));
                }
            }
        }
        return words;
    }

    private static String[] topDownConverter(String[] grid) {

        /*
         * Purpose: This function produces the transpose of a given grid, namely
         * it makes the rows into columns and the
         * columns into rows.
         * 
         * @param
         * grid: An array of Strings representing the grid to be converted.
         * 
         * @return
         * topDown: An array of strings that represents the transpose of the
         * original grid that the function was given.
         */

        String[] topDown = new String[grid[0].length()];
        int charAtIndex = 0;

        while (charAtIndex < grid[0].length()) {
            String word = "";

            // This gets the specific character at that index for each row
            for (String each : grid)
                word += each.charAt(charAtIndex);

            topDown[charAtIndex] = word; // Adding the converted row to the list
            charAtIndex++;
        }

        return topDown;
    }

    private static List<String> searchForWords(List<String> words,
            List<String> dictionary) {

        /*
         * Purpose: This function finds out the number of words that are present
         * in both the grid and the dictionary.
         * 
         * @param
         * words: The words in a certain orientation of the grid.
         * dictionary: The dictionary which contains the list of valid words
         * that we need to find.
         * 
         * @return
         * wordsFound: An ArrayList containing the words that are present on the
         * grid and the dictionary.
         */

        List<String> wordsFound = new ArrayList<String>();

        for (String each : words) {
            if (dictionary.contains(each.toLowerCase()))
                wordsFound.add(each.toLowerCase());
        }

        return wordsFound;
    }

}