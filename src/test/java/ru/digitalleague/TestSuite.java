package ru.digitalleague;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestAdd.class, TestAddNoFreeSpace.class, TestRemove.class})
public class TestSuite {
}
