package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

//사용자 입력값을 입력받는 클래스
public class InputView {
    private String input;



    private String exitFlag;
    InputView(){
        input = readNumber();
    }
    private String readNumber(){
        boolean flag = false;
        String input = "";
        while(!flag) {
            System.out.println("숫자를 입력해주세요 :");
            input = Console.readLine();
            flag = validateInput(input);
        }
        return input;
    }
    private boolean validateInput(String input){
        try{
            if(Arrays.stream(input.split("")).mapToInt(e->Integer.parseInt(e)).filter(e->e!=0).count()!=3) throw new IllegalArgumentException();
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }//1차적으로 int로 형변환 불가와 자리 수가 3이 아닐 경우, 0인지를 체크
        return true;
    }
    void exitView(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        exitFlag = Console.readLine();
        if(!(exitFlag.equals("1")||exitFlag.equals("2")))throw new IllegalArgumentException();
    }
    public String getInput() {
        return input;
    }
    public String getExitFlag() {
        return exitFlag;
    }
}
