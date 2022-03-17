package console_tests;

import org.testng.annotations.*;

public class First {

    @BeforeSuite
    public void bfSuite() {
        System.out.println("BeforeSuite");
    }

    @BeforeClass
    public void bfClass() {
        System.out.println("BeforeClass");
    }


    @AfterSuite
    public void afSuite() {
        System.out.println("AfterSuite");
    }

    @AfterMethod
    public void afMethod() {
        System.out.println("AfterMethod");
    }

    @Test
    public void test_1() {
        System.out.println("Test");
    }

    @Test
    public void test_2() {
        System.out.println("Test");
        System.out.println("Test data: 1 2");
    }

    @Test
    public void test_3() {
    }

    @Test
    public void test_4() {
        System.out.println("Test");
        System.out.println("Test data: three four");
    }

    @Test
    public void test_5() {
        System.out.println("Test");
        System.out.println("Test data: true false");
    }

}
