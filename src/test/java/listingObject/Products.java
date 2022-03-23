package listingObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class Products {

    //a[contains(text(), 'Холодильник Haier C2F637CFMV')]/../../../..//mvid-icon[contains(@type, 'histogram')]
    private final String CART_CONTAINER_PATH_BY_NAME_1 = "//a[contains(text(), '";
    private final String CART_CONTAINER_PATH_BY_NAME_2 = "')]/../../../..//";

    /**
     * Переключатель режима просмотра
     */
    @FindBy(xpath = "//div[contains(@class, 'listing-view-switcher__inner-area')]")
    private SelenideElement viewSwitcher;

    public SelenideElement getViewSwitcher() {
        return viewSwitcher;
    }

    /**
     * Заголовок сортировки
     */
    @FindBy(xpath = "//div[contains(@class, 'dropdown__title')]/span")
    private SelenideElement sortDropDownTitle;

    /**
     * Иконка сортировки
     */
    @FindBy(xpath = "//div[contains(@class, 'dropdown__title')]/mvid-icon")
    private SelenideElement sortDropDownIcon;

    /**
     * Элемент варианта сортировки
     */
    public SelenideElement getSortDropDownOption(String nameOption) {
        SelenideElement option = $x("//div[contains(@class, 'dropdown__options')]/div[contains(text(), '" + nameOption + "')]");
        return option;
    }

    /**
     * Элемент с именем товара
     */
    public SelenideElement getProductNameEl(String nameProduct) {
        SelenideElement name = $x("//a[contains(@class, 'product-title__text') and contains(text(), '" + nameProduct + "')]");
        return name;
    }

    /**
     * Картинка товара
     */
    public SelenideElement getImgProd(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "a[contains(@class, 'product-picture-link')]");
        return element;
    }

    /**
     * Точки переключения картинок товара
     */
    public SelenideElement getProdDotSlideImg(String nameProduct, int numberDot) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "div[contains(@class, 'dots-container')]/span[" + numberDot + "]");
        return element;
    }

    /**
     * Текстовый элемент "Осталась одна штука"
     */
    public SelenideElement getProductThingLeftOne(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "div[contains(@class, 'product-notification')]");
        return element;
    }

    /**
     * Звездочка из рейтинга товара
     */
    public SelenideElement getProductRatingStar(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "span[contains(@class, 'stars-container')]/mvid-icon");
        return element;
    }

    /**
     * Элемент с оценкой по рейтингу
     */
    public SelenideElement getProductRatingNumber(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "span[contains(@class, 'stars-container')]/span");
        return element;
    }

    /**
     * Количество отзывов
     */
    public SelenideElement getProductRatingFeedback(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "div[contains(@class, 'product-rating')]/span[contains(@class, 'product-rating__feedback')]");
        return element;
    }

    /**
     * Особенность товара строкой
     */
    public SelenideElement getProductFeature(String nameProduct, String nameFeature) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "ul/li/span[contains(text(), '" + nameFeature + "')]/..");
        return element;
    }

    /**
     * Цена товара
     */
    public SelenideElement getProductPrice(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "span[contains(@class, 'price__main-value')]");
        return element;
    }

    /**
     * Цена товара без скидки
     */
    public SelenideElement getProductPriceSale(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "span[contains(@class, 'price__sale-value')]");
        return element;
    }

    /**
     * Иконка МБонуса
     */
    public SelenideElement getProductMBonusIcon(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "mvid-icon[contains(@type, 'm-bonus')]");
        return element;
    }

    /**
     * Значение МБонуса (в рублях)
     */
    public SelenideElement getProductMBonusValue(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "span[contains(@class, 'mbonus-block__value')]");
        return element;
    }

    /**
     * Текст МБонуса
     */
    public SelenideElement getProductMBonusText(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "span[contains(@class, 'mbonus-block__text-label')]");
        return element;
    }

    /**
     * Кнопка покупки
     */
    public SelenideElement getProductBuyButton(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "mvid-plp-cart-button//button");
        return element;
    }

    /**
     * Кнопка избранных товаров
     */
    public SelenideElement getHeartButton(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "mvid-icon[contains(@type, 'love')]");
        return element;
    }

    /**
     * Кнопка сравнения
     */
    public SelenideElement getComparingButton(String nameProduct) {
        SelenideElement element = $x(CART_CONTAINER_PATH_BY_NAME_1 + nameProduct + CART_CONTAINER_PATH_BY_NAME_2 + "mvid-icon[contains(@type, 'histogram')]");
        return element;
    }

    /**
     * Пагинация стрелочка назад
     */
    @FindBy(xpath = "//ul[contains(@class, 'pagination')]/li[1]")
    private SelenideElement backArrowPagination;


    /**
     * Пагинация стрелочка вперед
     */
    public SelenideElement getForwardArrowPagination() {
        ElementsCollection liPage = $$(By.className("page-item"));
        SelenideElement arrow = liPage.get(liPage.size() - 1);
        return arrow;
    }

    /**
     * Элемент пагинации по тексту
     */
    public SelenideElement getPaginationEl(String elementText) {
        SelenideElement element = $x("//ul[contains(@class, 'pagination')]/li/a[contains(text(), '" + elementText + "')]");
        return element;
    }

    /**
     * Элемент пагинации по номеру в списке
     */
    public SelenideElement getPaginationEl(int numberEl) {
        SelenideElement element = $x("//ul[contains(@class, 'pagination')]/li[" + numberEl + "]");
        return element;
    }

}