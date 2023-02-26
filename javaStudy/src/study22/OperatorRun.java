package study22;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorRun {

	public static void main(String[] args) {
		UnaryOperator<Double> o = new UnaryOperator<>() {
			@Override
			public Double apply(Double t) {
				return t*12.3;
			}
		}; //파라미터 1개
		UnaryOperator<Double> o1 = x -> x*12.3;//람다식으로 표현
		BinaryOperator<String> b = new BinaryOperator<>() {

			@Override
			public String apply(String t, String u) {
				return t+u;
			}
		};//파라미터 2개
		BinaryOperator<String> b1 = (x,y) -> x+y; //람다식으로 표현
	}
}
