package leetcode.problem721;

import java.util.*;

public class Solution {
    class UnionFind{
        Map<String, String> parent;
        public UnionFind(){
            parent = new HashMap<>();
        }
        public void add(String str){
            if (!parent.containsKey(str)) parent.put(str, str);
        }
        public String find(String str){
            if (parent.get(str).equals(str)) return str;
            String root = str;
            while (!parent.get(root).equals(root)){
                root = parent.get(root);
            }
            while(!parent.get(str).equals(root)){
                String next_str = parent.get(str);
                parent.put(str, root);
                str = next_str;
            }
            return root;
        }
        public void merge(String str1, String str2){
            String str1_source = find(str1);
            String str2_source = find(str2);
            if (!str1_source.equals(str2_source)){
                parent.put(str1_source, str2_source);
            }
        }
    }
    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        Map<String, String> mail_2_name = new HashMap<>();
        UnionFind uf = new UnionFind();
        for (List<String> account : accounts){
            String name = account.get(0);
            uf.add(account.get(1));
            for (int i = 1; i < account.size(); i++){
                uf.add(account.get(i));
                uf.merge(account.get(1), account.get(i));
                mail_2_name.put(account.get(i), name);
            }
        }
        Map<String, Queue<String>> parent_2_set = new HashMap<>();
        for(String mail : mail_2_name.keySet()){
            String root = uf.find(mail);
            Queue<String> tmp_set = parent_2_set.getOrDefault(root, new PriorityQueue<>());
            tmp_set.add(mail);
            parent_2_set.put(root, tmp_set);
        }
        List<List<String>> res = new ArrayList<>();
        for(String root_mail:parent_2_set.keySet()){
            List<String> tmp = new ArrayList<>();
            tmp.add(mail_2_name.get(root_mail));
            while (!parent_2_set.get(root_mail).isEmpty()){
                tmp.add(parent_2_set.get(root_mail).poll());
            }
            res.add(tmp);
        }
        return res;
    }

    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        Map<String, Integer> addr_2_idx = new HashMap<>();
        Map<Integer, String> idx_2_addr = new HashMap<>();
        Map<String, String> mail_2_name = new HashMap<>();
        int n = 0;
        for (List<String> account : accounts){
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++){
                if (!addr_2_idx.containsKey(account.get(i))) {
                    addr_2_idx.put(account.get(i), n);
                    idx_2_addr.put(n, account.get(i));
                    n ++;
                }
                mail_2_name.put(account.get(i), name);
            }
        }
        parent = new int[n];
        for (int i = 0; i < n; i ++){
            parent[i] = i;
        }
        for (List<String> account : accounts){
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++){
                idx_merge(addr_2_idx.get(account.get(1)),addr_2_idx.get(account.get(i)));
                mail_2_name.put(account.get(i), name);
            }
        }
        Map<Integer, Queue<String>> parent_2_set = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String addr : addr_2_idx.keySet()){
            int root = idx_find(addr_2_idx.get(addr));
            Queue<String> tmp_set = parent_2_set.getOrDefault(root, new PriorityQueue<>());
            tmp_set.add(addr);
            parent_2_set.put(root, tmp_set);
        }
        for(Integer idx:parent_2_set.keySet()){
            List<String> tmp = new ArrayList<>();
            tmp.add(mail_2_name.get(idx_2_addr.get(idx)));
            while (!parent_2_set.get(idx).isEmpty()){
                tmp.add(parent_2_set.get(idx).poll());
            }
            res.add(tmp);
        }
        return res;
    }

    public void idx_merge(int i1, int i2){
        int i1_root = idx_find(i1);
        int i2_root = idx_find(i2);
        if (i1_root != i2_root){
            parent[i1_root] = i2_root;
        }
    }
    public int idx_find(int i){
        if (parent[i] == i) return i;
        int root = i;
        while (parent[root] != root) root = parent[root];
        while (parent[i] != root){
            int next_i = parent[i];
            parent[i] = root;
            i = next_i;
        }
        return root;
    }
    public static void main(String[] args) {

        List<List<String>> data = new ArrayList<>();

//        List<String> list1 = new ArrayList<>();
//        list1.add("John");
//        list1.add("a1");
//        list1.add("b1");
//        List<String> list2 = new ArrayList<>();
//        list2.add("John");
//        list2.add("a1");
//        list2.add("c1");
//        data.add(list1); data.add(list2);

//        List<String> list1 = new ArrayList<>();
//        list1.add("John");
//        list1.add("johnsmith@mail.com");
//        list1.add("john_10@mail.com");
//        data.add(list1);
//        List<String> list2 = new ArrayList<>();
//        list2.add("John");
//        list2.add("johnnybravo@mail.com");
//        data.add(list2);
//        List<String> list3 = new ArrayList<>();
//        list3.add("John");
//        list3.add("johnsmith@mail.com");
//        list3.add("john_00@mail.com");
//        data.add(list3);
//        List<String> list4 = new ArrayList<>();
//        list4.add("Mary");
//        list4.add("mary@mail.com");
//        data.add(list4);


        List<String> list1 = new ArrayList<>();
        list1.add("David");
        list1.add("David0@m.co");
        list1.add("David4@m.co");
        list1.add("David3@m.co");
        data.add(list1);

        // 添加第二个列表
        List<String> list2 = new ArrayList<>();
        list2.add("David");
        list2.add("David5@m.co");
        list2.add("David5@m.co");
        list2.add("David0@m.co");
        data.add(list2);

        // 添加第三个列表
        List<String> list3 = new ArrayList<>();
        list3.add("David");
        list3.add("David1@m.co");
        list3.add("David4@m.co");
        list3.add("David0@m.co");
        data.add(list3);

        // 添加第四个列表
        List<String> list4 = new ArrayList<>();
        list4.add("David");
        list4.add("David0@m.co");
        list4.add("David1@m.co");
        list4.add("David3@m.co");
        data.add(list4);

        // 添加第五个列表
        List<String> list5 = new ArrayList<>();
        list5.add("David");
        list5.add("David4@m.co");
        list5.add("David1@m.co");
        list5.add("David3@m.co");
        data.add(list5);
        System.out.println(new Solution().accountsMerge(data));
    }
}
//[["David","David0@m.co","David4@m.co","David3@m.co"],
// ["David","David5@m.co","David5@m.co","David0@m.co"],
// ["David","David1@m.co","David4@m.co","David0@m.co"],
// ["David","David0@m.co","David1@m.co","David3@m.co"],
// ["David","David4@m.co","David1@m.co","David3@m.co"]]
