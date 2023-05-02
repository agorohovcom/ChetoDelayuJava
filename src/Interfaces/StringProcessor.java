package Interfaces;

public abstract class StringProcessor implements Processor{
    public static void main(String[] args) {
        Apply.process(new UpCase(), s);
        Apply.process(new DownCase(), s);
        Apply.process(new Splitter(), s);
    }
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);

    public static String s =
            "Ехал Грека через реку, видит Грека - в реке рачь.";
}
