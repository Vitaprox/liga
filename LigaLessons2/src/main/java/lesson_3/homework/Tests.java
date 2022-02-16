package lesson_3.homework;

public class Tests {
    public static void openAd(Category ad){
        ad.open();
    }
    public static void main(String[] args) {
        //Проверка переоопределения методов
        Category ad = new Advertisement();
        Category adb = new AdvertisementButton();
        ad.open();
        adb.open();

        Product a = new Product();
        System.out.println(a.getType());



        //Полиморфизм
        Tests.openAd(ad);
        Tests.openAd(adb);

    }


}
