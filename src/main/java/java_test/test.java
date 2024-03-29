package java_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(4);
        System.out.println(pq.poll());
        System.out.println(pq.element());
        System.out.println(pq.element());
    }
}
