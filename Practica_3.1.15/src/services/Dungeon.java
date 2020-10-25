package services;

import java.util.ArrayList;
import java.util.Arrays;

import helpers.RandomOutput;
import model.Player;
import model.Vampire;

public class Dungeon {

	private final int width;
	private final int height;
	private final Player player;
	private ArrayList<Vampire> vampires;

	public Dungeon(int width, int height, int dificulty) {
		this.width = width;
		this.height = height;

		this.player = new Player(); // Battery for player torch is always the same = 14 turns

		this.vampires = this.createVampires(dificulty);
	}

	private ArrayList<Vampire> createVampires(int dificulty) {

		// First create an array list of positions (int) with ascending sort, then assign every position to a vampire.

		ArrayList<Vampire> vampires = new ArrayList<>();
		for (int position : RandomOutput.newPositionsArray(this.getNumberOfVampires(dificulty),
				this.width * this.height)) {
			vampires.add(new Vampire(position));
		}

		return vampires;
	}

	private int getNumberOfVampires(int difficulty) {

		// Difficulty represent a percentage of "map" for vampires. Where 1 is 10% (minimum difficulty) and 5 is 50% (maximum difficulty);

		return (int) Math.round(this.width * this.height * (difficulty * 0.1));
	}

	public boolean movePlayerAndKill(String commands) {

		int newPosition = this.player.getPosition();
		boolean outOfBoard = false;
		for (char keyInput : commands.toCharArray()) {

			switch (keyInput) {
			
				case 'w':
					newPosition -= this.width;
					if (newPosition < 0) outOfBoard = true;
					break;
					
				case 's':
					newPosition += this.width;
					if ((this.width * this.height) - 1 < newPosition) outOfBoard = true;
					break;
					
				case 'a':
					if (newPosition == 0 || this.width - 1 < newPosition && newPosition % this.width == 0) outOfBoard = true;
					newPosition--;
					break;
					
				case 'd':
					if (newPosition == this.width - 1 || this.width - 1 < newPosition && newPosition % this.width == this.width - 1) outOfBoard = true;
					newPosition++;
					break;
					
				default:
					break;
			}

			if (outOfBoard) return false;
		}

		this.player.move(newPosition);
		this.killVampire(newPosition);
		
		return true;
	}
	
	private void killVampire(int playerPosition) {
		
		int i = 0;
		while (i < vampires.size()) {
			
			if (playerPosition == vampires.get(i).getPosition()) {
				vampires.remove(i);
				break;
			}
			
			i++;
		}
	}
	
	public void moveVampires() {
		// TODO Auto-generated method stub
		
	}
	
	public int gameState() {		// 1 = you win ; 0 = game continues ; -1 = you lose

		if (vampires.isEmpty()) return 1;
		if (!player.hasBattery() || player.getBattery() < vampires.size()) return -1;
		return 0;
	}
		
	public String toString() {

		char[] charGameBoard = new char[this.width * this.height]; // Create char array with total positions length, and filled with '.'
		Arrays.fill(charGameBoard, '.');

		charGameBoard[this.player.getPosition()] = '@'; // Player position

		for (Vampire vampire : this.vampires) { // Vampires position
			charGameBoard[vampire.getPosition()] = 'v';
		}

		// Add line breaks into the specified width

		StringBuilder gameBoard = new StringBuilder(String.valueOf(charGameBoard));
		for (int i = 0; i <= this.height; i++) {
			gameBoard.insert((this.width + 1) * i, "\n");
		}

		return gameBoard.toString();
	}

	
	// Getters and Setters

	public ArrayList<Vampire> getVampires() {
		return vampires;
	}

	public void setVampires(ArrayList<Vampire> vampires) {
		this.vampires = vampires;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Player getPlayer() {
		return player;
	}
}
