package java_test;

import java.util.*;

class tmp{
    public int value;
    public tmp(int value){
        this.value = value;
    }

    public boolean equals(tmp obj) {
        return this.value == obj.value;
    }
}
public class test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 2);
        map.put(2, 3);
        System.out.println(map);
    }
}
