package lesson_3.homework;

public class SearchButton extends Category{
    private String searchButtonColor;

    public SearchButton(){

    }

    public SearchButton(String icon, String name, String color){
        this.iconDescription = icon;
        this.name = name;
        this.searchButtonColor = color;
    }

    public void setSearchButtonColor(String color){
        searchButtonColor = color;
    }
    public String getSearchButtonColor(){
        return searchButtonColor;
    }

    public void open(){
        System.out.println("Открыта кнопка поиска");
    }

    public void click(){
        System.out.println("Клик на кнопку поиска");
    };
}
