package Enums;

public class EnumExample1 {
    public static void main(String[] args) {
        Today1 today1 = new Today1(WeekDays1.MONDAY);
        Today1 today2 = new Today1(WeekDays1.SATURDAY);
        today1.daysInfo();
        today2.daysInfo();
    }
}

enum WeekDays1{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

class Today1{
    WeekDays1 weekDay;
    public Today1(WeekDays1 weekDay){
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
    }
}