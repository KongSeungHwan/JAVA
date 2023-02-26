package stat;

public class Stat {

	public static void main(String[] args) {
		 RandomNumber randomNum = new RandomNumber();
	      InputNumber input = new InputNumber();
	      System.out.println(input.t);
	      input.t=50;
	      System.out.println(InputNumber.t);
	      InputNumber.t=100;
	      System.out.println(input.t);
	      System.out.println(RandomNumber.t);
	      
	}

}
