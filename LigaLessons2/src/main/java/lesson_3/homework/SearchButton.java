package lesson_3.homework;

public class SearchButton extends Search{
    private String imgSearch;

    public SearchButton(){

    }

    public SearchButton(int newWidth, int newHeight, String newColor, String newImg){
        this.width = newWidth;
        this.height = newHeight;
        this.backColor = newColor;
        this.imgSearch = newImg;
    }

    public void setImgSearch(String newImgSearch){
        imgSearch = newImgSearch;
    }
    public String getImgSearch(){
        return imgSearch;
    }

    public void click(){
        System.out.println("Клик на кнопку поиска");
    };
}
