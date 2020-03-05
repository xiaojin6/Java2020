package component.impl;

import component.IMotherBoard;

public abstract class MotherBoard implements IMotherBoard{

	private String name;
	private int speed;
	private double price;
	
	public MotherBoard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work() {
		System.out.println("MotherBoard work");
	}
	
	@Override
	public void description() {
		System.out.println("MotherBoard: " + this.getName());
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public double getPrice() {
		return this.price;
	}
}
