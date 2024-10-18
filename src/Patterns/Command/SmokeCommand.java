package Patterns.Command;

public class SmokeCommand implements Command {
    private Worker worker;

    public SmokeCommand(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void execute() {
        worker.smoke();
    }
}
