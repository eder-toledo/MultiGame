/**
 * 
 */
package mx.ecosur.multigame.ejb.entity.pente;

import javax.persistence.Entity;

import mx.ecosur.multigame.Color;
import mx.ecosur.multigame.ejb.entity.Game;
import mx.ecosur.multigame.ejb.entity.GamePlayer;
import mx.ecosur.multigame.ejb.entity.Player;
import mx.ecosur.multigame.pente.BeadString;

import java.util.HashSet;

/**
 * @author awater
 *
 */

@Entity
public class PentePlayer extends GamePlayer {
	
	private int points;
	
	private HashSet<BeadString> trias;
	
	private HashSet <BeadString> tesseras;
	
	public PentePlayer () {
		super ();
		trias = new HashSet<BeadString> ();
		tesseras = new HashSet<BeadString> ();
	}
	
	public PentePlayer(Game game, Player player, Color favoriteColor) {
		super (game, player, favoriteColor);
		points = 0;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public HashSet<BeadString> getTrias() {
		return trias;
	}

	public void setTrias(HashSet<BeadString> trias) {
		this.trias = trias;
	}
	
	public void addTria (BeadString tria) {
		if (tria.size() == 3)
			trias.add (tria);
	}

	public HashSet<BeadString> getTesseras() {
		return tesseras;
	}

	public void setTesseras(HashSet<BeadString> tesseras) {
		this.tesseras = tesseras;
	}
	
	public void addTessera (BeadString tessera) {
		if (tessera.size() == 4)
			tesseras.add(tessera);
	}
}
