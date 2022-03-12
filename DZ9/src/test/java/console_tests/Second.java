package console_tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Second {

    @BeforeClass(groups = "first_half")
    public void bfClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass(groups = "second_half")
    public void afClass() {
        System.out.println("AfterClass");
    }

    @AfterClass(groups = "second_half")
    public void afClass2() {
        System.out.println("AfterClass");
    }

    @AfterTest(groups = "second_half")
    public void afTest() {
        System.out.println("AfterTest");
    }

    @Test(groups = "first_half", alwaysRun = true)
    public void test_1() {
        System.out.println("Test");
    }

    @Test(groups = "first_half", alwaysRun = true)
    public void test_2() {
        System.out.println("Test");
    }


    @Test(groups = "second_half", alwaysRun = true)
    public void test_4() {
        System.out.println("Test");
        System.out.println("Test data: three four");
    }

    @Test(groups = "second_half", alwaysRun = true)
    public void test_5() {
        System.out.println("Test");
        System.out.println("Test data: true false");
    }

}
