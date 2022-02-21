package lesson_3.homework;

public abstract class Category implements Element{
    protected String iconDescription;
    protected String name;

    public String getType(){
        return this.getClass().toString();
    };

    public abstract void open();

    public void setIconDescription(String iconDesc) {
        iconDescription = iconDesc;
    }
    public String getIconDescription(){
        return iconDescription;
    }

    public void setName(String newName) {
        name = newName;
    }
    public String getName(){
        return iconDescription;
    }
}
