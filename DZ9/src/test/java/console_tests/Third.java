package console_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Third {

    @BeforeTest
    public void bfTest() {
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afTest() {
        System.out.println("AfterTest");
    }

    @Test
    public void test() {
        System.out.println("Test");
    }

    @AfterMethod
    public void afMethod() {
        System.out.println("AfterMethod");
    }
}
