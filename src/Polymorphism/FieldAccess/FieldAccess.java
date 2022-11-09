package Polymorphism.FieldAccess;

/**
 * Если переменной родительского класса присвоить ссылку на класс-наследник,
 * а потом у этого объекта вызвать поле класса, то вызовется поле родителя.
 * С полями полиморфизм не работает
 * (если у родителя и наследника есть поле с одинаковым именем).
 * Кстати, так же себя ведут статичекие методы.
 */
public class FieldAccess {

    static class ParentClass {
        private String field = "Родитель";
        public String getField(){
            return field;
        }
    }

    public static class ChildClass extends ParentClass {
        private String field = "Наследник";
        public String getField(){
            return field;
        }
        public String getSuperField(){
            return super.field;
        }
    }

    public static void main(String[] args) {
        ParentClass childUpcast = new ChildClass();   // Upcast
        ChildClass child = new ChildClass();
        System.out.println("Class = \"" + childUpcast.getClass().getSimpleName() +
                "\", childUpcast.field = \"" + childUpcast.field +
                "\", childUpcast.getField() = \"" + childUpcast.getField() + "\"");
        System.out.println("Class = \"" + child.getClass().getSimpleName() +
                "\", child.field = \"" + child.field +
                "\", child.getField() = \"" + child.getField() +
                "\", child.getSuperField() = " + child.getSuperField() + "\"");
    }
}
