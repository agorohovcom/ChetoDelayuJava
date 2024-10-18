package Patterns.Factory.UnitFactory;

public class PilotFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Pilot();
    }
}
