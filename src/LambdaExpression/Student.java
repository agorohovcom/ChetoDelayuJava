package LambdaExpression;

public class Student {
    String name;
    char sex;
    int age;
    int course;
    double avgRage;

    public Student(String name, char sex, int age, int course, double avgRage) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgRage = avgRage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgRage=" + avgRage +
                '}';
    }
}
