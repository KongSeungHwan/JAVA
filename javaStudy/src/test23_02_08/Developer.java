package test23_02_08;

public class Developer {
	private String name;
	private int career;

	public Developer(String name, int career) {
		this.name =name;
		this.career=career;
	}

	public void level(Developer developer){
		if((developer.getCareer()>=0)&&(developer.getCareer()<3)) {
			System.out.println("당신은 초급개발자 입니다.");
		}else if((developer.getCareer()>=3)&&(developer.getCareer()<7)) {
			System.out.println("당신은 중급개발자 입니다.");
		}else if(developer.getCareer()>=7){
			System.out.println("당신은 고급개발자 입니다.");
		}else {
			System.out.println("경력은 음수가 될 수 없습니다. 다시 입력해주세요.");//예외 처리
		}
	}//리턴 값하고 출력문 차이겄지 뭐
	public int salay(){
		if((getCareer()>=0)&&(getCareer()<3)) {

			return 2800+(100*getCareer());
		}
		else if((getCareer()>=3)&&(getCareer()<7)) {

			return 3500+(100*getCareer());
		}
		else if(getCareer()>=7) {
			return 4500+(100*getCareer());
		}else {
			return 0;
		}

	}
	//메인 메소드 잠깐 보여주신 대로 출력 함수에 드가면 나오게끔 구성(리턴값이 나오도록)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}


}
