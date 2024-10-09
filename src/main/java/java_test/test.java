package java_test;

import java.util.zip.*;
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

class test_thread extends Thread{
    public void run() {
        System.out.println("Thread is running");
    }

}
public class test {
    public static void main(String[] args) {
//        test_thread t = new test_thread();
//        t.start();
        String in = "1234";
        for(int i = 0; i < in.length(); i++){
            System.out.println(Integer.parseInt(String.valueOf(in.charAt(i))));
        }
    }
}
