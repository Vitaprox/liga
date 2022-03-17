package ru.digitalleague;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.digitalleague.storage_example.Storage;

public class TestRemove extends BeforeAndAfter {

    /**
     * Проверка удаления
     */
    @Test
    public void removeObject() {
        Storage.removeObject("flashlight");
        Assert.assertFalse(Storage.storage.containsKey("flashlight"));
    }

    /**
     * Проверка удаление того, чего и не было
     */
    @Test
    public void removeNotFoundTest() {
        Assert.assertFalse(Storage.removeObject("pencil"));
    }
}
