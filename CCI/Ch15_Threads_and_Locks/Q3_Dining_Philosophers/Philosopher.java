import java.lang.Thread;

public class Philosopher implements Runnable {
    
    private int bites = 10;
    private Chopstick left, right;
    
    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
        if (left.getID() > right.getID()) {
            this.left = right;
            this.right = left;
        }
    }

    public void chew(int i) {
        String tname = Thread.currentThread().getName();
        System.out.println(String.format("%s is Chewing... %d", tname, i));
    }

    public boolean pickUp() {
        left.pickUp();
        try {
            String tname = Thread.currentThread().getName();
            System.out.println(String.format("%s is sleeping...", tname));
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        right.pickUp();
        return true;
    }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    public void eat(int i) {
        pickUp();
        chew(i);
        putDown();
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat(i);
        }
    }

}
