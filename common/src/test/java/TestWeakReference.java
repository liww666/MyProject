import com.sunyard.myproject.reference.ValueContainer;
import com.sunyard.myproject.reference.WeakReferenceStack;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 2018/9/26.
 */
public class TestWeakReference {
    @Test
    public void weakReferenceStackManipulation() {
        final WeakReferenceStack<ValueContainer> stack = new WeakReferenceStack<>();
        final ValueContainer expected = new ValueContainer("Value for the stack");
        stack.push(new ValueContainer("Value for the stack"));
        ValueContainer peekedValue = stack.peek();
        System.out.println(expected == peekedValue);
        System.out.println(expected== stack.peek());
        peekedValue = null;
        System.gc();
        System.out.println(stack.peek());
    }

    /*
    When the JVM terminates, it is possible to have some code run before it exits, similar to the
finalize method running before an object is garbage collected. Shutdown hooks are references to
Thread objects; you can add a new reference by calling the addShutdownHook method on the current
Runtime instance.
     */
    @Test
    public void addShudownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println(
                        "Shutting down JVM at time: " + new Date());
            }
        });
    }
}
