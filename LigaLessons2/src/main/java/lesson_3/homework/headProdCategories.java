package lesson_3.homework;

public class headProdCategories extends Category{
    private int countList;

    public headProdCategories(){

    }

    public headProdCategories(String icon, String name, int count){
        this.iconDescription = icon;
        this.name = name;
        this.countList = count;
    }

    public void setCountProd(int countPrd){
        countList = countPrd;
    }
    public int getCountProd(){
        return countList;
    }

    public void open(){
        System.out.println("Открыт раздел продукта");
    }

    public void click(){
        System.out.println("Клик на тип товаров");
    };

}
