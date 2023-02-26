package study10;

public class SuperLevel implements PlayerLevelInterface{
	public void run(){System.out.println("hyper run!");}
	public void jump() {System.out.println("hyper jump!");}
	public void turn() {System.out.println("quick turn!");}
	public void showLevelMessage() {
		System.out.println("SuperLevel>>>>>>>");
	}
	public void hack() {System.out.println("<<<hack>>>");}
	public void slash() {System.out.println("<><><>slash<><><>");}

}
