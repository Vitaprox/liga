package steps;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.BasketPage;
import patternWebElement.CartProductsElements;

public class BasketPageSteps {
    private BasketPage basketPage = Selenide.page(new BasketPage());

    /**Сверяем товар на текущей страницей с названием того товара, у которого нажимали кнопку купить*/
    public void checkProductInBasket(){
        Assert.assertTrue(basketPage.checkCartProductIsDisplayed(CartProductsElements.products.get(0).name),"В корзине не тот товар");
    }

    /**Проверка отображается ли кнопка оформления заказа*/
    public void checkOrderButtonIsDisplayed(){
        Assert.assertTrue(basketPage.checkSetAnOrderButtonIsDisplayed(), "Кнопка заказа не отображается");
    }

    /**Проверка, что в корзине один товар*/
    public void checkNumberOfProducts(){
        Assert.assertEquals(basketPage.getNumberOfProductsText(), "В корзине 1 товар", "Другое количество товара в корзине");
    }

    /**Проверка равна ли сумма одного товара и сумма заказа*/
    public void checkPriceBasket(){
        Assert.assertEquals(CartProductsElements.products.get(0).price,basketPage.getCartPriceInt(), basketPage.getOrderPriceInt(), "Сумма товара, на который кликнули, того который в карточке и заказа не равны");
        CartProductsElements.clearCartList();
    }

    /**Проверка те ли товары попали в корзину, на которые мы кликнули*/
    public void checkNamesProductsInBasket(){
        Assert.assertTrue(basketPage.checkNamesProductsInBasket(), "Товары в корзине не те, что мы выбрали");
    }

    /**Проверка ровняется ли сумма стоимости всех товаров цене заказа*/
    public void checkSumOrder(){
        Assert.assertEquals(CartProductsElements.products.get(0).price+CartProductsElements.products.get(1).price, basketPage.getOrderPriceInt(), "Ошибка в сумме заказа");
        CartProductsElements.clearCartList();
    }

    public void checkBasketTitle(){
        boolean checkBasketTitleIdDisplayed = basketPage.checkBasketTitle();
        Assert.assertTrue(checkBasketTitleIdDisplayed, "Заголовок 'Моя корзина' не отображается");
    }
}
