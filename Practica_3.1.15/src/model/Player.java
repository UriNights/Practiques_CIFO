package model;

public class Player {

	private int position;
	private int battery;
	
	public Player() {
		this.position = 0;
		this.battery = 14;
	}
	
	public void move(int newPosition) {
		this.position = newPosition;	
		this.battery--;
	}
	
	public boolean hasBattery() {
		if (0 < this.battery) return true;
		return false;
	}
	
	
	// Getters and Setters

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
}
