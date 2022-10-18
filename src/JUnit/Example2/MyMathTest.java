package JUnit.Example2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


class MyMathTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
//    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void add() throws InterruptedException {
        System.out.println("add");
        int a = 2;
        int b = 3;
        int expResult = 5;
        int result = MyMath.add(a, b);
        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }


    @Test
    @DisplayName("div 😱")
    void div() {
        System.out.println("div");
        int a = 8;
        int b = 2;
        int expResult = 4;
        int result = MyMath.div(a, b);
        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }
}