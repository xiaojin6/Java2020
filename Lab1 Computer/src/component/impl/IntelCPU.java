package component.impl;

public class IntelCPU extends CPU{

	public IntelCPU(String name, int coreNum, double price) {
		this.setCoreNum(coreNum);
		this.setName(name);
		this.setPrice(price);
	}
	
}
