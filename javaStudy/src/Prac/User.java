package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {


    private List<Integer> userNumber;
    User(String number){
        userNumber = new ArrayList<>();
        convertNumber(number);
    }
    private void convertNumber(String number){
        userNumber = Arrays.stream(number.split(""))
                .mapToInt(num->Integer.parseInt(num)).boxed().toList();
    }
    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
