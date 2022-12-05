package Multitreading;

public class WaitNotifyExample2 {
    public static void main(String[] args) {
        MillingMachine millingMachine = new MillingMachine();
        Milling milling = new Milling(millingMachine);
        Cut cut = new Cut(millingMachine);
        Thread thread1 = new Thread(milling);
        Thread thread2 = new Thread(cut);
        thread1.start();
        thread2.start();
    }
}

class MillingMachine{

    private int detailStackCounter = 0;

    public synchronized void doNewDetailStack(){
        while (detailStackCounter >= 10){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        detailStackCounter++;
        System.out.println("Раскрой напилил новую пачку");
        System.out.println("Всего пачек на раскрое " + detailStackCounter);
        notify();
    }

    public synchronized void takeDetailStackToMilling(){
        while (detailStackCounter < 5){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        detailStackCounter--;
        System.out.println("Фрезер забрал пачку с раскроя");
        System.out.println("Всего пачек на раскрое " + detailStackCounter);
        notify();
    }
}

class Cut implements Runnable{
    MillingMachine millingMachine;

    public Cut(MillingMachine millingMachine) {
        this.millingMachine = millingMachine;
    }

    @Override
    public void run() {
        for(int i = 0; i < 30; i++){
            millingMachine.doNewDetailStack();
        }
    }
}

class Milling implements Runnable{
    MillingMachine millingMachine;

    public Milling(MillingMachine millingMachine) {
        this.millingMachine = millingMachine;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            millingMachine.takeDetailStackToMilling();
        }
    }
}