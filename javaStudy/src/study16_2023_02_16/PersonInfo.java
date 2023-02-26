package study16_2023_02_16;

public class PersonInfo {
	private String name;
	private String address;
	
	PersonInfo(String n,String ad){
		name=n;
		address=ad;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
