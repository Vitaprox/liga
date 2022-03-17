package ru.digitalleague;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

public class TestAddNoFreeSpace {
    @Before
    public void setUp() {
        Storage.addObject("flashlight", 5);
        Storage.addObject("pen", 9);
        Storage.addObject("pencil", 7);
    }

    @After
    public void clearStorage() {
        Storage.storage.clear();
    }

    /**
     * Проверка можно ли добавить новый товар, если три полки уже заняты
     */
    @Test
    public void addNoFreeSpace() {

        /**Переменная для того, чтоб понять, что программа идет нужным путем*/
        boolean flag = Storage.addObject("box", 5);
        Assert.assertFalse(flag || Storage.storage.containsKey("box"));
    }
}
