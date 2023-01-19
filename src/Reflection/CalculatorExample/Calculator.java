package Reflection.CalculatorExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * В текстовом файле указано название метода и 2 чмсла.
 * С помощью рефлексии вызываем метод по названию в файле
 * и выполняем его с указанными в файле числами.
 */
public class Calculator {
    void sum(int a, int b){
        int result = a + b;
        System.out.println("Сумма " + a + " и " + b + " = " + result);
    }
    void subtraction(int a, int b){
        int result = a - b;
        System.out.println("Разница " + a + " и " + b + " = " + result);
    }
    void multiplication(int a, int b){
        int result = a * b;
        System.out.println("Произведение " + a + " на " + b + " = " + result);
    }
    void division(int a, int b){
        int result = a / b;
        System.out.println("Частное " + a + " и " + b + " = " + result);
    }
}

class TestCalculator{
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/Reflection/CalculatorExample/test100.txt"))){
            String methodName = reader.readLine();
            String firstArg = reader.readLine();
            String secondArg = reader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;

            Method[] methods = cl.getDeclaredMethods();
            for(Method myMethod : methods){
                if(myMethod.getName().equals(methodName)){
                    method = myMethod;
                }
            }

            method.invoke(calculator, Integer.parseInt(firstArg), Integer.parseInt(secondArg));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}