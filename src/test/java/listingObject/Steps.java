package listingObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Steps {
    private Filters filters = Selenide.page(new Filters());
    private Products products = Selenide.page((new Products()));

    public void clickCheckBoxFilter(String filterName, int checkBoxNumber) {
        filters.getCheckBoxFilter(filterName, checkBoxNumber).scrollIntoView("{ behavior: 'auto', block: 'center', inline: 'center'}").click();
    }

    public void clickRadioFilter(String nameOption) {
        filters.getSliderFilterButton(nameOption).scrollIntoView("{ behavior: 'auto', block: 'center', inline: 'center'}").click();
    }

    public void clickViewSwitcher() {
        products.getViewSwitcher().click();
    }


    /**
     * Работает только при расположенных товаров списком, а не блочной раскладкой, так как ориентируется на контейнеры карточек
     */
    public void searchProduct(String nameProduct) {

        /**Если метод совсем перестал работать (хотя у меня работал), рекомендуется поставить после этого комментария слип на несколько секунд*/


        do {
            Selenide.sleep(500);
            if (!$x("//div[contains(@class, 'product-cards-layout--loading')]").isDisplayed()) break;
        } while (true);

        /**Проверка, что подгрузилось название*/
        $x("//a[contains(@class, 'product-title__text')]").shouldBe(visible);

        int pageMax;
        if ($(By.className("page-item")).isDisplayed()) {
            ElementsCollection liPage = $$(By.className("page-item"));
            pageMax = Integer.parseInt(liPage.get(liPage.size() - 2).text());
        } else {
            pageMax = 1;
        }

        /**Начало цикла*/
        int i = 0;
        do {

            /**Проверка на отображение товаров, да, если её убрать метод часто ломается*/
            $x("//div[contains(@class, 'product-cards-layout__item')]").shouldBe(visible);

            /**Прокрутка по товаром, чтоб они начали отображаться*/
            ElementsCollection productsCarts = $$(By.className("product-cards-layout__item"));
            for (int j = 1; j < productsCarts.size(); j++) {
                productsCarts.get(j).scrollIntoView("{ behavior: 'auto', block: 'center', inline: 'center'}");
            }

            /**Поиск нужного названия*/
            SelenideElement productPath = $x("//a[contains(@class, 'product-title__text') and contains(text(), '" + nameProduct + "')]");

            /**Если найден, брик, если нет, крутим до конца*/
            if (productPath.isDisplayed()) {
                productPath.scrollIntoView("{ behavior: 'auto', block: 'center', inline: 'center'}");
                System.out.println("Товар найден");
                break;
            } else {
                i++;
                if (i != pageMax)
                    products.getForwardArrowPagination().shouldBe(visible).click();
                if (i == pageMax) {
                    System.out.println("Товар не найден");
                }

            }


        } while (i < pageMax);


    }

}
