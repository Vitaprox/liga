package lesson_3.homework;

public class Advertisement implements Element{
    private String productAdv;
    private String iconDescriptionAdv;

    public Advertisement(){

    }

    public Advertisement(String icon, String adv){
        this.iconDescriptionAdv = icon;
        this.productAdv=adv;
    }

    public void setProductAdv(String prod){
        productAdv = prod;
    }
    public String getProductAdv(){
        return productAdv;
    }

    public void setIconDescriptionAdv(String icon){
        iconDescriptionAdv = icon;
    }
    public String getIconDescriptionAdv(){
        return iconDescriptionAdv;
    }

    public String getType(){
        return this.getClass().toString();
    };

    public void click(){
        System.out.println("Клик на рекламку");
    };


}
