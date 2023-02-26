package study10_3;

public class TVRun {
	public static void main(String[] args) {
		ColorTV ctv = new ColorTV(32,1920,1024);
		ctv.printProperty();
		//필드 하나더 추가 가로,세로 픽셀 단위로 주사율 표기! 
		System.out.println();
		System.out.println("getter 메소드를 사용하여 따로 접근하여 출력");
		System.out.printf("해당 tv %d인치 \n",ctv.getSize());
		System.out.printf("%d x %d \n",ctv.getResolutionWidth(),ctv.getResolutionHeight());
		//getter setter 메소드로 접근하여 따로 출력!
		IPTV iptv = new IPTV("192.1.1.4",64,2048,2048); //난 가로세로 해상도로 함.
		System.out.println();
		iptv.printProperty(); //iptv 오버라이딩한 함수 호출~! 가상메소드 기능

	}
}
