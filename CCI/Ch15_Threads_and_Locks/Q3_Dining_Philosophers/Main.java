import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int chopNum = 5;
        int philNum = 5;
        
        /* create chopsticks */
        
        ArrayList<Chopstick> chops = new ArrayList<>();
        for (int i = 0; i < chopNum; i++) {
            chops.add(new Chopstick(i));
        }

        /* create philosophers */
        
        ArrayList<Philosopher> phils = new ArrayList<>();
        for (int i = 0; i < philNum; i++) {
            Chopstick left;
            if (i == 0) {
                left = chops.get(chopNum-1);
            } else {
                left = chops.get(i-1);
            }
            Chopstick right = chops.get(i);
            phils.add(new Philosopher(left, right));
        }

        /* create threads */
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < philNum; i++) {
            threads.add(new Thread(phils.get(i), String.format("Thread %d", i)));
        }

        /* start dining */
        for (Thread t : threads){
            t.start();
        }
    }
}
