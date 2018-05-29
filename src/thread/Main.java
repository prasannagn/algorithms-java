package thread;

//t.join and t has runtime exception
public class Main {
    public static void main(String[] args) {

        Thread t = new Thread(()->{
            try {
                System.out.println("In T");
                Thread.sleep(1000);
                throw new RuntimeException();
                //System.out.println("Done T");
            } catch (InterruptedException e) {
                System.out.println("Exception in T"+ e);
            }

        });

        try {
            t.start();
            t.join();
            System.out.println("Done");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

