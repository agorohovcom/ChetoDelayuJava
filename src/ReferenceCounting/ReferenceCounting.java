package ReferenceCounting;

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)};
        for(Composing c : composing){
            c.dispose();
        }

        // Вывод в консоль:
//        Создаём Shared 0
//        Создаём Composing 0
//        Создаём Composing 1
//        Создаём Composing 2
//        Создаём Composing 3
//        Создаём Composing 4
//        Закрываем Composing 0
//        Закрываем Composing 1
//        Закрываем Composing 2
//        Закрываем Composing 3
//        Закрываем Composing 4
//        Закрываем Shared 0
    }
}

class Shared {
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared(){
        System.out.println("Создаём " + this);
    }
    public void addRef(){
        refCount++;
    }
    protected void dispose(){
        if(--refCount == 0){
            System.out.println("Закрываем " + this);
        }
    }
    public String toString(){
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    public Composing(Shared shared){
        System.out.println("Создаём " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose(){
        System.out.println("Закрываем " + this);
        shared.dispose();
    }
    public String toString(){
        return "Composing " + id;
    }
}
