package lesson_3.homework;

public class Tests {
    public static void openAd(Search ad){
        System.out.println(ad.getType());
    }
    public static void main(String[] args) {
        //Проверка переоопределения методов
        Search ad = new Search();
        Search adb = new SearchButton();
        System.out.println(ad.getType());
        System.out.println(adb.getType());

        prodCategories a = new prodCategories();
        System.out.println(a.getType());



        //Полиморфизм
        Tests.openAd(ad);
        Tests.openAd(adb);

    }


}
