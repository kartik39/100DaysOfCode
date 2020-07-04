import java.util.*;

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
