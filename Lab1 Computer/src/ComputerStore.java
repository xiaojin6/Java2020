import component.*;
import component.impl.*;

public class ComputerStore {
	
	public static void show(Computer[] computer) {
		for(int i = 0; i < computer.length; i++) {
			System.out.println(computer[i].getName() + ":");
			computer[i].description();
			System.out.println("Price: " + computer[i].getPrice());
			computer[i].work();
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		ICPU intel = new IntelCPU("Intel", 4, 600);
		ICPU amd = new AMDCPU("AMD", 4, 650);
		
		IMemory kingston = new KingstonMemory("Kingstion", 8, 400);
		IMemory samsung = new SamsungMemory("Samsung", 8, 430);
		
		IHDD seagate = new SeagateHDD("Seagate", 1024, 300);
		IHDD westDigitals = new WestDigitalsHDD("WestDigitals", 1024, 320);
		
		
		IMotherBoard gigabyte = new GigabyteMotherBoard("Gigabyte", 80, 600);
		IMotherBoard asus = new AsusMotherBoard("Asus", 83, 650);
		
		Computer[] computers = new Computer[3];
		computers[0] = new Computer("computer1", intel, kingston, seagate, gigabyte, 1900);
		computers[1] = new Computer("computer2", amd, samsung, westDigitals, asus, 2050);
		computers[2] = new Computer("computer3", intel, samsung, westDigitals, asus, 2000);
		
		show(computers);
		
	}
}
