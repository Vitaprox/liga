package lesson_3.homework;

public class Product extends Category{
    private int countProd;

    public Product(){

    }

    public Product(String icon, String name, int count){
        this.iconDescription = icon;
        this.name = name;
        this.countProd = count;
    }

    public void setCountProd(int countPrd){
        countProd = countPrd;
    }
    public int getCountProd(){
        return countProd;
    }

    public void open(){
        System.out.println("Открыт раздел продукта");
    }

    public void click(){
        System.out.println("Клик на тип товаров");
    };
}
