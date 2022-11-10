package Generics.WildcardGame;

public class Test {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Maria", 15);

        Student student1 = new Student("Nikolay", 20);
        Student student2 = new Student("Kseniya", 18);

        Employee employee1 = new Employee("Zaur", 32);
        Employee employee2 = new Employee("Mikhail", 47);

        Team<Schoolar> schoolarTeam = new Team("Драконы");
        Team<Student> studentTeam = new Team("Вперёд!");
        Team<Employee> employeeTeam = new Team("Работяги");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);
//        schoolarTeam.addNewParticipant(employee1);            // компилятор не даёт добавить
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

//        Team<String> anotherTeam = new Team<>("Фантазия");    // компилятор не даёт создать
//        anotherTeam.addNewParticipant("Здорова");

        Team<Schoolar> schoolarTeam2 = new Team<>("Мудрецы");
        Schoolar schoolar3 = new Schoolar("Sergey", 13);
        Schoolar schoolar4 = new Schoolar("Olya", 15);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

//        schoolarTeam.playWith(employeeTeam);                  // компилятор не даёт запустить
        schoolarTeam.playWith(schoolarTeam2);


    }
}
