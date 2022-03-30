package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import pages.*;




public class HeaderSteps {

    private HeaderPage headerPage = Selenide.page(new HeaderPage());
    private BasketPage basketPage = Selenide.page(new BasketPage());
    private ListingPage listingPage = Selenide.page(new ListingPage());
    private ComparisonPage comparisonPage = Selenide.page(new ComparisonPage());
    private FavoritePage favoritePage = Selenide.page(new FavoritePage());


    public void checkThatStatusButtonIsActive() {
        Assert.assertTrue(headerPage.buttonIsActive("Статус заказа"), "Кнопка статуса заказа неактивна");
    }

    public void checkThatStatusButtonIsDisplayed() {
        Assert.assertTrue(headerPage.buttonIsDisplayed("Статус заказа"), "Кнопка статуса заказа не отображается");
    }

    public void checkThatProfileButtonIsActive() {
        Assert.assertTrue(headerPage.buttonIsActive("Войти"), "Кнопка профиля неактивна");
    }

    public void checkThatProfileButtonIsDisplayed() {
        Assert.assertTrue(headerPage.buttonIsDisplayed("Войти"), "Кнопка профиля не отображается");
    }

    public void checkThatComparisonButtonIsNotActive() {
        Assert.assertFalse(headerPage.buttonIsActive("Сравнение"), "Кнопка сравнения неактивна");
    }

    public void checkThatComparisonButtonIsDisplayed() {
        Assert.assertTrue(headerPage.buttonIsDisplayed("Сравнение"), "Кнопка сравнения не отображается");
    }

    public void checkThatFavouritesButtonIsNotActive() {
        Assert.assertFalse(headerPage.buttonIsActive("Избранное"), "Кнопка избранного неактивна");
    }

    public void checkThatFavouritesButtonIsDisplayed() {
        Assert.assertTrue(headerPage.buttonIsDisplayed("Избранное"), "Кнопка избранного не отображается");
    }

    public void checkThatBasketButtonIsNotActive() {
        Assert.assertFalse(headerPage.buttonIsActive("Корзина"), "Кнопка корзины неактивна");
    }

    public void checkThatBasketButtonIsDisplayed() {
        Assert.assertTrue(headerPage.buttonIsDisplayed("Корзина"), "Кнопка корзины не отображается");
    }

    /**Проверка правильная ли цифра отображается у корзины после добавления товара в корзину*/
    public void checkBasketCount(){
        Assert.assertEquals(headerPage.getBasketCountInt(),1, "Цифра у корзины не соотвтствует действительности");
    }

    /**Проверка получилось ли кликнуть и перейти на страницу корзины*/
    public void clickBasketButton(){
        headerPage.clickBasketButton();
        String expectedUrl = "https://www.mvideo.ru/cart";
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Моя корзина не открылась");
    }

    public void checkSearchIsDisplayed(){
        Assert.assertTrue(headerPage.checkSearchIsDisplayed(), "Строка поиска не отображается");
    }

    public void typingAppleSearchInput(){
        headerPage.typingSearchInput("apple");
        Assert.assertEquals(headerPage.checkSearchInputValue(), "apple", "В поисковую строку был введен другой текст");
    }

    public void clickSearchButton(){
        headerPage.clickSearchButton();
        listingPage.checkProductsIsVisible();
        String expectedUrl = "https://www.mvideo.ru/product-list-page?q=apple&category=smartfony-205";
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    /**Клик на нопку профиля и проверка открылось ли окно*/
    public void clickProfileButton(){
        headerPage.clickProfileButton();
        headerPage.checkLoginFormIsVisible();
    }

    public void checkCloseButtonIsDisplayed(){
        Assert.assertTrue(headerPage.checkCloseButtonIsDisplayed(), "Кнопка закрытия формы авторизации не отображается");
    }

    public void checkInputPhoneIsDisplayed(){
        Assert.assertTrue(headerPage.checkInputPhoneIsDisplayed(), "Инпут для ввода телефона не отображается");
    }

    public void checkActiveLoginButton(){
        Assert.assertTrue(headerPage.checkNotActiveLoginButton(), "Кнопка продолжить активна, хотя не должна");
    }

    public void checkEntityFormIIsDisplayed(){
        Assert.assertTrue(headerPage.checkEntityFormIIsDisplayed(), "Ссылка для юр лиц не отображается");
    }

    public void clickComparisonButton(){
        headerPage.clickComparisonButton();
        comparisonPage.checkComparisonTitleIsVisible();
    }

    public void clickFavoriteButton(){
        headerPage.clickFavoriteButton();
        Assert.assertTrue(favoritePage.checkFavoriteIsDisplayed());
    }

    public void clickLocationCity(){
        headerPage.clickLocationCity();
        Assert.assertTrue(headerPage.isDisplayedWindowChooseCity(), "Окно с выбором города не отображается");
    }

    public void chooseCity(){
        headerPage.clickCity("Краснодар");
        headerPage.checkCloseWindowCity();
    }

    public void checkLocationCityText(){
        headerPage.checkLocationCityText();
    }

}
