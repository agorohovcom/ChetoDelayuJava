package RegEx;

/**
 * %[flags][width][.precision]datatype_specifier
 * flags:
 *      "-" - выравнивание по левому краю
 *      "0" - добавление нулей перед числом
 *      "," - разделитель разрядов в числах
 * width - минимальное кол-во символов для текста
 * .precision - точность, отругление дробных чисел
 * datatype_specifier - тип данных:
 *      "b" boolean
 *      "c" character
 *      "s" String
 *      "d" целое число
 *      "f" десятичное число
 */
public class StringPrintfAndFormatExample {

    static void employeeInfo(Employee emp){
        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n",
                emp.id, emp.name, emp.surname, emp.salary*(1+emp.bonusPct));
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Zaur", "Tregulov", 12345, 0.15);
        Employee emp2 = new Employee(15, "Nikita", "Lihachev", 6578, 0.25);
        Employee emp3 = new Employee(443, "Tomara", "Zizievna", 545, 0.11);

        employeeInfo(emp1);
        employeeInfo(emp2);
        employeeInfo(emp3);

        // Output:
//        001 	 Zaur         	 Tregulov     	 14 196,7
//        015 	 Nikita       	 Lihachev     	 8 222,5
//        443 	 Tomara       	 Zizievna     	 605,0

        String newString = String.format("%03d \t %-12s \t %-12s \t %,.1f \n",
                1, "Zaur", "Tregulov", 12345*(1+0.15));
        System.out.println(newString);
    }
}

class Employee{
    int id;
    String name;
    String surname;
    int salary;
    double bonusPct;

    public Employee(int id, String name, String surname, int salary, double bonusPct) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonusPct = bonusPct;
    }
}