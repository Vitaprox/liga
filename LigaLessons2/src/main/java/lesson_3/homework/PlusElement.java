package lesson_3.homework;

public class PlusElement implements Element{
    private String plusDescription;
    private String imgPath;

    public PlusElement(){

    }

    public PlusElement(String img, String desc){
        this.imgPath = img;
        this.plusDescription = desc;
    }

    public void setPlusDescription(String descriptionPls){
        plusDescription = descriptionPls;
    }
    public String getPlusDescription(){
        return plusDescription;
    }

    public void setImgPath(String img){
        imgPath = img;
    }
    public String getImgPath(){
        return imgPath;
    }

    public void click(){
        System.out.println("Ничего не произошло. Это же просто текст");
    };

    public String getType(){
        return this.getClass().toString();
    };
}
