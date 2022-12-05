public class Main {
    public static void main(String[] args) {
        Cho cho = new Cho();
        new Thread(cho::doSomething1).start();
        new Thread(cho::doSomething2).start();
    }
}

class Cho{
    synchronized void doSomething1(){
        for(int i = 0; i < 3; i++){
            System.out.println("Do something 1 " + (i+1) + "/3");
        }
    }

    synchronized void doSomething2(){
        for(int i = 0; i < 3; i++){
            System.out.println("Do something 2 " + (i+1) + "/3");
        }
    }
}






