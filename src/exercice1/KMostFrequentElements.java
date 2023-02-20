package exercice1;

import java.util.*;

public class KMostFrequentElements {
    
    public static void main(String[] args) {
        
        int[] arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;
        
        // Step 1: Create a map to store element-frequency pair
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 2: Traverse the array and update frequency in map
        for(int i=0; i<arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        
        // Step 3: Convert map into a list of element-frequency pairs
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freqMap.entrySet());
        
        // Step 4: Sort the list in decreasing order of frequency
        Collections.sort(freqList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o2.getKey() - o1.getKey();
                }
            }
        });
        
        // Step 5: Print the top k elements from the sorted list
        for(int i=0; i<k; i++) {
            System.out.print(freqList.get(i).getKey() + " ");
        }
    }
}
