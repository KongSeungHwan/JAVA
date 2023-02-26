package study21;

public class Car {
	private String name;
	private int carNum;
	
	Car(String n , int i){
		name = n;
		carNum = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
	

}
