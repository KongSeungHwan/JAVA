package study22;

import java.util.function.Predicate;

public class PredicateRun {

	public static void main(String[] args) {
		Predicate<Integer> p = new Predicate<>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t>3;
			}
		};
		Predicate<Integer> p1 = x -> x>3;//람다식으로 표현
	}

}
