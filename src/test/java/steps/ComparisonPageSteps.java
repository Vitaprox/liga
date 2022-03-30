package steps;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.ComparisonPage;
import patternWebElement.CartProductsElements;


public class ComparisonPageSteps {
    private ComparisonPage comparisonPage = Selenide.page(new ComparisonPage());


    public void checkNamesAddProducts(){
        Assert.assertTrue(comparisonPage.checkNamesAddProducts(), "Добавленные товары не соответствуют товарам на странице");
        CartProductsElements.clearCartList();
    }
}