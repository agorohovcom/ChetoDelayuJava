package Patterns.Factory.UnitFactory;

public class SoldierFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Soldier();
    }
}
