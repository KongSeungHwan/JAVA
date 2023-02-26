package study10;

public class BeginnerLevel implements PlayerLevelInterface{
	public void run(){System.out.println("run slowly");}
	public void jump() {System.out.println("can't jump");}
	public void turn() {System.out.println("turn hardly");}
	public void showLevelMessage() {
		System.out.println("BeginnerLevel>>>>>>>");
	}
	public void hack() {System.out.println("hack^&*");}
	public void slash() {System.out.println("~slash--<>");}

}
