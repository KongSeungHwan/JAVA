package study07;

public class Manager {
	static int seqNum2 = 2000;
	private int managerId;
	private String managerName;
	
	public Manager(String name){
		
		managerName = name;
		managerId=seqNum2++;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	//getter/setter
	
}
