import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: sahuja
 * Date: 6/10/14
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class QTest {

    private Q q;

    @Before
    public void setUp() throws Exception {
        q = new Q();
    }

    @Test
    public void createAnEmptyQ() throws Exception {
        assertEquals(0, q.size());
    }

    @Test
    public void pushOneWillIncrementSizeByOne() throws Exception {
        q.push(10);
        assertEquals(1, q.size());
    }

    @Test
    public void pushXAndPop_willReturnX() throws Exception {
        q.push(10);
        assertEquals(10, q.pop());
    }

    @Test
    public void qIsFifo() throws Exception {
        q.push(10);
        q.push(11);
        q.push(12);
        q.push(13);
        assertEquals(10, q.pop());
        assertEquals(11, q.pop());
        assertEquals(12, q.pop());
        assertEquals(13, q.pop());
        assertEquals(0, q.size());
    }

    @Test(expected = Q.Underflow.class)
    public void popThrowsUnderflowOnEmptyQ() throws Exception {
        q.pop();
    }

    @Test(expected = Q.Underflow.class)
    public void popThrowsUnderflowWhenQIsEmptied() throws Exception {
        q.push(1);
        q.pop();
        q.pop();
    }

    @Test(expected = Q.Overflow.class)
    public void pushThrowsOverflowWhenQIsFull() throws Exception {
        q.push(10);
        q.push(10);
        q.push(10);
        q.push(10);
        q.push(10);
    }

    @Test
    public void qCanTakeMoreThan4ElementsIfSpaceIsAvailable() throws Exception {
        q.push(10);
        q.push(10);
        q.push(10);
        q.push(10);
        q.pop();
        q.push(11);
    }
}
