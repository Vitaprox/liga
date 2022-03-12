package console_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Fourth {

    @AfterMethod(groups = "first_half")
    public void afMethod() {
        System.out.println("AfterMethod");
    }

    @Test(groups = "first_half", alwaysRun = true)
    public void test_3() {
        System.out.println("Test");
        System.out.println("Test data 1 2");

    }
}
