package Patterns.Command;

public class SweepCommand implements Command {
    private Worker worker;

    public SweepCommand(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void execute() {
        worker.sweep();
    }
}
