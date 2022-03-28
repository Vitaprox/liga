package test;

import org.testng.annotations.Test;
import steps.HeaderSteps;
import steps.HomePageSteps;
import steps.ListingSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ListingPageTest {
    private HeaderSteps headerSteps = new HeaderSteps();
    private HomePageSteps homePageSteps = new HomePageSteps();
    private ListingSteps listingSteps = new ListingSteps();

    @Test
    public void checkSearchProducts(){
        //Configuration.holdBrowserOpen = true;
        open("https://www.mvideo.ru/");
        headerSteps.checkSearchIsDisplayed();
        headerSteps.typingAppleSearchInput();
        headerSteps.clickSearchButton();
        listingSteps.checkNameProductsContainsApple();
        closeWebDriver();
    }

    @Test
    public void checkSortInListing(){
        //Configuration.holdBrowserOpen = true;
        open("https://www.mvideo.ru/");
        headerSteps.checkSearchIsDisplayed();
        headerSteps.typingAppleSearchInput();
        headerSteps.clickSearchButton();
        listingSteps.checkNameProductsContainsApple();
        listingSteps.checkSortDropdownIdDisplayed();
        listingSteps.checkTextSortDropdownMostPopular();
        listingSteps.clickSortDropdown();
        listingSteps.clickSortDropDownOptionDecreasingPrice();
        listingSteps.checkNameProductsContainsApple();
        listingSteps.checkSortPriceDecrease();
        closeWebDriver();
    }
}
