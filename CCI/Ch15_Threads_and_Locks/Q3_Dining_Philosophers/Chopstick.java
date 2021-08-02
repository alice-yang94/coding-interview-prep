import java.util.concurrent.locks.*;

public class Chopstick {
    
    private Lock lock;
    private int id;

    public Chopstick(int id) {
        lock = new ReentrantLock();
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
