package test23_02_08;

import java.util.ArrayList;

public class Corperation {
	private String name;
	private ArrayList<Developer> developers; 
	//개발자들은 arrayList에 정보를 저장하여 소속되게 함(객체 배열)
	//private developers
	public Corperation(String name) {
		developers= new ArrayList<>();
		this.name =name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(ArrayList<Developer> developers) {
		this.developers = developers;
	}

	public void salayExpen() {
		int total = 0;
			for (Developer developer : developers) {
				System.out.printf(" %s의 연봉은 %d만원이여\n",developer.getName(),developer.salay());
				total+=developer.salay();
			}
			System.out.println();
			System.out.printf("총 지급액은??????>> %d 만원",total); 
			//억 단위로 넘어가면 처리를 해줘야하지만 그냥 안함

	}//향상된 for문으로 간단히 조회 출력문 부분을 지급하는 기능을 하는 메소드로 바꾸면 된다. 나중에
 	public void addDeveloper(Developer developer){
		developers.add(developer);
		System.out.printf("%s 님이 입사하었습니다. \n",developer.getName());
	} //ArrayList ver setter 메소드
 	
 	public Developer getDeveloper(int index){
		
 		return developers.get(index);
	}  //ArrayList ver getter 메소드
}
