package JSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect
public class Cat {
    private String name;
    private int age;
    private boolean hunter;

    @JsonIgnore
    public String ignore = "Это поле будет игнорироваться при сериализации JSON";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHunter() {
        return hunter;
    }

    public void setHunter(boolean hunter) {
        this.hunter = hunter;
    }



    @Override
    public String toString() {
        return "Кота зовут " + this.getName() + ", возраст - " + this.getAge() + " лет, охотник - " + this.hunter;
    }
}
