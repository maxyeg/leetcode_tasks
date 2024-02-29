package edu.leetcode.maxeg;

import edu.leetcode.maxeg.common.TrieNode;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.output;

public class SearchSuggestionSystem {

    private final TrieNode root;

    public SearchSuggestionSystem() {
        root = new TrieNode();
    }
    public static void main(String[] args) {
        SearchSuggestionSystem s = new SearchSuggestionSystem();
        output(s.suggestedProducts(new String[]{"havana"}, "tatiana"));
        output(s.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        output(s.suggestedProducts(new String[]{"havana"}, "havana"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String s : Arrays.stream(products).sorted(Comparator.reverseOrder()).toList()) {
            insert(s);
        }
        List<List<String>> result = new LinkedList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            result.add(search(searchWord.substring(0, i)));
        }
        return result;
    }

    private void insert(String word) {
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

    private List<String> search(String word) {
        List<String> result = new LinkedList<>();
        int foundCnt = 0;
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currentNode.getChildren().containsKey(word.charAt(i))) {
                return result;
            } else {
                currentNode = currentNode.getChildren().get(word.charAt(i));
            }
        }
        Stack<TrieNode> nodeStack = new Stack<>();
        Stack<String> charsStack = new Stack<>();
        nodeStack.push(currentNode);
        charsStack.push(word);
        while (!nodeStack.isEmpty() && !charsStack.isEmpty() && foundCnt < 3) {
            currentNode = nodeStack.pop();
            String str = charsStack.pop();
            if (currentNode.isEndOfWord()) {
                result.add(str);
                foundCnt++;
                if (foundCnt >= 3) {
                    break;
                }
            }
            for (Map.Entry<Character, TrieNode> entry : currentNode.getChildren().entrySet()) {
                nodeStack.push(entry.getValue());
                charsStack.push(str.concat(String.valueOf(entry.getKey())));
            }
        }
        return result;
    }

}
