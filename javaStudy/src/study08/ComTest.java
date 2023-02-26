package study08;

public class ComTest {

	public static void main(String[] args) {
		PortableNoteBook no = new PortableNoteBook();
		no.display();
		no.typing();
		Desktop de = new Desktop();
		de.display();
		de.typing();
		//추상클래스는 오로지 상속만을 위해 존재하는 클래스이므로 생성 못함. Computer,NoteBook(추상 클래스)로 생성 못함
		//둘다 상속 받은 클래스가 달라 결과 값이 다를 것이다.
		//Desktop같은 경우는 추상 클래스인 computer에서 상속 받아 display,typing 둘 다 구현했지만
		//PortableNoteBook같은 경우는 computer에서 NoteBook(추상 클래스)로 상속을 받고 display만 구현한 채로 다시 Portable NoteBook으로 상속을 하여
		//Portable NoteBook에서 typing을 구현했다. 즉 추상하는 경로에따라 추상 메서드의 결과 값이 달라짐!
		//객체 생성 방식은 
		//1. 자식 클래스를 생성하면서 함께 만드는 방법
		//2. 내부 클래스를 이용하여 메인 메소드에서 구현하여 생성하는 법
		Computer com = new Desktop(); //computer 자료형인 com에 Desktop자료형의 객체를 넣었으니 업 캐스팅
		Computer com2 = new Computer(){ //구현되지 않은 메소드 typing을 메인 메소드에서 구현하기(내부 클래스)
			public void typing() {
				System.out.println("익명 내부 클래스");
			}
		};
		com2.typing();
		com.display();
		com.typing();
		com.turnOn();
		com.turnOff();
		Computer com3 = new PortableNoteBook();
		NoteBook note = new PortableNoteBook();
		com3.display();
		note.display();
		com3.typing();
		note.typing();
		
	}

}
