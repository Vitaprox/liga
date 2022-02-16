package lesson_3.homework;

public class AdvertisementButton extends Advertisement{
    private String buttonColor;

    public AdvertisementButton(){

    }

    public AdvertisementButton(String icon, String name, String adv, String color){
        this.iconDescription = icon; //переменная родителя родителя
        this.name=name; //переменная родителя родителя
        this.productAdv=adv; //переменная родителя
        this.buttonColor=color; //своя переменная
    }

    public void setButtonColor(String color){
        buttonColor = color;
    }
    public String getButtonColor(){
        return buttonColor;
    }

    public void open(){
        System.out.println("Открыта кнопка рекламы");
    }

    public void click(){
        System.out.println("Клик на кнопку рекламки");
    };
}
