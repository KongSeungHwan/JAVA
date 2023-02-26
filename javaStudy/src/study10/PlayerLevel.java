package study10;

public abstract class PlayerLevel implements PlayerLevelInterface{ 
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	public abstract void hack();
	public abstract void slash();
	
	public final void go(int count) { //템플릿 메소드(final 키워드 사용) 
		run();
		jump();
		for (int i = 0; i <count; i++) {
			hack();
			slash();
			System.out.println();
		}
		turn();
	}
}
