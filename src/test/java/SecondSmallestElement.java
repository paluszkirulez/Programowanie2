import Lesson1.SecondSmallest.FindSecondSmallest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecondSmallestElement {
    private FindSecondSmallest findSecondSmallest;

    @Before
    public void setup() { findSecondSmallest = new FindSecondSmallest();}

    @Test
    public void testNormalArray(){
        Assert.assertEquals(5, findSecondSmallest.checkElement(new int[]{1,5,10,15,12}));
    }
    @Test
    public void testArrayofSameElements(){
        Assert.assertEquals(1, findSecondSmallest.checkElement(new int[]{1,1,1,1,1,1}));
    }
    @Test
    public void testDifferentArray(){
        Assert.assertEquals(5, findSecondSmallest.checkElement(new int[]{12,15,10,5,1}));
    }

    @Test
    public void testTwoElementsArray(){
        Assert.assertEquals(2, findSecondSmallest.checkElement(new int[]{2,1}));
    }
    @Test
    public void testOneElementsArray(){
        Assert.assertEquals(2, findSecondSmallest.checkElement(new int[]{2}));
    }
}
