package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagram {
	
	public static void main(String[] args) {
		List<List<String>>  list = groupAnagrams(new String[]{"eat","teae","tana","atet","nat","bat"});
		System.out.println(list);
	}

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = groupAnagrams(strs, 0);
        return list;
    }
    public static List<List<String>> groupAnagrams(String[]strs, int start){
    	/*
    	 * Approach 1 sort the letters in each string and store them in appropriate buckets
    	 * To sort each char in each strng will take k(logk) for total chars count is k
    	 * overall complexity can be further reduced using linear approach
    	 */
    	Map<String, List<String>> buckets = new HashMap<String, List<String>>();	
    	for (int i = 0; i < strs.length; i++) {
			char[] sortedStr = strs[i].toCharArray();
			Arrays.sort(sortedStr);
			if(!buckets.containsKey(new String(sortedStr))) {
				List<String> valList = new ArrayList<String>();
				valList.add(strs[i]);
				buckets.put(new String(sortedStr),valList);
			}else {
				buckets.get(new String(sortedStr)).add(strs[i]);
			}
		}
    	
    	/*
    	 * Approach 2: Bit Manipulation
    	 * Create int map for each lower chars starting from 1
    	 * set appropriate bit for each char
    	 * it generates unique integer value for each combination of chars - regardless of duplicate chars
    	 * matching with int key seggregate words
    	 * Time complexity is O(n) - n is all chars in all strings combined. 
    	 */
    	
    	Map<Character, Integer> charMap = new HashMap<Character, Integer>();
    	charMap.put('a', 1);
    	charMap.put('b', 2);
    	charMap.put('c', 3);
    	charMap.put('d', 4);
    	charMap.put('e', 5);
    	charMap.put('f', 6);
    	charMap.put('g', 7);
    	charMap.put('h', 8);
    	charMap.put('i', 9);
    	charMap.put('j', 10);
    	charMap.put('k', 11);
    	charMap.put('l', 12);
    	charMap.put('m', 13);
    	charMap.put('n', 14);
    	charMap.put('o', 15);
    	charMap.put('p', 16);
    	charMap.put('q', 17);
    	charMap.put('r', 18);
    	charMap.put('s', 19);
    	charMap.put('t', 20);
    	charMap.put('u', 21);
    	charMap.put('v', 22);
    	charMap.put('w', 23);
    	charMap.put('x', 24);
    	charMap.put('y', 25);
    	charMap.put('z', 26);
    	Map<Integer, List<String>> buckets2 = new HashMap<Integer, List<String>>();
    	for (int i = 0; i < strs.length; i++) {
			int key = 0;
			for (int j = 0; j < strs[i].length(); j++) {
				key = key | (1 << charMap.get(strs[i].charAt(j)));
			}
			if(!buckets2.containsKey(key)) {
				List<String> l = new ArrayList<String>();
				l.add(strs[i]);
				buckets2.put(key, l);
				
			}else {
				buckets2.get(key).add(strs[i]);
			}
			
		}
    	
    	
    	
    	//List<List<String>> bucketsList = 
    	return new ArrayList<>(buckets2.values());
    	
    }
	//public static boolean isAnagram(String s1, String s2) {}
}
