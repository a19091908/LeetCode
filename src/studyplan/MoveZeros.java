//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
//
//Constraints:
//
//1 <= nums.length <= 104
//-231 <= nums[i] <= 231 - 1
package studyplan;

public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
//		int[] nums = {0};
//		int[] nums = {};
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		new MoveZeros().moveZeroes(nums);
		System.out.print("\n-------------------\n");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+ ",");
		}

	}
	
	public void moveZeroes(int[] nums) {
		int index = 0;
		int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index++] = nums[i];
			}else {
				zeroCnt++;
			}
		}
        for (int i = nums.length-zeroCnt; i < nums.length; i++) {
			nums[i] = 0;
		}
    }

}
