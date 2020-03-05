package component.impl;

import component.IHDD;

public abstract class HDD implements IHDD{
	private String name;
	private int volume;
	private double price;
	
	public HDD() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void work() {
		System.out.println("Hard Disk Driver Work");
	}
	
	@Override
	public void description() {
		System.out.println("Hard Disk Driver: " + this.getName());
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public double getPrice() {
		return this.price;
	}
}
