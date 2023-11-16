package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Comparator {


    private List<Integer> userNumbers;
    private List<Integer> comNumbers;
    private List<Integer> result;
    private boolean flag;
    Comparator(List<Integer> userNumbers,List<Integer> comNumbers){
        flag =false;
        this.comNumbers=userNumbers;
        this.userNumbers=comNumbers;
        result=new ArrayList<>();
        compare();
    }
    private void compare(){
         int strikeCount = (int) IntStream.rangeClosed(0,userNumbers.size()-1)
                                        .filter(n->userNumbers.get(n).equals(comNumbers.get(n)))
                                        .count();
         int ballCount = (int) userNumbers.stream()
                 .filter(num->!comNumbers.get(userNumbers.indexOf(num)).equals(num))
                 .filter(comNumbers::contains).count();
         result.add(ballCount);
         result.add(strikeCount);
         if(strikeCount == 3) flag = true;
    }
    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
    public List<Integer> getComNumbers() {
        return comNumbers;
    }
    public List<Integer> getResult() {
        return result;
    }
    public boolean isFlag() {
        return flag;
    }
}
