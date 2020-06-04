/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Playlist.java
 * ASSIGNMENT: Programming Assignment 4 - Capriottify
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Playlist object. It contains information to
 * initialize a Playlist object and specific methods that are to be processed on this
 * object. Each playlist contains a name and a list of Songs in the library
 * 
 * 
 * EXAMPLE CALL TO THE SONG CONSTRUCTOR:
 * Playlist itsLit = new Playlist("Top Songs");
 * 
 * This creates a new playlist whose name is "Top Songs".
 * 
 * PS: There is an additional way to call the constructor of this class by passing the
 * name of the playlist and a list of songs to be stored in the playlist
 */

import java.util.ArrayList;
import java.util.List;

public class Playlist{
	
	private String name;
	private List<Song> contents;
	
	public Playlist(String name) {
		
		/*
		 * Purpose: This is the constructor of the Playlist class which creates a new
		 * playlist with the name that it is passed
		 * 
		 * @param
		 * name: A String representing the name of the playlist
		 */
		
		this.name = name;
		contents = new ArrayList<Song>();
	}
	
	public Playlist(String name, List<Song> contents) {
		
		/*
		 * Purpose: This is a different constructor of the Playlist class whcich creates
		 * a new playlist with the name passed in containing the list of songs that
		 * it received as a parameter
		 * 
		 * @param
		 * name: A String representing the name of the playlist being created
		 * contents: A list of Song objects that are to be contained in the playlist
		 */
		
		this.name = name;
		this.contents = contents;
	}
	
	public String getName() {
		
		/*
		 * Purpose: This is a simple getter method which returns the name of the playlist
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * name: A String representing the name of the playlist being referenced
		 */
		
		return name;
	}
	
	public void addSong(Song song) {
		
		/*
		 * Purpose: This method adds the specified song to the playlist
		 * 
		 * @param
		 * song: A Song object that is to be added to the current playlist
		 * 
		 * @return
		 * No return values
		 * 
		 */
		
		contents.add(song);
	}
	
	public void play() {
		
		/*
		 * Purpose: This method 'plays' each of the songs in the playlist. To play a
		 * song, a function call is being made to the toString() function for each of
		 * the songs
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * No return values
		 */
		
		for(Song each : contents) {
			System.out.println(each);
		}
	}
	
	public void removeSong(Song song) {
		
		/*
		 * Purpose: This function removes the song it has been passed if it exists in
		 * the playlist
		 * 
		 * @param
		 * The Song object that is to be removed
		 * 
		 * @return
		 * No return values
		 * 
		 */
		
		if(contents.contains(song)) {
			contents.remove(song);
		}
	}
}