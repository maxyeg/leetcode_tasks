package edu.leetcode.maxeg;

import edu.leetcode.maxeg.common.TrieNode;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (Character c : word.toCharArray()) {
            if (currentNode.getChildren().containsKey(c)) {
                currentNode = currentNode.getChildren().get(c);
            } else {
                TrieNode newChild = new TrieNode();
                currentNode.getChildren().put(c, newChild);
                currentNode = newChild;
            }
        }
        currentNode.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currentNode.getChildren().containsKey(word.charAt(i))) {
                return false;
            } else if (i == word.length() - 1) {
                return currentNode.getChildren().get(word.charAt(i)).isEndOfWord();
            } else {
                currentNode = currentNode.getChildren().get(word.charAt(i));
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!currentNode.getChildren().containsKey(prefix.charAt(i))) {
                return false;
            } else {
                currentNode = currentNode.getChildren().get(prefix.charAt(i));
            }
        }
        return true;
    }
}
