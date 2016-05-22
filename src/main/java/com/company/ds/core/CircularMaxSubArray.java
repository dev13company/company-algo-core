package com.company.ds.core;

public class CircularMaxSubArray {

	public static void main(String[] args) {
		int a[] =  {2, 1, 4, -1, -2, 1, 5, -3};
		int max_sum = maxSubArraySum(a);
		System.out.println(" cirular sum "+max_sum);
	}

	private static int maxSubArraySum(int[] a) {
		int max_so_far = 0, max_ending_here = 0;
		int size = 2 * a.length;
		int start=0,end=0;
		for(int i=0; i< size; i++){
			int j = i<a.length?i:i%a.length;
			max_ending_here = max_ending_here + a[j];
		       if (max_ending_here < 0)
		           max_ending_here = 0;
		 
		       /* Do not compare for all elements. Compare only   
		          when  max_ending_here > 0 */
		       else if (max_so_far < max_ending_here){
		    	   max_so_far = max_ending_here;
		       }
		}
		return max_so_far;
	}
}
