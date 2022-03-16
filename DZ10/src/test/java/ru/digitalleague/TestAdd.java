package ru.digitalleague;


import org.junit.Assert;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

public class TestAdd extends BeforeAndAfter {


    /**Проверка даст ли add добавить на полку больше 10 товаров*/
    /**
     * Данный тест первый, так как, если addObject работает неправильно, мы сразу об этом узнаем из-за того, что мы добавляем данные для его тестирования через него же
     */
    @Test
    public void AddOneItemAmountMaxTest() {

        /**Добавляем переменную, чтоб проветь по какому пути пошел тест и сравниваем количество, чтоб понять, что все работает успешно*/
        boolean flag = Storage.addObject("pen", 2);
        Assert.assertTrue(!flag && Storage.storage.get("pen") == 9);
    }

    /**
     * Проверка на добавление уже существующего товара
     */
    @Test
    public void AddOneItemAmountTest() {
        Storage.addObject("flashlight", 5);
        Assert.assertTrue(Storage.storage.get("flashlight") == 10);
    }

    /**
     * Проверка на добавление нового товара
     */
    @Test
    public void AddNewTest() {
        Storage.addObject("pencil", 7);

        /**Проверяем, что добавилось именно то знаечние и название, что мы задавали*/
        Assert.assertTrue(Storage.storage.containsKey("pencil") && Storage.storage.get("pencil") == 7);
    }

    /**
     * Проверка можно ли ввести новый товар с количеством больше 10
     */
    @Test
    public void AddNewOneItemAmountTest() {

        /**Переменная, чтоб понять по нужному ли пути идет программа*/
        boolean flag = Storage.addObject("pencil", 11);
        Assert.assertFalse(flag || Storage.storage.containsKey("pencil"));
    }


}
