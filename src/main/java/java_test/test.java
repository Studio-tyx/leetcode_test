package java_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
class tmp{
    public int value;
    public tmp(int value){
        this.value = value;
    }
}
public class test {
    public static void main(String[] args) {
        Comparator<tmp> comparator = new Comparator<tmp>() {
            @Override
            public int compare(tmp o1, tmp o2) {
                return o1.value-o2.value;
            }
        };

        tmp t1 = new tmp(1);
        tmp t2 = new tmp(2);
        tmp[] ts= new tmp[]{t2, t1};
        System.out.println(ts[0].value+","+ts[1].value);
        Arrays.sort(ts, comparator);
        System.out.println(ts[0].value+","+ts[1].value);

        ArrayList<tmp> tt = new ArrayList<>();
        tt.add(t2);
        tt.add(t1);
        System.out.println(tt.get(0).value+","+tt.get(1).value);
        tt.sort(comparator);
        System.out.println(tt.get(0).value+","+tt.get(1).value);

    }
}
