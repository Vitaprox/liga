package steps;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.HeaderPage;
import pages.ListingPage;


public class ListingSteps {
    private HeaderPage headerPage = Selenide.page(new HeaderPage());
    private ListingPage listingPage = Selenide.page(new ListingPage());


    public void checkNameProductsContainsApple(){
        Assert.assertTrue(listingPage.checkContainsInNameProd("apple"), "В названии товаров нет слова apple");
    }

    public void checkSortDropdownIdDisplayed(){
        Assert.assertTrue(listingPage.checkSortDropdownIdDisplayed(), "Выпадающий список не отображается");
    }

    public void checkTextSortDropdownMostPopular(){
        Assert.assertEquals(listingPage.getTextSortDropdown(),"Сначала популярные", "В дроплисте неправильный текст");
    }

    public void clickSortDropdown(){
        listingPage.clickSortDropdown();
        listingPage.checkSortDropdownOptionsIsVisible();
    }

    public void clickSortDropDownOptionDecreasingPrice(){
        listingPage.clickSortDropdownOption("Сначала дороже");
        Assert.assertEquals(listingPage.getTextSortDropdown(), "Сначала дороже", "Отображается выбор неправильного фильтра");
    }


    public void checkSortPriceDecrease(){
        Assert.assertTrue(listingPage.checkSortPriceDecrease(), "Сортировка неправильная");
    }

    public void clickThreeProductComparison(){
        listingPage.writeCartProductsComparison();
        listingPage.clickProductIcon(1);
        listingPage.clickProductIcon(2);
        listingPage.clickProductIcon(3);
        listingPage.shouldBeIconButtonActive(3);
        headerPage.shouldBeComparisonCount("3");
    }

    public void clickThreeProductFavorite(){
        listingPage.writeCartProductsFavorite();
        listingPage.clickProductIcon(1);
        listingPage.clickProductIcon(2);
        listingPage.clickProductIcon(3);
        headerPage.shouldBeFavoriteCount("3");
        listingPage.shouldBeIconButtonActive(3);
    }

}
