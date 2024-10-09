package true_test.honor_1009;

import java.util.*;

public class Main {
    public void problem_1(){
        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
        List<String> legalList = new ArrayList<>();
        Set<String> legalSet = new HashSet<>();
        List<String> illegalList = new ArrayList<>();

//        while(!line.isEmpty()){
        while(in.hasNextLine()){
            String line = in.nextLine();
            boolean flag = true;
            for(int i = 0; i < line.length(); i++){
                char ch = line.charAt(i);
                if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){

                }
                else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(!legalSet.contains(line)){
                    legalSet.add(line);
                    legalList.add(line);
                }
            }
            else{
                illegalList.add(line);
            }
//            line = in.nextLine();
        }
        boolean flag = true;
        for(String str:legalList){
            if(flag) {
                System.out.print(str);
                flag = false;
            }
            else System.out.print(" "+str);
        }
        System.out.println();
        flag = true;
        for(String str:illegalList){
            if(flag){
                System.out.print(str);
                flag = false;
            }
            else System.out.print(" "+str);
        }
        System.out.println();
    }
    public void problem_2(){
        Scanner in = new Scanner(System.in);
        if(in.hasNextLine()){
            String line = in.nextLine();
            if(line.isEmpty()) return;
            String lowerCase = line.toLowerCase();
            int[] countChar = new int[26];
            int[] countNum = new int[10];
            for(int i = 0; i < lowerCase.length(); i++){
                char ch = lowerCase.charAt(i);
                countChar[ch - 'a'] ++;
            }
            while(countChar['z' - 'a'] != 0){
                countChar['z' - 'a'] --;
                countChar['e' - 'a'] --;
                countChar['r' - 'a'] --;
                countChar['o' - 'a'] --;
                countNum[0] ++;
            }
            while(countChar['w' - 'a'] != 0){
                countChar['t' - 'a'] --;
                countChar['o' - 'a'] --;
                countChar['w' - 'a'] --;
                countNum[2] ++;
            }
            while (countChar['u' - 'a'] != 0){
                countChar['u' - 'a'] --;
                countChar['f' - 'a'] --;
                countChar['o' - 'a'] --;
                countChar['r' - 'a'] --;
                countNum[4] ++;
            }
            while (countChar['x' - 'a'] != 0){
                countChar['s' - 'a'] --;
                countChar['i' - 'a'] --;
                countChar['x' - 'a'] --;
                countNum[6] ++;
            }
            while (countChar['g' - 'a'] != 0){
                countChar['e' - 'a'] --;
                countChar['i' - 'a'] --;
                countChar['g' - 'a'] --;
                countChar['h' - 'a'] --;
                countChar['t' - 'a'] --;
                countNum[8] ++;
            }
            while (countChar['h' - 'a'] != 0){
                countChar['t' - 'a'] --;
                countChar['h' - 'a'] --;
                countChar['r' - 'a'] --;
                countChar['e' - 'a'] --;
                countChar['e' - 'a'] --;
                countNum[3] ++;
            }
            while (countChar['f' - 'a'] != 0){
                countChar['f' - 'a'] --;
                countChar['i' - 'a'] --;
                countChar['v' - 'a'] --;
                countChar['e' - 'a'] --;
                countNum[5] ++;
            }
            while (countChar['v' - 'a'] != 0){
                countChar['s' - 'a'] --;
                countChar['e' - 'a'] --;
                countChar['v' - 'a'] --;
                countChar['e' - 'a'] --;
                countChar['n' - 'a'] --;
                countNum[7] ++;
            }
            while (countChar['o' - 'a'] != 0){
                countChar['o' - 'a'] --;
                countChar['n' - 'a'] --;
                countChar['e' - 'a'] --;
                countNum[1] ++;
            }
            while (countChar['e' - 'a'] != 0){
                countChar['n' - 'a'] --;
                countChar['i' - 'a'] --;
                countChar['n' - 'a'] --;
                countChar['e' - 'a'] --;
                countNum[9] ++;
            }
            StringBuilder out = new StringBuilder();
            for(int i = 0; i < 10; i++){
                while(countNum[i] != 0){
                    out.append(i);
                    countNum[i] --;
                }
            }
            System.out.println(out);
        }
    }
    public void problem_3(){
        Scanner in = new Scanner(System.in);
        Map<String, Integer> name2step = new HashMap<>();
        List<String> yueshu2 = new ArrayList<>();
        List<String> yueshu3 = new ArrayList<>();
        List<String> yueshu4 = new ArrayList<>();
        List<String> yueshu5 = new ArrayList<>();
        Map<String, Integer> shunxu = new HashMap<>();
        int ii = 0;
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(line.isEmpty()) break;
            String[] infos = line.split(":");
            String name = infos[0];
            String[] stepString = infos[1].split(" ");
            int[] steps = new int[stepString.length];
            int count_sanwan = 0, count_yiwan = 0, count_wuqian = 0, total_step = 0;
            int sanwan_index = -5;
            boolean yueshu2flag = true;
            shunxu.put(name, ii++);
            for(int i = 0; i < stepString.length; i ++){
                steps[i] = Integer.parseInt(stepString[i]);
                if(steps[i] > 30000){
                    if(i - sanwan_index <= 4) yueshu2flag = false;
                    count_sanwan ++;
                    sanwan_index = i;
                }
                else if(steps[i] > 10000) count_yiwan ++;
                else if(steps[i] > 5000) count_wuqian ++;
                total_step += steps[i];
            }
            name2step.put(name, total_step);
            if(count_sanwan >= 4 && yueshu2flag){
                yueshu2.add(name);
            }
            else if(count_yiwan + count_sanwan >= 15){
                yueshu3.add(name);
            }
            else if(count_wuqian >= 15){
                yueshu4.add(name);
            }
            else {
                yueshu5.add(name);
            }
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(name2step.get(o1).equals(name2step.get(o2))){
                    return shunxu.get(o1) - shunxu.get(o2);
                }
                return -(name2step.get(o1) - name2step.get(o2));
            }
        };
        yueshu2.sort(c);
        yueshu3.sort(c);
        yueshu4.sort(c);
        yueshu5.sort(c);
        if(yueshu2.isEmpty() && yueshu3.isEmpty() && yueshu4.isEmpty() && yueshu5.isEmpty()){
            System.out.print("There is no data.\n");
            return;
        }
        if(yueshu2.isEmpty() && yueshu3.isEmpty()){
            System.out.print("excellent is null\n");
        }
        else{
            for(String name:yueshu2){
                System.out.print(name + ":excellent " + name2step.get(name) + "\n");
            }
            for(String name:yueshu3){
                System.out.print(name + ":excellent " + name2step.get(name) + "\n");
            }
        }
        if(yueshu4.isEmpty()){
            System.out.print("good is null\n");
        }
        else{
            for(String name:yueshu4){
                System.out.print(name + ":good " + name2step.get(name) + "\n");
            }
        }
        if(yueshu5.isEmpty()){
            System.out.print("bad is null\n");
        }
        else{
            for(String name:yueshu5){
                System.out.print(name + ":bad " + name2step.get(name) + "\n");
            }
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
//        m.problem_1();
//        m.problem_2();
        m.problem_3();
    }
}
