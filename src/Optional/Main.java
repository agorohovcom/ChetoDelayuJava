package Optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {

    // === 3 способа поиска с обработкой null ===
    // ==========================================
    // 1 - с присваиванием null в случае неудачи
    public static Cat findCatByName(String name, Cat[] cats){
        for(Cat c : cats){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
    // 2 - с ошибкой в случае неудачи
    public static Cat findCatByNameEx(String name, Cat[] cats){
        for(Cat c : cats){
            if(c.getName().equals(name)){
                return c;
            }
        }
        throw new NoSuchElementException();
    }
    // 3 - через класс Optional
    public static Optional<Cat> findCatByNameOptional(String name, Cat[] cats){
        Cat findingCat = null;
        for(Cat c : cats){
            if(c.getName().equals(name)){
                findingCat = c;
                break;
            }
        }
        return Optional.ofNullable(findingCat);
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat("Vaska", "Black");
        Cat cat2 = new Cat("Barsic", "White");
        Cat cat3 = new Cat("Umka", "Grey");

        Cat[] cats = new Cat[]{cat1, cat2, cat3};

//        System.out.println("Ищем кота по имени Vaska: " + findCatByNameOptional("Vaska", cats));
//        System.out.println("Ищем кота по имени Pushistik: " + findCatByNameOptional("Pushistik", cats));

        Optional<Cat> result = findCatByNameOptional("Vaska", cats);

        // === Методы класса Optional ===
        // ==============================
        // Optional.empty() - объект точно отсутствует
        // Optional.of(T obj) - объект есть и точно не null
        // Optional.ofNullable(T obj) - объект есть, но может быть null
        // ==============================

        // isPresent(), get()
        if(result.isPresent()){              // если такой элемент есть
            Cat cat = result.get();        // получить ссылку
//            System.out.println(cat);
        } else {
            System.out.println("Такого кота нет");
        }

        // T orElse(T other) - если ссылка равна null, возвращаем объект other
        // T orElseGet(Supplier<? extends T> supplier) - если ссылка равна null, создаём объект и возвращаем его
        Cat defaultCat = new Cat("Default name", "Default color");

        Cat catOrDefault = result.orElse(defaultCat);
//        System.out.println(catOrDefault);

        Cat catOrNewCat = result.orElseGet(Cat::new);
//        System.out.println(catOrNewCat);

        // === Генерация исключения в случае "пустого" Optional ===
        // ========================================================
        // orElseThrow(Supplier<? extends X> exceptionSupplier) - если хранится null,
        // генерировать исключение полученное с помощью параметра метода
        Cat catElseThrow = result.orElseThrow(NoSuchElementException::new);
//        System.out.println(catElseThrow);
        // orElseThrow - если хранится null, генерировать исключение NoSuchElementException
        Cat catElseDefThrow = result.orElseThrow();
//        System.out.println(catElseDefThrow);

        // === Выполнение действий, если ссылка в Optional не null
        // =======================================================
        // * void ifPresent(Consumer<? super T> action) - если значение ссылки не равно null,
        // то выполнить действие с использованием ссылки, в противном случае ничего не делать
        // * void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) - если
        // значение ссылки не равно null, то выполнить действие с использованием ссылки,
        // в противном случае выполнить альтернативное действие

        result.ifPresent(a -> System.out.println(a));

        result.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));

        // ===== Метод stream() =====
        // Если ссылка не равна null, то будет возвращён Stream с этой ссылкой,
        // в противном случае - пустой Stream

        // === Использование Optional для преобразования значений
        // ======================================================
        // * filter - если реализация Predicate вернёт true, то вернётся Optional со значением,
        // в противном случае Optional со значением null
        // * map - если значение ссылки в Optional не равно null, то создаётся новый Optional
        // на основании значения ссылки. В противном случае вернётся пустой Optional
        // * flatMap - если значение ссылки в Optional не равно null, то создаётся новый Optional
        // на основании текущего Optional. В противном случае вернётся пустой Optional
        // * or - если значение ссылки в Optional равно null, то вернётся новый Optional,
        // созданный на основе параметра


    }

}

// Ссылка на видео:
// https://www.youtube.com/watch?v=s3DaG-XwYnM&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=14&ab_channel=OleksandrTsymbaliuk