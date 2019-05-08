package com.example.terminalServer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DER {

	public static void main(String[] args) {
		
//		gulab
//		gulab
//		laduu
//		gajar
//		gajar
		ArrayList<String> al = new ArrayList<String>();
        al.add("gulab");
        al.add("gulab");
        al.add("laddu");
        al.add("gajar");
        al.add("gajar");
        
        DER.whichSweetShouldIBring(al);
        

	}
	
	static void whichSweetShouldIBring(List<String> votes) {

         
        Map<String,Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<votes.size();i++){            
            Integer count = map.get(votes.get(i));       
            map.put(votes.get(i), count==null?1:count+1);   //auto boxing and count
        }
        System.out.println(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            
           
        }
		
//		String mostRepeatedWord 
//	    = votes.stream()
//	          .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
//	          .entrySet()
//	          .stream()
//	          .max(Comparator.comparing(Entry::getValue))
//	          .get()
//	          .getKey();
//		
//		System.out.println(mostRepeatedWord);

	 }

}
