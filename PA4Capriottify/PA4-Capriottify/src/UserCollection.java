/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: UserCollection.java
 * ASSIGNMENT: Programming Assignment 4 - Capriottify
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to represent a UserCollection object. It contains 
 * information to initialize a UserCollection object and specific methods that are to be 
 * processed on a UserCollection object. Each UserCollection object has a set that 
 * contains all the users of Capriottify
 * 
 * 
 * EXAMPLE CALL TO THE USERCOLLECTION CONSTRUCTOR:
 * UserCollection coll = new UserCollection();
 * 
 * This creates a new UserCollection that has no Users, that is, it is empty
 */

import java.util.HashSet;
import java.util.Set;

public class UserCollection {
	
	private Set<User> users;
	
	public UserCollection() {
		
		/*
		 * Purpose: This is the constructor for the UserCollection class. This 
		 * initializes an empty set containing that will contain all the users
		 * 
		 * @param
		 * No parameters
		 */
		
		users = new HashSet<User>();
	}
	
	public boolean userExists(String username) {
		
		/*
		 * Purpose: This method checks whether a user with a certain username exists
		 * in the user collection
		 * 
		 * @param
		 * username: A String depicting the username of the user that needs to be found
		 * 
		 * @return
		 * A boolean value that specifies whether the user exists in the collection
		 * or not
		 */
		
		for(User each : users) {
			if(each.getName().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	public User login(String username, String password) {
		
		/*
		 * Purpose: This method emulates a User trying to log in to the program. It 
		 * returns the User associated with the login credentials if it was a valid
		 * login or returns null if the login was invalid
		 * 
		 * @param
		 * It takes in the username and the password of the user trying to login
		 * 
		 * @return
		 * returns the User object if the username asnd password are valid, else 
		 * returns null
		 */
		
		User curr = null;
		if(userExists(username)) {
			for(User each : users) {
				if(each.getName().equals(username)) {
					curr = each;
					break;
				}
			}
			if(curr.attemptLogin(password)) {
				return curr;
			}
		}
		return null;
	}
	
	public void addUser(User add) {
		
		/*
		 * Purpose: This method adds a user to the existing collection of users
		 * 
		 * @param
		 * The User object that needs to be added to the collection
		 * 
		 * @return
		 * No return values
		 */
		
		if(!userExists(add.getName())) {
			users.add(add);
		}
	}
	
	public String toString() {
		
		/*
		 * Purpose: This method is used to create a String representation of the
		 * UserCollection class
		 * 
		 * @param
		 * No parameters
		 * 
		 * @return
		 * retval: A String containing all the users of the application
		 */
		
		String retval = "{";
		for(User each : users) {
			retval+=each.toString() + ", ";
		}
		if(!retval.equals("{")) {
			retval.substring(0, retval.length()-2);
		}
		return retval + "";
	}
}