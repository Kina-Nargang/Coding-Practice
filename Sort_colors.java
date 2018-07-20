/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Space:O(1)
Time:O(n)
*/

public void sortColors(int[] nums){
	if(nums == null || nums.length == 0) return;
	
	int index = 0;
	int start = 0;
	int end = nums.length - 1;

	// if nums = [0,0,0,0,2,0,1,1,2,0,2,2,2]
	// find start pointer,the frist element which is not 0 from begining
	while(start <= end && nums[start] == 0) start++;
	// find end pointer,the last element which is not 2 from the end
	while(end >= 0 && nums[end] == 2) end--;
	
	index = start;
	while(start <= end){
		if (nums[index] == 0){
			swap(nums,start++,index++);
		}else if (nums[index] == 1){
			index++;
		}else if (nums[index] == 2){
			swap(nums,end--,index)
		}
	}
}

public void swap(int[] nums,int i,int j){
	int temp = nums[i];
	nums[i] = num[j];
	nums[j] = temp;
}