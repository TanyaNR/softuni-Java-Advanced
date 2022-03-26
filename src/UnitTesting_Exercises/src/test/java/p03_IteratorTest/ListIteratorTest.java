package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    public ListIterator listIterator;
    private static final String[] ELEMENTS = {"one", "tow", "three"};

    @Before
    public void createConstructor() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testCreateConstructorNullParameter() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testMoveElementIfHasNextIndex() {
        //currentIndex -> 0
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //currentIndex -> 1
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //currentIndex -> 2
        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        new ListIterator(null);
        listIterator.print();
    }

    @Test
    public void testPrintElementIfHasNextIndex() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.print();
    }
}
