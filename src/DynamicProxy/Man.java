package DynamicProxy;

public class Man implements Person{
    private String name;
    private int age;
    private String city;
    private String country;

    public Man(String name, int age, String city, String country) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public void introduce(String name) {

        System.out.println("Меня зовут " + this.name);
    }

    @Override
    public void sayAge(int age) {
        System.out.println("Мне " + this.age + " лет");
    }

    @Override
    public void sayFrom(String city, String country) {

        System.out.println("Я из города " + this.city + ", " + this.country);
    }

}
