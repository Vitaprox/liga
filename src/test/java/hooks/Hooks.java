package hooks;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class Hooks {
    @BeforeSuite
    public void configOption(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
    }
}
