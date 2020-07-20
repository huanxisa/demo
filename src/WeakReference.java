import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class WeakReference {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
//        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

//        System.out.println(o1);
//        System.out.println(referenceQueue.poll());
//        System.out.println(weakReference.get());

    }
}
