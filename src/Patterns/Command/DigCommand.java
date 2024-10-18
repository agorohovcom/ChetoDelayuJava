package Patterns.Command;

public class DigCommand implements Command {
    private Worker worker;

    public DigCommand(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void execute() {
        worker.dig();
    }
}
