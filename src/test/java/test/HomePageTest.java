package test;

import org.testng.annotations.Test;
import steps.HeaderSteps;
import steps.HomePageSteps;

import static com.codeborne.selenide.Selenide.*;

public class HomePageTest {
    private HeaderSteps headerSteps = new HeaderSteps();
    private HomePageSteps homePageSteps = new HomePageSteps();

    @Test
    public void checkHeaderButtonsActiveAndDisplayed(){
        //Configuration.holdBrowserOpen = true;
        open("https://www.mvideo.ru/");
        headerSteps.checkThatStatusButtonIsActive();
        headerSteps.checkThatStatusButtonIsDisplayed();
        headerSteps.checkThatProfileButtonIsActive();
        headerSteps.checkThatProfileButtonIsDisplayed();
        headerSteps.checkThatComparisonButtonIsNotActive();
        headerSteps.checkThatComparisonButtonIsDisplayed();
        headerSteps.checkThatFavouritesButtonIsNotActive();
        headerSteps.checkThatFavouritesButtonIsDisplayed();
        headerSteps.checkThatBasketButtonIsNotActive();
        headerSteps.checkThatBasketButtonIsDisplayed();
        closeWebDriver();
    }

    @Test
    public void checkActivationBasketHeader(){
        //Configuration.holdBrowserOpen = true;
        open("https://www.mvideo.ru/");
        homePageSteps.checkDayProductsIsDisplayed();
        homePageSteps.clickBuyButtonDayProducts(); /**Тут же проверка на отображение корзины (подтвержение, что сработал клик)*/
        headerSteps.checkBasketCount();
        closeWebDriver();
    }

    @Test
    public void checkAuthorisationWindow(){
        open("https://www.mvideo.ru/");
        headerSteps.clickProfileButton(); /**Там же проверка открылось ли окно с заголовком Вход или регистрация*/
        headerSteps.checkCloseButtonIsDisplayed();
        headerSteps.checkInputPhoneIsDisplayed();
        headerSteps.checkActiveLoginButton();
        headerSteps.checkEntityFormIIsDisplayed();
        closeWebDriver();
    }

    @Test
    public void checkEditCity(){
        //Configuration.holdBrowserOpen = true;
        open("https://www.mvideo.ru/");
        headerSteps.clickLocationCity(); /**Тут же проверка открылось ли окно*/
        headerSteps.chooseCity(); /**Тут же проверка закрылось ли окно*/
        headerSteps.checkLocationCityText();
        closeWebDriver();
    }

}
