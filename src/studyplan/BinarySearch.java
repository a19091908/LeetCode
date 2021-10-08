package studyplan;
//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//
//You must write an algorithm with O(log n) runtime complexity.
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 121;
		int result = new BinarySearch().perform(nums, target);
		System.out.println(result);

	}

	private int perform(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		return run(nums, target, 0, nums.length-1);
	}

	private int run(int[] nums, int target, int i, int j) {
		int length = j - i + 1;
		switch(length) {
		case 0:
			return -1;
		case 1:
			return (nums[i+length/2] == target)? i+length/2 : -1;
		default:
			int diff = nums[i+length/2] - target;
			if (diff > 0) {
				return run(nums, target, i, i+length/2-1);
			}else if(diff < 0) {
				return run(nums, target, i+length/2, j);
			}else {
				return (nums[i+length/2] == target)? i+length/2 : -1;
			}
		}
	}

}
