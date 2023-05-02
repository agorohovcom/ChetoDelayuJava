package Interfaces;

public class Apply {
    public static void main(String[] args) {
        process(new UpCase(), s);
        process(new DownCase(), s);
        process(new Splitter(), s);
    }
    public static void process(Processor p, Object s){
        System.out.println("Используем Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static String s =
            "Ехал Грека через реку, видит Грека - в реке рачь.";
}
