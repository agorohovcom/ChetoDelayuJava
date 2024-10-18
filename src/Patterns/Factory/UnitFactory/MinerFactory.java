package Patterns.Factory.UnitFactory;

public class MinerFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Miner();
    }
}
