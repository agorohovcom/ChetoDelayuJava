package Patterns.Command;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker("Dima");
        Command digCommand = new DigCommand(worker);
        Command sweepCommand = new SweepCommand(worker);
        Command smokeCommand = new SmokeCommand(worker);

        WorkerManager manager = new WorkerManager();

        manager.setCommand(digCommand);
        manager.doWork();
        manager.setCommand(sweepCommand);
        manager.doWork();
        manager.setCommand(smokeCommand);
        manager.doWork();

    }
}
