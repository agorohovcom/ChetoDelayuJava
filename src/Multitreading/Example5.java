package Multitreading;

public class Example5 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("moy_potok");
//        myThread5.setPriority(9);
        myThread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name of myThread5 = " +
                myThread5.getName());
        System.out.println("Priority of myThread5 = " +
                myThread5.getPriority());


    }
}

class MyThread5 extends Thread{
    @Override
    public void run() {
        System.out.println("privet");
    }
}