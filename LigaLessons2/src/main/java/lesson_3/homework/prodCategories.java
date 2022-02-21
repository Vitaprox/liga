package lesson_3.homework;

public class prodCategories extends Category{

    private String pathImg;

    public prodCategories(){

    }

    public prodCategories(String icon, String name, String img){
        this.iconDescription = icon;
        this.name = name;
        this.pathImg = img;
    }

    public void setPathImg(String countPrd){
        pathImg = countPrd;
    }
    public String getPathImg(){
        return pathImg;
    }

    public void open(){
        System.out.println("Открыт раздел продукта");
    }

    public void click(){
        System.out.println("Клик на тип товаров");
    };
}
