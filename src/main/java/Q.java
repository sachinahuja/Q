import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sahuja
 * Date: 6/10/14
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class Q {

    private int[] elements = new int[4];

    private int popPointer;
    private int pushPointer;

    public int size() {
        return pushPointer - popPointer;
    }

    public void push(int element) {
        if(size() == elements.length)
            throw new Overflow();

        elements[pushPointer++] = element;
    }

    public int pop() {
        if(size() == 0)
            throw new Underflow();

        return elements[popPointer++];
    }

    public class Underflow extends RuntimeException {
    }

    public class Overflow extends RuntimeException{
    }
}
