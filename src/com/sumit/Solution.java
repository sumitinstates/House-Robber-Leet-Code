package com.sumit;

public class Solution {
	
	/*
	 * Algorithm working:
	 * 
	 * if there are no house that means input is null then no money.
	 * 
	 * if there are one house then maximum robbery will always be value at 0th index.
	 * 
	 * if there are two houses, then maximum robbery will be maximum value of both the houses.
	 * 
	 * But if houses are more than 2, then take an array of same length of input length.
	 * And for each ith house in input array, we calculate the max money a robber
	 * can rob. so here if there are more than two houses. Let's say there are
	 * three houses. To figure out if a robber should rob 1st and 3rd houses, as
	 * we can't rob consecutive houses else police will be alarmed, or just second house
	 * in order to get maximum robbery, we will have to keep track of update of maximum
	 * robbery at the ith house.
	 * 
	 */
	public static int rob(int[] nums) 
	{
		//if no houses
		if(nums==null || nums.length==0) 
		{
			return 0;
		}
		
		//if one house
		if(nums.length == 1) 
		{
			return nums[0];
		}
		
		//if there are two houses
		if(nums.length==2) 
		{
			return Math.max(nums[0], nums[1]);
		}
		
		//for more than 2 houses
		int[]dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		for(int i=2;i<nums.length;i++) 
		{
			/*calculate maximum amount at the ith location with the second last ith location 
			 * and last ith location*/
			dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
		}
		
		return dp[dp.length-1];	
	}

	public static void main(String[] args) {
		int [] arr1 = {1,2,3,1};
		int [] arr2 = {2,7,9,3,1};
		
		System.out.println(Solution.rob(arr1));
		System.out.println(Solution.rob(arr2));
	}
}
