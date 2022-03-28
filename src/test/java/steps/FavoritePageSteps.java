package steps;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.FavoritePage;
import patternWebElement.CartProductsNamePriceBuy;

public class FavoritePageSteps {
    private FavoritePage favoritePage = Selenide.page(new FavoritePage());

    public void checkNameAddProducts(){
        Assert.assertTrue(favoritePage.checkNamesAddProducts(), "Добавленные товары не соответствуют товарам на странице");
        CartProductsNamePriceBuy.clearCartList();
    }

}
