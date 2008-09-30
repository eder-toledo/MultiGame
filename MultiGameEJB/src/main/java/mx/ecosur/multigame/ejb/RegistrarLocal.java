/*
* Copyright (C) 2008 ECOSUR, Andrew Waterman and Max Pimm
* 
* Licensed under the Academic Free License v. 3.0. 
* http://www.opensource.org/licenses/afl-3.0.php
*/

/**
 * The RegistrarLocal interface is the local interface for the
 * registrar EJB.  
 * 
 * @author awaterma@ecosur.mx
 *
 */

package mx.ecosur.multigame.ejb;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Local;

import mx.ecosur.multigame.Color;
import mx.ecosur.multigame.GameType;
import mx.ecosur.multigame.ejb.entity.Game;
import mx.ecosur.multigame.ejb.entity.GamePlayer;
import mx.ecosur.multigame.ejb.entity.Player;
import mx.ecosur.multigame.exception.InvalidRegistrationException;



@Local
public interface RegistrarLocal {
	
	/**
	 * Registers a player with the system, returning a color from the
	 * available list of colors, and registering the Player with the game
	 * of the specified type.  This method throws an exception when a specific
	 * player has already been registered, or if the type of game no longer 
	 * takes any players.
	 * 
	 * @param player, color, type
	 * @return GamePlayer
	 * @throws InvalidRegistrationException 
	 * @throws RemoteException 
	 */
	public GamePlayer registerPlayer (Player player, Color color, GameType type) 
		throws InvalidRegistrationException;
	
	/**
	 * Unregisters a player from the system (when the Player quits playing 
	 * the game).
	 * 
	 * @param player
	 * @throws InvalidRegistrationException 
	 * @throws RemoteException 
	 */
	public void unregisterPlayer (GamePlayer player) throws 
		InvalidRegistrationException;
	
	/**
	 * Method to find the available token colors based on the gametype 
	 * requested.
	 * 
	 * @param type 
	 * @return A list of Colors that are still available
	 */
	public List<Color> getAvailableColors (Game game) throws 
		RemoteException;
	
	/**
	 * Locates a player 
	 * @throws RemoteException 
	 * 
	 */
	public Player locatePlayer (String name);
	
	/**
	 * Attempt to locate an unfinished game of a given type and player. If no
	 * such game is found a game that requires more players to begin is searched
	 * for. If no game is found new game is created and returned.
	 * 
	 * @param player
	 *            the player to register
	 * @param type
	 *            the type of game
	 * @return the game.
	 * @throws RemoteException
	 */
	public Game locateGame (Player player, GameType type);
	
}
