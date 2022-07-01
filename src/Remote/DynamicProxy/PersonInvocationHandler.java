package Remote.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {

    private Person person;

    public PersonInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Привет!");

        // Если оставим return null, любой метод выведет просто "Привет!"
//        return null;

        // чтобы также сработал вывываемый метод, пишем в return следующее
        return method.invoke(person, args);
    }
}
