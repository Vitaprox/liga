package ru.digitalleague;

import org.junit.After;
import org.junit.Before;
import ru.digitalleague.storage_example.Storage;

public class BeforeAndAfter {
    @Before
    public void setUp() {
        Storage.addObject("flashlight", 5);
        Storage.addObject("pen", 9);
    }

    @After
    public void clearStorage() {
        Storage.storage.clear();
    }
}
