package leetcode.problem208;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {
    class TreeNode{
        char val;
        Map<Character, TreeNode> children;
        public TreeNode(char val, Map<Character, TreeNode> children){
            this.val = val;
            this.children = children;
        }
    }
    public TreeNode head;
    public Trie() {
        head = new TreeNode('0', new HashMap<>());
    }
    public void insert(String word) {
        TreeNode cur = head;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cur.children.containsKey(ch)){
                cur = cur.children.get(ch);
            }else {
                TreeNode tmp = new TreeNode(ch, new HashMap<>());
                cur.children.put(ch, tmp);
                cur = tmp;

            }
        }
        cur.children.put('0', null);
    }

    public boolean search(String word) {
        TreeNode cur = head;
        boolean res = true;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)){
                res = false;
                break;
            }
            else{
                cur = cur.children.get(ch);
            }
        }
        if (!cur.children.containsKey('0')) res = false;
        return res;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = head;
        boolean res = true;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if (!cur.children.containsKey(ch)){
                res = false;
                break;
            }
            else{
                cur = cur.children.get(ch);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("bear");
        trie.insert("add");
//        System.out.println(trie.search("ap"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apps"));
    }
}