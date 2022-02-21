package lesson_3.homework;

public class AdvertisementButton implements Element{
    private String buttonColor;
    private String textButtonAdv;

    public AdvertisementButton(){

    }

    public AdvertisementButton(String adv, String color){
        this.textButtonAdv=adv;
        this.buttonColor=color;
    }

    public void setButtonColor(String color){
        buttonColor = color;
    }
    public String getButtonColor(){
        return buttonColor;
    }

    public void setTextButtonAdv(String text){
        textButtonAdv = text;
    }
    public String getTextButtonAdv(){
        return textButtonAdv;
    }

    public void click(){
        System.out.println("Клик на кнопку рекламки");
    };

    public String getType(){
        return this.getClass().toString();
    };
}
