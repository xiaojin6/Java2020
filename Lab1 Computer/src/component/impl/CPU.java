package component.impl;

import component.ICPU;

public abstract class CPU implements ICPU{
	
	private String name;
	private int coreNum;
	private double price;

	public CPU() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void work() {
		System.out.println("CPU work");
	}
	
	@Override
	public void description() {
		System.out.println("CPU: " + this.getName());
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setCoreNum(int coreNum) {
		this.coreNum = coreNum;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCoreNum() {
		return this.coreNum;
	}
	
	public double getPrice() {
		return this.price;
	}

}
