package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSortedElement() {
        int[] arr = {8, 4, 9, 3, 1};
        int[] sortedArr = {1, 3, 4, 8, 9};
        Bubble.sort(arr);
        Assert.assertArrayEquals(arr, sortedArr);
    }
}
