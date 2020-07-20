import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class WeakReference {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> objectPhantomReference = new PhantomReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(objectPhantomReference.get());

        System.out.println("=================");

        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(objectPhantomReference.get());

    }
}
