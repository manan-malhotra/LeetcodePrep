// https://leetcode.com/problems/valid-anagram/

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//  typically using all the original letters exactly once.

// Tags: HashMaps, Strings, Arrays

import java.util.HashMap;

public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram2(s, t));

    }

    private static boolean isAnagram2(String s, String t) { // Using Arrays as map
        if (s.length() != t.length()) return false; // If both string are not of the same length

        int[] store = new int[26]; // Create a bucket of 26 char; a=0, z=25; Only works if strings are just small letters and no numbers

        for (int i = 0; i < s.length(); i++) { // Iterate through the strings;
            store[s.charAt(i) - 'a']++; // Add 1 at ASCII value from s in the bucket store
            store[t.charAt(i) - 'a']--; // Sub 1 at ASCII value from t in the bucket store
        }

        for (int n : store) if (n != 0) return false; // If value of any char is not equal to 0, it is not a valid anagram

        return true; // else return true;
    }

    public static boolean isAnagram(String s, String t) { // Using proper hashmaps
        if (s.length() != t.length()) return false; // If both string are not of the same length
        HashMap<Character, Integer> map = new HashMap<>(); // Create a new hashmap
        for(int i=0;i<s.length();i++){ // Iterate through s string
            char ch = s.charAt(i); // get value of ith index of string s
            map.put(ch,map.getOrDefault(ch,0)+1); // if val already exists it will return that or else it will return 0
            // Add 1 to that value and put it again in the map
        }
        for(int i=0;i<t.length();i++){ // Iterate through t string
            char ch = t.charAt(i); // get value of ith index of string t
            if(map.get(ch)!=null){ // if the value at i exists
                if(map.get(ch)==1){
                    map.remove(ch); // if value to key is 1, remove it from the map
                }else{
                    map.put(ch,map.get(ch)-1); // else get the value and decrement
                }
            }else{ // else it is not an anagram
                return false;
            }
        }
        return map.isEmpty(); // if map is empty then return true
    }
}
