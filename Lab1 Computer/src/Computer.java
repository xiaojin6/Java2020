import component.*;

public class Computer {
	private String name;
	private double price;
	
	private ICPU CPU;
	private IMemory memory;
	private IHDD HDD;
	private IMotherBoard motherBoard;

	public Computer(
			String name, 
			ICPU CPU, 
			IMemory memory, 
			IHDD HDD, 
			IMotherBoard MotherBoard, 
			double price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.CPU = CPU;
		this.memory = memory;
		this.HDD = HDD;
		this.motherBoard = MotherBoard;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void description() {
		CPU.description();
		memory.description();
		HDD.description();
		motherBoard.description();
	}
	
	public void work() {
		CPU.work();
		memory.work();
		HDD.work();
		motherBoard.work();
	}
	
	public ICPU getCPU() {
		return this.CPU;
	}
	
	public IMemory getMemory() {
		return this.memory;
	}
	
	public IHDD getHDD() {
		return this.HDD;
	}
	
	public IMotherBoard getMotherBoard() {
		return this.motherBoard;
	}

}
