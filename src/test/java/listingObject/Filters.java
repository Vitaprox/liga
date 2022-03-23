package listingObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Filters {

    /**
     * Текст цена в фильтре цен
     */
    @FindBy(xpath = "//span[contains(text(),'Цена') and contains(@class,'accordion__title-text')]")
    private SelenideElement priceTitleText;

    /**
     * Инпут минимальной цены
     */
    @FindBy(name = "minPrice")
    private SelenideElement inputMinPrice;

    /**
     * Инпут максимальной цены
     */
    @FindBy(name = "maxPrice")
    private SelenideElement inputMaxPrice;

    /**
     * Ползунок минимальнйо цены
     */
    @FindBy(xpath = "//div[contains(@class, 'slider__rail')]/button[1]")
    private SelenideElement sliderMinPrice;

    /**
     * Ползунок максимальной цены
     */
    @FindBy(xpath = "//div[contains(@class, 'slider__rail')]/button[2]")
    private SelenideElement sliderMaxPrice;


    /**
     * Чекбокс фильтра способы получения
     */
    public SelenideElement getCheckBoxFilterPickUp(int checkBoxNumber) {
        SelenideElement checkBox = $x("//div[contains(text(), 'Способы получения')]/../..//div[contains(@class, 'accordion__content')]/div[" + checkBoxNumber + "]//mvid-icon");
        return checkBox;
    }

    /**
     * Текст чекбокса фильтра способы получения
     */
    public SelenideElement getTextFilterPickUp(String textCheckBox) {
        SelenideElement textEl = $x("//div[contains(text(), 'Способы получения')]/../..//span[contains(text(), '" + textCheckBox + "')]");
        return textEl;
    }

    /**
     * Поле поиска адреса магазина. Изначально скрыто
     */
    @FindBy(xpath = "//input[contains(@placeholder, 'Адрес, название магазина')]")
    private SelenideElement storeAddressSearch;

    /**
     * Кнопка поиска адреса магазина
     */
    @FindBy(xpath = "//input[contains(@placeholder, 'Адрес, название магазина')]/..//mvid-icon")
    private SelenideElement storeAddressSearchButton;

    /**
     * Текст заголовка фильтра рейтинга товара
     */
    @FindBy(xpath = "//div[contains(text(), 'Рейтинг покупателей')]")
    private SelenideElement ratingFilterTitle;

    /**
     * Метод возвращающий радио инпут (не совсем инпут, так как инпут невидим и не нажимается, а это его контейнер) элемент внутри радио в фильтре рейтинг
     */
    public SelenideElement getRadioRating(int value) {
        SelenideElement radioRating = $x("//input[contains(@name, 'reiting-pokupatelei') and contains(@value," + value + ")]/../span[contains(@class, 'radio__icon')]");
        return radioRating;
    }

    /**
     * Метод возвращающий текстовый элемент внутри радио в фильтре рейтинг
     */
    public SelenideElement getRadioRatingTextEl(int value) {
        SelenideElement radioRating = $x("//input[contains(@name, 'reiting-pokupatelei') and contains(@value," + value + ")]/..//span[contains(text(), 'От')]");
        return radioRating;
    }

    /**
     * Метод возвращающий элемент со звездочками внутри радио в фильтре рейтинг
     */
    public SelenideElement getRadioRatingStarsEl(int value) {
        SelenideElement radioRating = $x("//input[contains(@name, 'reiting-pokupatelei') and contains(@value," + value + ")]/..//mvid-star-rating");
        return radioRating;
    }

    /**
     * Метод возвращающий элемент с количеством товара радио в фильтре рейтинг
     */
    public SelenideElement getRadioRatingCountEl(int value) {
        SelenideElement radioRating = $x("//input[contains(@name, 'reiting-pokupatelei') and contains(@value," + value + ")]/..//span[contains(@class, 'count')]");
        return radioRating;
    }

    /**
     * Элемент красной точки. Эти точки обозначают, что фильтр активирован (не видны, пока фильтры не активны
     */
    public SelenideElement getFilterDotEl(String nameFilter) {
        SelenideElement redDot = $x("//*[contains(text(), '" + nameFilter + "')]/../span[contains(@class, 'accordion__dot')]");
        return redDot;
    }

    /**
     * Элемент с именем категории
     */
    public SelenideElement getNameFilterEl(String nameFilter) {
        SelenideElement nameEl = $(byText(nameFilter));
        return nameEl;
    }

    /**
     * Стрелочка открытия и закрытия фильтра
     */
    public SelenideElement getFilterArrow(String nameFilter) {
        SelenideElement arrow = $x("//*[contains(text(), '" + nameFilter + "')]/..//mvid-icon");
        return arrow;
    }

    /**
     * Инпут поиска внутри фильтра
     */
    public SelenideElement getFilterSearch(String nameFilter) {
        SelenideElement searchFilter = $x("//*[contains(text(), '" + nameFilter + "')]/../..//input[contains(@placeholder, 'Поиск значений')]");
        return searchFilter;
    }

    /**
     * Кнопка поиска внутри фильтра
     */
    public SelenideElement getFilterSearchButton(String nameFilter) {
        SelenideElement searchFilterButton = $x("//*[contains(text(), '" + nameFilter + "')]/../..//input[contains(@placeholder, 'Поиск значений')]/..//mvid-icon");
        return searchFilterButton;
    }

    /**
     * Чекбокс фильтра. В качестве второго аргумента цифры из-за энергоэффективности А+++, А++, А+. Неправильно рассчитывало. С цифрой точнее
     */
    public SelenideElement getCheckBoxFilter(String filterName, int checkBoxNumber) {
        SelenideElement checkBox = $x("//*[contains(text(), '" + filterName + "')]/../..//div[" + checkBoxNumber + "]/mvid-checkbox//mvid-icon");
        return checkBox;
    }

    public SelenideElement getTextCheckBoxFilter(String filterName, int checkBoxNumber) {
        SelenideElement text = $x("//*[contains(text(), '" + filterName + "')]/../..//div[contains(@class, 'filter-checkbox-list__container')]/div[" + checkBoxNumber + "]//span/a");
        return text;
    }

    public SelenideElement getCountCheckBoxFilter(String filterName, int checkBoxNumber) {
        SelenideElement text = $x("//*[contains(text(), '" + filterName + "')]/../..//div[contains(@class, 'filter-checkbox-list__container')]/div[" + checkBoxNumber + "]//span[contains(@class, 'count')]");
        return text;
    }

    /**
     * Кнопка очистки фильтров
     */
    @FindBy(xpath = "//div[contains(@class, 'filter-container__clear-btn')]//button")
    private SelenideElement buttonClearFilters;

    /**
     * Текст кнопки очистки фильтров
     */
    @FindBy(xpath = "//div[contains(@class, 'filter-container__clear-btn')]//button/span")
    private SelenideElement textButtonClearFilter;

    /**
     * Текст показать ещё/скрыть элементы фильтра
     */
    public SelenideElement getOpenCloseMore(String filter) {
        SelenideElement openCloseMore = $x("//*[contains(text(), '" + filter + "')]/../../..//p[contains(@class, 'show-all ng-star-inserted')]");
        return openCloseMore;
    }

    /**
     * Кнопка слайдера у фильтра
     */
    public SelenideElement getSliderFilterButton(String nameFilter) {
        SelenideElement buttonSlide = $x("//*[contains(text(), '" + nameFilter + "')]/../../../div[contains(@class, 'slider')]");
        return buttonSlide;
    }

    /**
     * Количество товаров при выбранном фильтре
     */
    public SelenideElement getCountFilterSlider(String nameFilter) {
        SelenideElement textCount = $x("//*[contains(text(), '" + nameFilter + "')]/../span[contains(@class, 'count')]");
        return textCount;
    }


    public SelenideElement getElement() {
        return ratingFilterTitle;
    }
}
