package services;

import java.awt.Point;
import java.util.ArrayList;

import helpers.RandomOutput;
import model.Player;
import model.Vampire;

public class Dungeon {
	
	private int width;
	private int height;
	private Player player;
	private ArrayList<Vampire> vampires;

	public Dungeon(int width, int height, int dificulty) {
		this.width = width;
		this.height = height;
		
		this.player = new Player();		// Battery for player torch is always the same = 14 turns
		
		this.vampires = this.createVampires(dificulty);
	}
	
	private ArrayList<Vampire> createVampires(int dificulty) {
		
		// First create an array list of Points, then assign every point to a vampire.
		
		ArrayList<Vampire> vampires = new ArrayList<>();
		for (Point point : RandomOutput.createPointsList(this.getNumberOfVampires(dificulty), this.width, this.height)) {
			vampires.add(new Vampire(point));
		}
			
		return vampires;
	}

	private int getNumberOfVampires(int difficulty) {
		
		// Difficulty represent a percentage of "map" for vampires. Where 1 is 10% (minimum difficulty) and 5 is 50% (maximum difficulty);
		
		return Math.round((float) this.width * this.height / (difficulty * 10));
	}
}
