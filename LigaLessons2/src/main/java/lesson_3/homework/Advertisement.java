package lesson_3.homework;

public class Advertisement extends Category{
    protected String productAdv;

    public Advertisement(){

    }

    public Advertisement(String icon, String name, String adv){
        this.iconDescription = icon;
        this.name=name;
        this.productAdv=adv;
    }

    public void setProductAdv(String prod){
        productAdv = prod;
    }
    public String getProductAdv(){
        return productAdv;
    }

    public void open(){
        System.out.println("Открыто окно рекламы");
    }

    /*public String getType(){
        return this.getClass().toString();
    };*/

    public void click(){
        System.out.println("Клик на рекламку");
    };

}
