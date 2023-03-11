package javaStudy;

public class Loop {

	public static void main(String[] args) {

		int num = 1;//초기화
		int sum = 0;
		while(num<=10) { //조건식
			sum+=num;
			num++; // 증감식
		}
		System.out.println("합계:"+sum);
		sum=0;//초기화
		num=1;
		do {
			sum+=num;
			num++;//증감식
		}while(num<=10);//조건식
		System.out.println("합계:"+sum);
		sum=0; //초기화
		for(int i = 1; i<=10;i++) {
			sum+=i;
		}
		System.out.println("합계:"+sum);

		for(int dan=2; dan <=9; dan++) {
			System.out.println();
			for(int t=1; t <=9; t++) {
				System.out.printf("%dx%d=%d ",dan,t,dan*t);
				if(dan*t/10<=0) {
					System.out.printf(" ");
				}
			}
		}
		//for문으로 구구단 정렬
		num=2;
		sum=1;


		System.out.println();
		System.out.println();
		System.out.println();
		while(num<=9){
			System.out.println();
			sum =1;
			while(sum<=9){
				System.out.printf("%dx%d=%d ",num,sum,num*sum);
				if(num*sum/10==0) {
					System.out.printf(" ");
				} 
				sum++;
			}
			num++;
		}
		//while 문으로 구구단 정렬
		System.out.println();
		System.out.println();
		num=2;
		sum=1;

		do{
			sum = 1;
			do{
				System.out.printf("%dx%d=%d ",num,sum,num*sum);
				if(num*sum/10==0) {
					System.out.printf(" ");
				}
				sum++;
			}while(sum<=9);
			num++;
			System.out.println();
		}while(num<=9); //do while 문으로 구구단 정렬

		for(int i = 0; i<10 ; i++) {
			System.out.printf("%d \n",i);
		}


		for(int i = 0;i<10;i++) {
			if(i==4) {
				break;
			}
			System.out.println(i);
		}//if문으로 변수 i가 4일 경우 break문을 실행하는 형태


		for(int i = 0;i<10;i++) {
			if(i==4) {
				continue;
			}
			System.out.println(i);
		}//if문으로 변수 i가 4일 경우 continue문을 실행하는 형태

		sum=0;
		for(int i = 0;i<=100;i++) {
			sum+=i;
		}
		System.out.printf("1~100까지의 합은 %d이다. \n",sum);
		sum=0;
		for(int i = 1;i<=100;i++) {
			if(i%2==0) {
				sum+=i;
			}
		}
		System.out.printf("1~100까지의 짝수 합은 %d이다. \n",sum);

		sum=0;
		for(int i = 1;i<=100;i++) {
			if(i%2==1) {
				sum+=i;//continue문으로도 짝수 또는 홀수 스킵 가능.
			}
		}
		System.out.printf("1~100까지의 홀수 합은 %d이다. \n",sum);
		sum =0;
		for(int i = 2;i<=100;i+=2) {
			sum+=i;
		}//짝수
		System.out.printf("1~100까지의 짝수 합은 %d이다. \n",sum);
		//증감식에 꼭 ++ 쓸필요 없고 +=x(x는 숫자) 가능.
		sum = 0;
		num = 0;
		while(num<=100){
			sum+=num;
			if(sum>100) {
				break;//continue문을 쓰면 비효율적이라 break문 씀. 동작 횟수 줄임
			}
			num++;
		}
		System.out.printf("100을 넘을 때 합, 숫자: %d, %d",sum,num);

		out:
		for(int dan=2; dan <=9; dan++) {
			if(dan!=5)System.out.println();
			for(int t=1; t <=9; t++) {
				if(dan ==5)break out;
				System.out.printf("%dx%d=%d ",dan,t,dan*t);
				if(dan*t/10<=0) {
					System.out.printf(" ");
				}
			}
		}//break문을 사용하여 2중 for문중 t가 포함된 for문을 나와 다음 횟수로 넘어가는 형태
		//out:~ out; 활용법 4단까지만 나옴 if문으로 break 거는 것보다 코드 수가 적어 활용도 좋음
	}//메인 메소드 괄호

}

