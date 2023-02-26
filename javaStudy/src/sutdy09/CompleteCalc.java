package sutdy09;

public class CompleteCalc extends Calculator{
	public int times(int num1,int num2) {
		return num1*num2;
	}
	public double div(int num1,int num2) {
		if(num2==0) {
			return ERROR;
		} //분모가 0이면 불가능
		return num1/num2;
	}

}
