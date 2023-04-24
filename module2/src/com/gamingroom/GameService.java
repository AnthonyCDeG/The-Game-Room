package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton 
	
	
	//private static stores the instance of GameService even if it doesn't exist
	private static GameService service = null;
	
	//An empty constructor that may need to be modified later
	private GameService() {}
	
	//Singleton that checks to make sure if there is an instance of GameService already created.
	//If there isn't a new one will be created. If there is one already it returns the one that is created.
	public static GameService getInstance() {
		
		if (service == null) {
			service = new GameService();
		}
		
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		//Iterates through names of each game and finds ones with the same name.
		//If found, program will return the existing instance.
		if (getGame(name)!= null) {
			game = getGame(name);
		}
		// if found, simply return the existing instance

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Looks through instances of games to check for the game id
		for (int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getId() == id) {
				game = games.get(i);
			}
		}
		// if found, simply assign that instance to the local variable

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		//Iterates through games to see if the name exists
		for (int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getName() == name) {
				game = games.get(i);
			}
		}
		
		// if found, simply assign that instance to the local variable

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
