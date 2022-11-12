package com.project.Trie;


class TrieNode{

    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}
public class Trie {
    private TrieNode root;
    private int numWords;

    public Trie() {
        root = new TrieNode('\0');// null character
        numWords = 0;
    }

    private void add(TrieNode root, String word) {//note
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';// subtracting ascii value 'n'-'a'
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;// we insert n in root children array n ki jo position hai vaha
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
        numWords++;
    }

    public boolean search(String word) {
        return search(root, word);

    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0)
            return root.isTerminating;
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }

    public void remove(String word) {
        remove(root, word);
        numWords--;
    }

    public void remove(TrieNode root, String word) {//initially root is null char
        if (word.length() == 0) {
            root.isTerminating = false;// bold node ko unbold kro
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;// we want to delete not but n doesn't present there then no need to find further
            // or we want to delete next word but there is no e when root is n
        }
        remove(child, word.substring(1));
        //we can remove child node only if it is non terminating and its number of children are 0
        if (!child.isTerminating && child.childCount == 0) {
            //we can delete child
            // in java there is garbage collector if there is chunk of memory which is not use by anyone then it will be deleted by GC
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
    }

    public int countWords() {
        return numWords;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("bat");
        t.add("no");
        t.add("not");
        System.out.println(t.numWords);
        //    System.out.println(t.search("bat"));
//        System.out.println(t.search("not"));
        //     t.remove("bat");
        //    System.out.println(t.search("bat"));
        t.remove("not");
        System.out.println(t.numWords);
        // System.out.println(t.search("no"));
    }
}
