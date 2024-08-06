package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
	public static void main(String[] args) {
		List<String> lsit = letterCombinations("");
		lsit.stream().forEach(System.out::println);
	}
	

    public static List<String> letterCombinations(String digits) {
        Map<String, List<String>> digitsMap = new HashMap<String, List<String>>();
        digitsMap.put("2", Arrays.asList("a","b","c"));
        digitsMap.put("3", Arrays.asList("d","e","f"));
        digitsMap.put("4", Arrays.asList("g","h","i"));
        digitsMap.put("5", Arrays.asList("j","k","l"));
        digitsMap.put("6", Arrays.asList("m","n","o"));
        digitsMap.put("7", Arrays.asList("p","q","r","s"));
        digitsMap.put("8", Arrays.asList("t","u","v"));
        digitsMap.put("9", Arrays.asList("w","x","y","z"));
        System.out.println(digitsMap);
        List<String> list = printStrings(digits, 0,digitsMap);
        return list;
    }

    public static List<String> printStrings(String digits, int index, Map<String, List<String>> digitsMap){
        List<String> resList = new ArrayList<String>();
        if(digits == null || digits.equals("")) {
        	return Collections.EMPTY_LIST;
        }
           
        if(index+1 == digits.length()){
            System.out.println(index);
            digitsMap.get(digits.charAt(index)+"").stream().forEach(System.out::println);
           return new ArrayList<String>(digitsMap.get(digits.charAt(index)+"")); 
        }else{
            List<String> list = printStrings(digits, index+1, digitsMap);
            List<String> currList = new ArrayList<String>(digitsMap.get(digits.charAt(index)+""));
            for(String st1:list){
                for(String st2: currList){
                    resList.add(st1+st2);
                }
            }
        }
        return resList;
            
    }
      
}