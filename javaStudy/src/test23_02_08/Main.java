package test23_02_08;

public class Main {
	public static void main(String[] args) {
		Corperation corp = new Corperation("Google");
		corp.addDeveloper(new Developer("Tom",5));
		corp.addDeveloper(new Developer("james",8));
		corp.addDeveloper(new Developer("james",1));
		corp.addDeveloper(new Developer("kate",4));
		corp.addDeveloper(new Developer("paul",10));
		//앞에 싹다 회사원 넣고
		System.out.println();
		System.out.println();
		System.out.printf("%s의 연봉은 %d 이다.\n",corp.getDeveloper(0).getName(),corp.getDeveloper(0).salay());
		System.out.printf("%s의 연봉은 %d 이다. \n",corp.getDeveloper(1).getName(),corp.getDeveloper(1).salay());//연봉 계산기
		System.out.println();
		corp.salayExpen();// 연봉 책정하기!
	}

}
