import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int max = 100;
        int min = 0;
        int range = max - min;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int randVal = (int)(Math.random()*range);
            list.add(randVal);
        }

        System.out.println(list);
        System.out.println(getRandomSubset(list));
        System.out.println(getRandomSubset(list));
        System.out.println(getRandomSubset(list));
    }

    private static List<Integer> getRandomSubset(List<Integer> list) {
        Random random = new Random();
        /** for each item, select and not select, equal chance */
        List<Integer> selected = list.stream().filter(
            integer -> {return random.nextBoolean();}
        ).collect(Collectors.toList());
        return selected;
    }

}
