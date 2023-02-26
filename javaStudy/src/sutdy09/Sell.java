package sutdy09;

public interface Sell { //인터페이스는 그러면 저렇게 한 행위에 대해 만들면 되는 것인가?
	//implements 키워드 활용
	
	 void sell();
	  default void order(){
		  System.out.println("판매완료");
	  }

}
