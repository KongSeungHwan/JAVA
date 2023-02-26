package study10_3;

public class StringStack implements Stack{  
	//문자열 한정 스택(String 한정 스택)
	private String[] stack; //문자열 배열을 선언만 해놓음
	private int top;//스택의 가장 위의 원소 인덱스를 뜻함(리턴 가능)
	
	
	public StringStack(int capacity) {
		stack = new String[capacity];
		top = -1;
	} //맨 아래 원소를 -1로 함으로 이를 이용하여 스택이 비어있거나 차 있는것을 알아내는 포인터 

	public int length(){
		
		return top+1;
	}


	public int capacity(){
		return stack.length;
	}//배열의 전체 길이


	public String pop(){
		if(top==-1) return null; 
		//생성자에 해놓았던 맨 아래 원소인 -1 값이 나오게 되면 스택이 비어있음을 나타내어 null값을 리턴 
		String str = stack[top];
		top--;
		return str;
	}


	public boolean push(String value) {
		if(top ==stack.length-1) {
			return false;
		}else {
			//가득 안 찬 경우
			top++;
			stack[top] = value;
			return true;
		}
	} //값을 넣음과 동시에 boolean값을 리턴하도록 설계
	
	

}
