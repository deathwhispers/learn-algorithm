package com.dw.algorithm.classicinterview;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/17 14:27
 * @see <a href="https://leetcode.cn/problems/ransom-note/submissions/587624849/?envType=study-plan-v2&envId=top-interview-150">赎金信</a>
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, --count);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            arr[c - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            arr[c - 'a'] -= 1;
        }
        for (int i : arr) {
            if (i < 0) return false;
        }
        return true;
    }
}
