/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: User.java
 * ASSIGNMENT: Programming Assignment 4 - Capriottify
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a User object. It contains information to
 * initialize a User object and specific methods that are to be processed on a User
 * object. Each User contains a username, a password, a list of playlist objects and 
 * an integer that represents the number of playlists that the user has
 * 
 * 
 * EXAMPLE CALL TO THE USER CONSTRUCTOR:
 * User david = new User("David", "password");
 * 
 * This creates a new user whose username is "David" with the password "password" with
 * an empty list of playlists and the number of playlists set to 0
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class User{
	
	private String name;
	private String password;
	private List<Playlist> playlist;
	private int numPlaylists;
	
	public User(String name, String password) {
		
		/*
		 * Purpose: This is the constructor for the User class. This creates a new
		 * User with the username and password that it is given. The list of playlists
		 * is initialised to be empty and the number of playlists is set to 0
		 * 
		 * @param
		 * name: A String representing the username of the User
		 * password: The String that denotes the password of the user
		 */
		
		this.name = name;
		this.password = password;
		this.numPlaylists = 0;
		this.playlist = new ArrayList<Playlist>();
	}
	
	public String getName() {
		
		/*
		 * Purpose: This is a simple getter method that returns the username of the User
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * name: The String that contains the username of the object
		 */
		
		return name;
	}
	
	public boolean attemptLogin(String password) {
		
		/*
		 * Purpose: This function emulates a user login using a password. It returns
		 * true is the password is valid for the user, and false otherwise
		 * 
		 * @param
		 * password: The String representing the password attempt for logging in
		 * 
		 * @return
		 * A boolean value representing whether the password is valid for the user
		 */
		
		if(this.password.equals(password)) {
			return true;
		}
		return false;
	}
	
	public void addPlaylist(Playlist newPlaylist) {
		
		/*
		 * Purpose: This method simply adds a playlist to the existing list of playlists
		 * 
		 * @param
		 * newPlaylist: The playlist to be added to the user's list of playlists
		 * 
		 * @return
		 * No return values 
		 */
		
		playlist.add(newPlaylist);
		numPlaylists += 1;
	}
	
	public List<Playlist> getPlaylists(){
		
		/*
		 * Purpose: This function simply returns the list of playlists of the user
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * playlist: The list of playlists for a specific user
		 */
		
		return playlist;
	}
	
	public void selectPlaylist(String name) {
		
		/*
		 * Purpose: This method plays the playlist whose name is passed to it as an
		 * argument
		 * 
		 * @param
		 * name: A String representing the playlist which the user wants to play
		 * 
		 * @return
		 * No return values
		 */
		
		for(Playlist each : playlist) {
			if(each.getName().equals(name)) {
				each.play();
				return;
			}
		}
	}
	
	public String toString() {
		
		/*
		 * Purpose: This method returns a String representation of the User object
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * retval: A String representation of the User object
		 */
		
		String retval = name + ", " + numPlaylists + " playlists";
		return retval;
	}
}