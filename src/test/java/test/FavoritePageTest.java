package test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import steps.FavoritePageSteps;
import steps.HeaderSteps;
import steps.HomePageSteps;
import steps.ListingSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class FavoritePageTest {
    private HeaderSteps headerSteps = new HeaderSteps();
    private HomePageSteps homePageSteps = new HomePageSteps();
    private ListingSteps listingSteps = new ListingSteps();
    private FavoritePageSteps favoritePageSteps = new FavoritePageSteps();

    @Test
    public void checkAddFavorites(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        open("https://www.mvideo.ru/");
        headerSteps.checkSearchIsDisplayed();
        headerSteps.typingAppleSearchInput();
        headerSteps.clickSearchButton();
        listingSteps.clickThreeProductFavorite();
        headerSteps.clickFavoriteButton(); /**Тут же проверка заголовка (та ли страница открылась)*/
        favoritePageSteps.checkNameAddProducts();
        closeWebDriver();
    }
}
