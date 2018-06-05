import Lesson1.Factorial.ComputeFactorialLoop;
import Lesson1.Factorial.ComputeFactorialRecurent;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FactorialTest {
    private ComputeFactorialLoop computeFactorialLoop;
    private ComputeFactorialRecurent computeFactorialRecurent;

    @Before
    public void setup(){
        computeFactorialLoop = new ComputeFactorialLoop();
        computeFactorialRecurent = new ComputeFactorialRecurent();
    }

    @Test
    @Parameters({
            "3,6",
            "4,24",
            "1,1"})
    public void testFactorial(int a, int expected){
        int result = computeFactorialLoop.computeFactorialLoop(a);
        Assert.assertEquals(expected,result);
    }
    @Test
    @Parameters({
            "3,6",
            "4,24",
            "1,1"})
    public void testFactorialRecurent(int a, int expected){
        int result = computeFactorialRecurent.computeFactorial(a);
        Assert.assertEquals(expected,result);
    }
}
