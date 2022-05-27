package Shildt;

@FunctionalInterface
interface Generator{                            //ф-й интерфейс
    public int getNextElement();                //*класс его не реализует
}
class SimpleGen {
    private int number;
    public SimpleGen(int number){
        this.number = number;
    }
    public int getNumber(){                     //метод экземпляра
        return ++number;
    }
    public static int gerRandomNumber(){        //статический метод класса
        return (int) (Math.random() * 10);
    }
    public static void main(String[] args) {
        //*****Ссылка на нестатический медот конкретного объекта*****
        SimpleGen sg = new SimpleGen(5);
        Generator gen1 = sg::getNumber;         //используем ссылку на объект
        int temp1 = gen1.getNextElement();
        System.out.println(temp1);              //вывод в к.: 5
        //*****ссылка на статический метод класса*****
        Generator gen2 = SimpleGen::gerRandomNumber;
        int temp2 = gen2.getNextElement();
        System.out.println(temp2);              //получим случайное число
    }
}
