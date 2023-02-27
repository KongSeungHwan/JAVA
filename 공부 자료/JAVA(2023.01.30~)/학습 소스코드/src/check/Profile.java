package check;

public class Profile {
	public static void main(String[] args) {
		String name = "홍길동";
		long stuId= 2018122104L;
		double height = 1.78;
		boolean gender = true;
		if(gender) {
			System.out.printf("이름:%s,학번:%d,신장: %fm,성별: 남성",name,stuId,height);


		}	
		else {
			System.out.printf("이름:%s,학번:%d,신장: %fm,성별: 남성",name ,stuId,height,gender);
			
			//argument가 넘어가면? 오류는 없음 format이 넘어가도 오류는 없음
			//
		}
	}

}
