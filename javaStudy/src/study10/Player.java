package study10;

public class Player {
	private PlayerLevelInterface level;//인터페이스를 참조형으로 바꿔 다형성을 이용해서 beginner,advanced,super level로 변환함.
	
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	public PlayerLevelInterface getLevel() {
		return level;
	}
	public void levelUp() {
		if(level instanceof BeginnerLevel) {
			level =new AdvancedLevel();
		}else if(level instanceof AdvancedLevel) {
			level = new SuperLevel();
		}
		level.showLevelMessage();
	}
	public void play(int count) {
		level.go(count);
	}
}
