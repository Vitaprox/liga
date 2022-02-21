package lesson_3.homework;

public class Search implements Element{
    protected int width;
    protected int height;
    protected String backColor;

    public Search(){

    }

    public Search(int newWidth, int newHeight, String newColor){
        this.width = newWidth;
        this.height = newHeight;
        this.backColor = newColor;
    }

    public void setWidth(int newWidth){
        width = newWidth;
    }
    public int getWidth(){
        return width;
    }

    public void setHeight(int newHeight){
        height = newHeight;
    }
    public int getHeight(){
        return height;
    }

    public void setBackColor(String newBackColor){
        backColor = newBackColor;
    }
    public String getBackColor(){
        return backColor;
    }


    public void click(){
        System.out.println("Клик на поле поиска");
    };

    public String getType(){
        return this.getClass().toString();
    };
}
