package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abba"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1){
            return 0;

        }

        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        int max = 1;
        map.put(s.charAt(0),0);
        int start = 0;
        
        for(int i=1; i<s.length(); i++){
            
        	if(map.containsKey(s.charAt(i)) && start < map.get(s.charAt(i))+1){
               	start = map.get(s.charAt(i))+1;
            }
        	max = Math.max(max, i+1-start);
         	map.put(s.charAt(i), i);
             
        }
        return max; 

    }
}

	
