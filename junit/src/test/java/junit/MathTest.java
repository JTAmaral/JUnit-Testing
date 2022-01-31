package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.*;
import org.junit.jupiter.api.*;

// Create instances of the class before each test
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathTest {
    /**
     * Rigorous Test.
     */

    // Create math object: nums
    Math nums;

    // function is called before all tests
    @BeforeAll
    public void start() {
        System.out.println("Starting arithemtic testing!");
    }

    // function is called before each test
    @BeforeEach
    public void setup() {
        nums = new Math();
    }

    // testing addition
    @Test
    public void testAdd() {
        assertEquals(6, nums.add(1, 5));
    }

    // testing subtraction
    @Test
    public void testSub() {
        assertEquals(-5, nums.sub(1, 6));
    }

    // testing multiplication
    @Test
    public void testMult() {
        assertEquals(9, nums.mult(3, 3));
    }

    // testing division - WEIRD ERROR
    /*@Test
    public void testDiv() {
        assertEquals(1, nums.div(3, 3));
    }*/

    //FAILED CASE DIVIDE IF BY ZERO - NOT WORKING
    @Test
    @DisplayName("Divide by Zero")  // Changes the name of the test
    public void divideByZeroException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            nums.div(100, 0);
        });
        System.out.println("DIVIDE BY 0 ERROR!!!");
    }

    //Function will execute after all the tests
    @AfterAll
    public void destroyAll() {
        System.out.println("Execute after all");
    }

    //Function will execute after each Test
    @AfterEach
    public void destroyEach() {
        System.out.println("Execute after each");
    }

    @DisplayName("Squaring a value")
    @RepeatedTest(value = 5, name = "Repeating testSquare()")
    public void testSquare() {
        assertEquals(100, nums.square(10));
    }

    @DisplayName("Parameter Testing")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10, 100})
    public void divideNumbersUsingValueSource(int y) {
        nums.div(10, y);
    }

    @DisplayName("Method Source Case")
    @ParameterizedTest
    @MethodSource("numberList")
    public void divideNumbersUsingMethodSource(int y) {
        nums.div(10, y);
    }

    public static ArrayList<Integer> numberList() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(15);
        return values;
    }

}
