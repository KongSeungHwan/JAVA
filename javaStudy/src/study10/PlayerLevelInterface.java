package study10;

public interface PlayerLevelInterface{ 
	//레벨에 따라 무엇으로 차별점을 둘 것인가 (레벨마다 기능을 달리해야하는 것들)
	void run();
	void jump();
	void turn();
	void showLevelMessage();
	void hack();
	void slash();
	default void go(int count) {
		run();
		jump();
		for (int i = 0; i <count; i++) {
			hack();
			slash();
			System.out.println();
		}
		turn();
	}//디폴트 메소드

}
