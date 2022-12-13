package Multitreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerExample1 {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1Actions = new ArrayList<>();
        friend1Actions.add(Action.NOJNITSI);
        friend1Actions.add(Action.BUMAGA);
        friend1Actions.add(Action.NOJNITSI);
        List<Action> friend2Actions = new ArrayList<>();
        friend2Actions.add(Action.BUMAGA);
        friend2Actions.add(Action.KAMEN);
        friend2Actions.add(Action.KAMEN);

        new BestFriend("Vanya", friend1Actions, exchanger);
        new BestFriend("Petya", friend2Actions, exchanger);

    }
}

enum Action{
    KAMEN, NOJNITSI, BUMAGA;
}

class BestFriend extends Thread{
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    @Override
    public void run() {
        Action reply;
        for(Action action: myActions){
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void whoWins(Action myAction, Action friendsAction){
        if((myAction == Action.KAMEN && friendsAction == Action.NOJNITSI)
        || (myAction == Action.NOJNITSI && friendsAction == Action.BUMAGA)
        || (myAction == Action.BUMAGA && friendsAction == Action.KAMEN)){
            System.out.println(name + " WINS!!!");
        }
    }
}

// Output

//    Vanya WINS!!!
//    Vanya WINS!!!
//    Petya WINS!!!
//
//    Process finished with exit code 0