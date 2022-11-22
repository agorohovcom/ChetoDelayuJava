package LambdaExpression.FunctionalInterfaces.Comparable;

import java.util.Objects;

public class Cat implements Comparable<Cat>{
    private String name;
    private int age;

    public Cat(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }

    public Cat(){
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        Cat other = (Cat) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public int compareTo(Cat o) {
        if (o == null){
            throw new NullPointerException();
        }
        if(this.age > o.age){
            return 1;
        }
        if(this.age < o.age){
            return -1;
        }
        // Если при равенстве age вернуть 0, получится рассогласование с equals.
        // Поэтому проводим сравнение name
        return this.name.compareTo(o.name);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat [name = " + name + ", age = " + age + "]";
    }
}
