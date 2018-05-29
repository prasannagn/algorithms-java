package gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

//If the garbage collector discovers an object that is weakly reachable, the following occurs:
    //The WeakReference object's referent field is set to null, thereby making it not refer to the heap object any longer.
    //The heap object that had been referenced by the WeakReference is declared finalizable.
    //The WeakReference object is added to its ReferenceQueue. Then the heap object's finalize() method is run and its memory freed.
//So what is this ReferenceQueue ?
    //When creating non-strong reference objects we have the option of passing a reference queue as a part of the Reference constructor. As seen from the above explanation, this reference queue is a way for the GC to inform the program that a certain object is no longer reachable. Consider the below example:
public class Week {

    public static void main(String[] args) throws InterruptedException {
        SavePoint savePoint = new SavePoint("Random"); // a strong object

        ReferenceQueue<SavePoint> savepointQ = new ReferenceQueue<SavePoint>();// the ReferenceQueue
        WeakReference<SavePoint> savePointWRefernce = new WeakReference<SavePoint>(savePoint, savepointQ);

        System.out.println("SavePoint created as a weak ref " + savePointWRefernce);
        Runtime.getRuntime().gc();
        System.out.println("Any weak references in Q ? " + (savepointQ.poll() != null));
        savePoint = null; // the only strong reference has been removed. The heap
        // object is now only weakly reachable

        System.out.println("Now to call gc...");
        Runtime.getRuntime().gc(); // the object will be cleared here - finalize will be called.
        System.out.println("Any weak references in Q ? " + (savepointQ.remove() != null));
        System.out.print(savePointWRefernce.get() != null);

    }
}

class SavePoint {

    private String str;
    public SavePoint(String str) {
        this.str = str;
    }

    public void cleanUp(){
        System.out.print(str);
    }
}