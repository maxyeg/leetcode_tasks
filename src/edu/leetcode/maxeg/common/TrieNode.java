package edu.leetcode.maxeg.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class TrieNode {
    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    private boolean isEndOfWord;

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    private final Map<Character, TrieNode> children;

    public TrieNode() {
        children = new LinkedHashMap<>();
    }
}