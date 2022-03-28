package test;

import org.testng.annotations.Test;
import steps.BasketPageSteps;
import steps.HeaderSteps;
import steps.HomePageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BasketPageTest {
    private HeaderSteps headerSteps = new HeaderSteps();
    private HomePageSteps homePageSteps = new HomePageSteps();
    private BasketPageSteps basketPageSteps = new BasketPageSteps();


    @Test
    public void transitionBasket(){
        //Configuration.holdBrowserOpen = true;
        open("https://www.mvideo.ru/");
        homePageSteps.checkDayProductsIsDisplayed();
        homePageSteps.clickBuyButtonDayProducts();
        headerSteps.clickBasketButton(); /**Проверка по заголовку открылась ли нужная страница*/
        basketPageSteps.checkProductInBasket();
        basketPageSteps.checkOrderButtonIsDisplayed();
        basketPageSteps.checkNumberOfProducts();
        basketPageSteps.checkPriceBasket();
        closeWebDriver();
    }

    @Test
    public void checkAddTwoProductsInBasket(){
        //Configuration.holdBrowserOpen = true;

        open("https://www.mvideo.ru/");
        homePageSteps.scrollHomePage();/**Тут же проверка на отображение Самых просматриваемых*/
        homePageSteps.clickMostViewProducts();
        headerSteps.clickBasketButton();
        basketPageSteps.checkNamesProductsInBasket();
        basketPageSteps.checkSumOrder();
        closeWebDriver();
    }
}
