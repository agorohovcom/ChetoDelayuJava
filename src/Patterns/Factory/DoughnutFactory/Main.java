package Patterns.Factory.DoughnutFactory;

import java.util.Random;

/** <a href="
 * https://vertex-academy.com/tutorials/ru/pattern-factory-java/?doing_wp_cron=1614101826.9163370132446289062500#tutor
 * ">...</a> */
public class Main {

    public static void eatRandomDoughnut(DoughnutFactory factory){
        Doughnut randomDoughnut = getRandomDoughnut(factory);
        System.out.print("What a surprise! ");
        randomDoughnut.eat();
    }

    public static Doughnut getRandomDoughnut(DoughnutFactory factory){
        Random random =  new Random();
        DoughnutTypes type = DoughnutTypes.values()[random.nextInt(DoughnutTypes.values().length)];

        return factory.getDoughnut(type);
    }

    public static void main(String[] args) {
        DoughnutFactory factory = new DoughnutFactory();

        Doughnut cherry = factory.getDoughnut(DoughnutTypes.CHERRY);
        Doughnut chocolate = factory.getDoughnut(DoughnutTypes.CHOCOLATE);
        Doughnut almond = factory.getDoughnut(DoughnutTypes.ALMOND);

        cherry.eat();
        chocolate.eat();
        almond.eat();

        System.out.println("================\nRandom doughnuts\n================");

        for(int i = 0; i < 20; i++){
            eatRandomDoughnut(factory);
        }

        System.out.println("================\nTotal\n================");

        factory.printCount();
    }
}
