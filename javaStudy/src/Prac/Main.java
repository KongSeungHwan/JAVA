package baseball;


//모든 로직을 이행하는 클래스
public class Main {
    Main(){
        boolean flag = false;
        Computer computer = new Computer();
        while(!flag) {
            InputView inputView = new InputView();
            User user = new User(inputView.getInput());
            System.out.println(computer.getNumbers());
            Comparator comparator = new Comparator(user.getUserNumber(), computer.getNumbers());
            OutputView outputView = new OutputView(comparator);
            flag = comparator.isFlag();
            if(flag)inputView.exitView();
            if(inputView.getExitFlag()==null)continue;
            if(inputView.getExitFlag().equals("1")){
                flag = false;
                computer = new Computer();
            }
        }
    }
}
