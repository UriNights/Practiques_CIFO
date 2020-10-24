package model;

import java.awt.Point;

public class Player {

	private Point position;
	private int battery;
	
	public Player() {
		this.position = new Point();
		this.battery = 14;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
}
