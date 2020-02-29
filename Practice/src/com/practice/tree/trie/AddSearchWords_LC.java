package com.practice.tree.trie;

public class AddSearchWords_LC {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AddSearchWords_LC o = new AddSearchWords_LC();

        o.insert("a");
        o.insert("ab");
        o.insert("bad");
        o.insert("dad");
        o.insert("mad");
        System.out.println(o.search("a"));
        System.out.println(o.search("ab"));
        System.out.println(o.search("pad"));
        System.out.println(o.search("bad"));
        System.out.println(o.search(".ad"));
        System.out.println(o.search("b.."));
        // true
        System.out.println(o.search("foo")); // true
        System.out.println(o.search("foc")); // false
        System.out.println(o.search("fo")); // false
        System.out.println(o.search("b.r")); // true
        System.out.println(o.search("ba.")); // true
        System.out.println(o.search(".ax")); // true
    }

    TrieNode root = new TrieNode(' ');

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.children[ch - 'a'];
            if (child == null) {
                child = new TrieNode(ch);
                current.children[ch - 'a'] = child;
            }
            current = child;
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int i) {
        if (i == word.length())
            return node.isEnd;

        char c = word.charAt(i);
        if (c == '.') {
            for (int cc = 0; cc < node.children.length; cc++) {
                if (node.children[cc] != null) {
                    TrieNode child = node.children[cc];
                    if (dfs(child, word, i + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            TrieNode child = node.children[c - 'a'];
            return child == null ? false : dfs(child, word, i + 1);
        }
    }

    static class TrieNode {
        char content;
        // Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode(char content) {
            this.content = content;

        }

        @Override
        public String toString() {
            return "TrieNode [content=" + content + ", children=" + children + ", isEnd=" + isEnd + "]";
        }

    }
}
