package study07;

public class VipCustomer extends Customer {
	private double saleRatio;
	private Manager manager;
	
	public VipCustomer(String customerName,String managerName) {
		super(customerName);
		// 오버로딩은 매개변수 개수 , 자료형, 순서로 구분(생성자도 마찬가지 왜냐 생성자도 메소드니까)
		customerGrade = "VIP";
		bonusRatio = 0.05;//5%의 보너스 할인율
		saleRatio =0.1;//10%의 할인율
		manager=new Manager(managerName);
		System.out.println("VIPcustomer 생성자");
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint +=price*bonusRatio;
		return price-(int)(price*bonusRatio);
	}

	@Override
	public String getCustomerInfo() {
		return super.getCustomerInfo()+"매니저:"+manager.getManagerName();
	}
	public Manager getManager() {
		return manager;
	}
	

}
