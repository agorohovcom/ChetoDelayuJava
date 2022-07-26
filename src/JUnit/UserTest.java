package JUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getAllUsers() {
        //создаем тестовые данные
        User user = new User("Евгений", 35, Sex.MALE);
        User user1 = new User("Марина", 34, Sex.FEMALE);
        User user2 = new User("Алина", 7, Sex.FEMALE);

        //создаем список expected и заполняем его данными нашего метода
        List<User> expected = User.getAllUsers();

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предпологиаем метод должен вернуть
        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {
        //добавим проверку на null
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @org.junit.jupiter.api.Test
    void testGetAllUsers() {
    }

    @org.junit.jupiter.api.Test
    void getHowManyUsers() {
    }

    @org.junit.jupiter.api.Test
    void testGetHowManyUsers() {
    }

    @org.junit.jupiter.api.Test
    void getAllAgeUsers() {
    }

    @org.junit.jupiter.api.Test
    void testGetAllAgeUsers() {
    }

    @org.junit.jupiter.api.Test
    void getAverageAgeOfAllUsers() {
    }

    @org.junit.jupiter.api.Test
    void testGetAverageAgeOfAllUsers() {
    }
}