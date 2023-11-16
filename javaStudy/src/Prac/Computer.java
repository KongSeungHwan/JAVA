package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {


    private List<Integer> numbers;
    Computer(){
        numbers= new ArrayList<>();
        createNumber();
    }
    private void createNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        numbers=computer;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
