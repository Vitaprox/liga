package lesson_3.homework;

public class Search extends Category{
    private int width;

    public Search(){

    }

    public Search(String icon, String name, int newWidth){
        this.iconDescription = icon;
        this.name = name;
        this.width = newWidth;
    }

    public void setWidth(int newWidth){
        width = newWidth;
    }
    public int getWidth(){
        return width;
    }

    public void open(){
        System.out.println("Открыта поисковая строка");
    }

    public void click(){
        System.out.println("Клик на поле поиска");
    };
}
