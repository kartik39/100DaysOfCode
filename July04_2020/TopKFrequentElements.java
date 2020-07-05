import java.util.*;

//Question
/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm’s time complexity must be better than O(n * n), where n is the
array’s size.*/

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for(int i=0; i<arraySize; i++) {
			arr[i] = sc.nextInt();
		}
		TreeMap<Integer, List<Integer>> frequencies = topKFrequentElements(arr);
		System.out.println(frequencies.pollLastEntry().getValue());
	}
	
	public static TreeMap<Integer, List<Integer>> topKFrequentElements(int[] arr){
		//List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> elementsWithFrequency = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(!elementsWithFrequency.containsKey(arr[i])) {
				elementsWithFrequency.put(arr[i], 1);
			}else {
				elementsWithFrequency.put(arr[i], elementsWithFrequency.get(arr[i]) + 1);
			}
		}
		TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
		for(Map.Entry<Integer, Integer> entry : elementsWithFrequency.entrySet()) {
			if(!treeMap.containsKey(entry.getValue())) {
				List<Integer> list = new ArrayList<>();
				list.add(entry.getKey());
				treeMap.put(entry.getValue(), list);
			}else {
				treeMap.get(entry.getValue()).add(entry.getKey());
			}
		}
		
		return treeMap;
	}

}
