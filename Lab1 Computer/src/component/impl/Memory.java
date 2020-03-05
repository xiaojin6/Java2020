package component.impl;

import component.IMemory;

public abstract class Memory implements IMemory{

	private String name;
	private int volume;
	private double price;
	
	public Memory() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void work() {
		System.out.println("Memory work");
	}
	
	@Override
	public void description() {
		System.out.println("Memory: " + this.getName());
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
