package gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Phantom {
    public static void main(String[] args) throws InterruptedException {
        SavePoint savePoint = new SavePoint("Random"); // a strong object

        ReferenceQueue<SavePoint> savepointQ = new ReferenceQueue<SavePoint>();// the ReferenceQueue
        LargeObjectFinalizer savePointPhantomReferenceRefernce = new LargeObjectFinalizer(savePoint, savepointQ);

        System.out.println("SavePoint created as a phantom ref " + savePointPhantomReferenceRefernce);
        Runtime.getRuntime().gc();
        System.out.println("Any phantom references in Q ? " + (savepointQ.poll() != null));
        savePoint = null; // the only strong reference has been removed. The heap
        // object is now only weakly reachable

        System.out.println("Now to call gc...");
        Runtime.getRuntime().gc(); // the object will be cleared here - finalize will be called.

        Reference<? extends SavePoint> s = savepointQ.remove();

        ((LargeObjectFinalizer)s).finalizeResources();



    }
}

 class LargeObjectFinalizer extends PhantomReference<SavePoint> {


    public LargeObjectFinalizer(
            SavePoint referent, ReferenceQueue<SavePoint> q) {
        super(referent, q);
    }

    public void finalizeResources() {
        // free resources
        System.out.println("clearing ...");
    }
}
