package component.impl;

public class AMDCPU extends CPU{
	
	public AMDCPU(String name, int coreNum, double price) {
		this.setCoreNum(coreNum);
		this.setName(name);
		this.setPrice(price);
	}

}
