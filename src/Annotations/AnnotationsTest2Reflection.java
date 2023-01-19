package Annotations;

import java.lang.annotation.*;

public class AnnotationsTest2Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("Annotations.Xiaomi");
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1;
        System.out.println("Annotation info from Xiaomi class: " +
                sm1.OS() + ", " +
                sm1.yearOfCompanyCreation());

        Class iPhoneClass = Class.forName("Annotations.IPhone");
        Annotation annotation2 = iPhoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm2 = (SmartPhone) annotation2;
        System.out.println("Annotation info from IPhone class: " +
                sm2.OS() + ", " +
                sm2.yearOfCompanyCreation());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    String OS() default "Android";
    int yearOfCompanyCreation() default 2010;
}

@SmartPhone()
class Xiaomi{
    String model;
    double price;
}
@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class IPhone{
    String model;
    double price;
}
