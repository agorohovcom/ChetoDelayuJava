package Enums;

import java.util.Arrays;

public class EnumExample2 {
    public static void main(String[] args) {
        Today2 today1 = new Today2(WeekDays2.MONDAY);
        today1.daysInfo();

//        WeekDays2 w = WeekDays2.FRIDAY;
//        System.out.println(w.getMood());

        System.out.println(today1.weekDay);


        WeekDays2 w1 = WeekDays2.FRIDAY;
        WeekDays2 w2 = WeekDays2.FRIDAY;
        WeekDays2 w3 = WeekDays2.MONDAY;

        System.out.println(w1==w2);     // true
        System.out.println(w1==w3);     // false

        System.out.println(WeekDays2.FRIDAY.equals(WeekDays3.FRIDAY));  // false

        WeekDays2 w15 = WeekDays2.valueOf("MONDAY");
        System.out.println(w15);        // MONDAY

        WeekDays2[] array = WeekDays2.values();
        System.out.println(Arrays.toString(array));

    }
}

enum WeekDays2{
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY("good"),
    SATURDAY("great"),
    SUNDAY("good");

    /**
     * Конструкторы в Enum всегда private
     */
    private String mood;
    private WeekDays2(String mood){
        this.mood = mood;
    }

//    private WeekDays2(){}

    public String getMood(){
        return mood;
    }
}

enum WeekDays3 {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

class Today2{
    WeekDays2 weekDay;
    public Today2(WeekDays2 weekDay){
        this.weekDay = weekDay;
    }

    void daysInfo(){
        switch (weekDay){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Idi na rabotu");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Mojno otdohnut");
                break;
        }
        System.out.println("Nastroenie v etot den: " + weekDay.getMood());
    }
}