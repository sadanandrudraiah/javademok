package com.cruds.constructor;

class Vehicle {
	int wheels;
	int headlight;
	Vehicle(int wheels) {
		this.wheels = wheels;
		
	}
	
	Vehicle(int wheels, int headlight){
		this.wheels = wheels;
		this.headlight = headlight;
	}
}

public class IntroConstructor {
	
	public static void main(String[] args){
		Vehicle auto = new Vehicle(3);
		Vehicle car = new Vehicle(4, 2);
		Vehicle bike = new Vehicle(2);
		System.out.println(auto.wheels + " wheels");
		System.out.println(car.wheels + " wheels" +"," + car.headlight + " headlight");
		System.out.println(bike.wheels + " wheels");
	
	}

}
