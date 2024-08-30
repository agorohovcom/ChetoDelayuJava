package Patterns.Factory.DoughnutFactory;

public class DoughnutFactory {
    private Integer cherryDoughnutCount = 0;
    private Integer chocolateDoughnutCount = 0;
    private Integer almondDoughnutCount = 0;

    public void printCount(){
        System.out.println("Number of doughnuts produced (by type):");
        System.out.println("Cherry doughnuts: " + cherryDoughnutCount);
        System.out.println("Chocolate doughnuts: " + chocolateDoughnutCount);
        System.out.println("Almond doughnuts: " + almondDoughnutCount);
        System.out.println("Total: " + (cherryDoughnutCount+chocolateDoughnutCount+almondDoughnutCount));
    }

    public Doughnut getDoughnut(DoughnutTypes type){
        Doughnut toReturn = null;

        switch (type){
            case CHERRY:
                cherryDoughnutCount++;
                toReturn = new CherryDoughnut();
                break;
            case CHOCOLATE:
                chocolateDoughnutCount++;
                toReturn = new ChocolateDoughnut();
                break;
            case ALMOND:
                almondDoughnutCount++;
                toReturn = new AlmondDoughnut();
                break;
            default:
                throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }

        return toReturn;
    }
}


