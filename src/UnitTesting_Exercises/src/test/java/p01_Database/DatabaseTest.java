package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public Database database;
    public static final Integer[] NUMBERS = {5, 10, 15, 20, 25};

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void prepareCreateConstructorHasValidElements() {
        Integer[] elements = database.getElements();
        Assert.assertArrayEquals(elements, NUMBERS);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorTrowExceptionWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[]numbers = new Integer[17];
        new Database(numbers);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorTrowExceptionWhenLessOneElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test
    public void testAddShouldAddElements() throws OperationNotSupportedException {
        database.add(50);
        Integer[]elements = database.getElements();
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(50));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddTrowExceptionWhenElementIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length - 1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(20));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveElementWhenElementsIsNull() throws OperationNotSupportedException {
//        database = new Database(null);
        Integer[] elements = database.getElements();
        for (int i = 0; i < elements.length; i++) {
            database.remove();
        }
        database.remove();
    }

}
