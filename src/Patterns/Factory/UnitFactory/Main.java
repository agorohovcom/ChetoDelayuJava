package Patterns.Factory.UnitFactory;

public class Main {
    public static void main(String[] args) {
        UnitFactory unitFactory = chooseUnit("pilot");
        Unit myUnit = unitFactory.createUnit();
        myUnit.doWork();
    }

    public static UnitFactory chooseUnit(String unitDescription) {
        if (unitDescription.equalsIgnoreCase("soldier")) {
            return new SoldierFactory();
        } else if (unitDescription.equalsIgnoreCase("miner")) {
            return new MinerFactory();
        } else if (unitDescription.equalsIgnoreCase("pilot")) {
            return new PilotFactory();
        } else throw new RuntimeException("Неподдерживаемый тип юнита: " + unitDescription);
    }
}