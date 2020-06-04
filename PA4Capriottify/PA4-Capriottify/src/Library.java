/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Library.java
 * ASSIGNMENT: Programming Assignment 4 - Capriottify
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Library object. It contains information to
 * initialize a Library object and specific methods that are to be processed on a Library
 * object. Each library contains a list of Song objects
 * 
 * 
 * EXAMPLE CALL TO THE LIBRARY CONSTRUCTOR:
 * Library myLib = new Library();
 * 
 * This creates a new library that is currently empty and has no songs in it 
 */

import java.util.ArrayList;
import java.util.List;

public class Library{
	
	private List<Song> allSongs;
	
	public Library() {
		
		/*
		 * Purpose: This is the constructor of the Library class which creates a new Library
		 * with no songs in it
		 * 
		 * @param
		 * No parameters
		 */
		
		this.allSongs = new ArrayList<Song>();
	}
	
	public Song getSong(String title) {
		
		/*
		 * Purpose: This method returns the Song object whose title has been passed
		 * as an argument
		 * 
		 * @param
		 * title: A String representing the title of the Song
		 * 
		 * @return
		 * each: The Song object whose title was given to be found
		 * 
		 */
		
		for(Song each : allSongs) {
			if(each.getTitle().equals(title)) {
				return each;
			}
		}
		
		return null; // Returns null if the song title wasn't found
	}
	
	public List<Song> getAllSongs(){
		
		/*
		 * Purpose: This function simply serves to get the list of all the song objects
		 * in the Library
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * allSongs: A List containing all of the Song objects in the Library
		 * 
		 */
		
		return allSongs;
	}
	
	public void addSong(Song song) {
		
		/*
		 * Purpose: This method adds a Song object in ascending order of title if the
		 * song is not already present in the Library
		 * 
		 * @param
		 * song: The song object to be added
		 * 
		 * @return
		 * No return values
		 * 
		 */
		
		int index = 0;
		for(Song each : allSongs) {
			if(each.getTitle().compareTo(song.getTitle()) > 0) { // Check for the order
				break;
			}
			index++;
		}
		allSongs.add(index, song);
	}
	
	public void removeSong(Song song) {
		
		/*
		 * Purpose: This method removes a particular song if it is present in the
		 * Library 
		 * 
		 * @param
		 * The song object to be removed
		 * 
		 * @return
		 * No return value
		 * 
		 */
		
		if(allSongs.contains(song)) {
			allSongs.remove(song);
		}
	}
	
	public String toString() {
		
		/*
		 * Purpose: This method creates the String representation of a Library object
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * songs: Returns each of the String representations of each of the Songs in
		 * the library
		 * 
		 */
		
		String songs = "";
		for(Song each : allSongs) {
			songs += each.toString() + "\n";
		}
		return songs;
	}
	
}