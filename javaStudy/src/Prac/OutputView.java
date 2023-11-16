package baseball;

import java.util.List;

public class OutputView {
    OutputView(Comparator comparator){
        printResult(comparator.getResult());
    }
    private void printResult(List<Integer> result){
        int ballCount= result.get(0);
        int strikeCount= result.get(1);
        if(ballCount>=1)System.out.printf("%d볼",ballCount);
        if(strikeCount>=1)System.out.printf("%d스트라이크",strikeCount);
        if(strikeCount==3)System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println();
    }

}
