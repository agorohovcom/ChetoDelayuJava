package Patterns.Command;

public class WorkerManager {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void doWork() {
        command.execute();
    }
}
