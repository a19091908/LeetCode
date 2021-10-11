//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//
//Constraints:
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums contains distinct values sorted in ascending order.
//-104 <= target <= 104
package studyplan;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {1,3};
		int target = 4;
		int index = new SearchInsertPosition().searchInsert(nums, target);
		System.out.println(index);
	}
	
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0 ) {
			return 0;
		}
		return perform(0, nums.length-1, nums, target);
	}

	private int perform(int i, int j, int[] nums, int target) {
		if (i >= j) {
			if(i == j) {
				int diff = target - nums[i];
				if (diff == 0) {
					return i;
				}else if (diff > 0) {
					return i+1;
				}else {
					return i;
				}
			}else {
				return i;
			}
		}
		int mid = i + (j-i+1)/2;
		int diff = target - nums[mid];
		if (diff == 0) {
			return mid;
		}else if (diff > 0) {
			return perform(mid+1, j, nums, target);
		}else {
			return perform(i, mid-1, nums, target);
		}

	}

}
