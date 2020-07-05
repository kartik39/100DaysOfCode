import java.util.*;

//Question
/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).*/
public class ArrayProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		for(int i=0; i<arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		int[] result = productExceptSelf(arr);
		print(result, result.length);
	}
	
	public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        double prod = 1;
        boolean flag = false;
        for(int val : nums){
            if(flag == false && val == 0){
                flag = true;
                continue;
            }
            prod *= val;
        }
        
        if(prod == 0){
            Arrays.fill(result, 0);
            return result;
        }else{
            for(int i=0; i<result.length; i++){
                double val = 0D;
                if(nums[i] == 0){
                    val = prod;
                }else{
                    if(flag==true)
                        val = 0;
                    else
                        val = prod * (Math.pow(nums[i], -1));
                }
                result[i] = (int) val;
            }
        }
        return result;
    }
	
	public static void print(int[] arr, int arrSize) {
		for(int i=0; i<arrSize; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
