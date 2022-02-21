package com.wyman.datastructor.leetcode202202.code208;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. 实现 Trie (前缀树)
 */
class Trie {
    static class TrieNode {
        private boolean isWord;
        private final Map<Character, TrieNode> childNodeMap;

        public TrieNode() {
            childNodeMap = new HashMap<>();
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            // 查看这个字符存不存在
            char c = word.charAt(i);
            if (curr.childNodeMap.get(c) == null) {
                curr.childNodeMap.put(c, new TrieNode());
            }
            curr = curr.childNodeMap.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 没找到直接返回false
            if (curr.childNodeMap.get(c) == null) {
                return false;
            }
            curr = curr.childNodeMap.get(c);
        }
        // 判断是不是个单词
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            // 没找到直接返回false
            if (curr.childNodeMap.get(c) == null) {
                return false;
            }
            curr = curr.childNodeMap.get(c);
        }
        // 找到直接返回true
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
