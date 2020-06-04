/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: Song.java
 * ASSIGNMENT: Programming Assignment 4 - Capriottify
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a Song object. It contains information to
 * initialize a Song object and specific methods that are to be processed on a Song
 * object. Each song contains a title, the name of the artist, and the number of times
 * it has been played
 * 
 * 
 * EXAMPLE CALL TO THE SONG CONSTRUCTOR:
 * Song newHit = new Song("Rap God", "Eminem");
 * 
 * This creates a new song with the title "Rap God" whose artist is "Eminem" with the
 * number of times the song has been played equal to 0
 * 
 */

public class Song{
	
	private String title;
	private String artist;
	private int played;
	
	public Song(String title, String artist) {
		
		/*
		 * Purpose: This is the constructor of the Song class which creates a new Song with 
		 * the title and the name of the artist passed in as parameters
		 * 
		 * @param
		 * title: The title of the Song being created
		 */
		
		this.title = title;
		this.artist = artist;
		// When a new Song is initialized, the number of times it has been played is 0
		played = 0; 
	}
	
	public String getTitle() {
		
		/*
		 * Purpose: A getter method to access the title of the Song
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * title: A String representing the title of the Song
		 */
		
		return this.title;
	}
	
	public String getArtist() {
		
		/*
		 * Purpose: A getter method to access the artist of the Song
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * artist: A String representing the artist of the Song
		 */
		
		return this.artist;
	}
	
	public int getTimesPlayed() {
		
		/*
		 * Purpose: A getter method to access the number of times the song has been played
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * played: An integer representing the number of times the song has been played
		 */
		
		return played;
	}
	
	public void play() {
		
		/*
		 * Purpose: A method that 'plays' the song, i.e., it prints out a description
		 * of the song and increments the number of times it has been played by 1
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * No return values
		 */
		
		System.out.println(this.toString());
		played += 1;
	}
	
	public String toString() {
		
		/*
		 * Purpose:A method that returns a String representation of the Song object
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * retval: A String representing the Song object being referenced
		 */
		
		String retval = title + " by " + artist + ", " + played + "play(s)";
		return retval;
	}
}