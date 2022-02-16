package lesson_3.homework;

public class PlusElement extends Category{
    private String plusDescription;

    public PlusElement(){

    }

    public PlusElement(String icon, String name, String desc){
        this.iconDescription = icon;
        this.name = name;
        this.plusDescription = desc;
    }

    public void setPlusDescription(String descriptionPls){
        plusDescription = descriptionPls;
    }
    public String getPlusDescription(){
        return plusDescription;
    }

    public void open(){
        System.out.println("Открыт элемент плюсов нашего сайта");
    }

    public void click(){
        System.out.println("Клик на элемент плюсов сайта");
    };
}
