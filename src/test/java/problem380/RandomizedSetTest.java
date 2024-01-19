package problem380;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(0));
        System.out.println(set.remove(0));
        System.out.println(set.insert(-1));
        System.out.println(set.remove(0));
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
    }

}