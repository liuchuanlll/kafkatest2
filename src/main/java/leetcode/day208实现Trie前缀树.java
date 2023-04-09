package leetcode;
class TrieNode {
    boolean end;
    TrieNode[] tns = new TrieNode[26];
}
public class day208实现Trie前缀树 {

    TrieNode root;
    public day208实现Trie前缀树() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for(int i=0;i<word.length();i++){
            int u = word.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p=p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for(int i=0;i<word.length();i++){
            int u = word.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p=p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i=0;i<prefix.length();i++){
            int u = prefix.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p=p.tns[u];
        }
        return true;
    }
}
