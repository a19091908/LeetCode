//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.
//
//Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.

//Constraints:
//
//2 <= numbers.length <= 3 * 104
//-1000 <= numbers[i] <= 1000
//numbers is sorted in non-decreasing order.
//-1000 <= target <= 1000
//The tests are generated such that there is exactly one solution.
package studyplan;

public class TwoSumWithSortedArr {

	public static void main(String[] args) throws Exception {
		int[] numbers = {2,7,11,15};
		int target = 9;
		int[] result = new TwoSumWithSortedArr().twoSum(numbers, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public int[] twoSum(int[] numbers, int target) throws Exception {
		int left = 0, right = numbers.length-1;
		while(left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum < target) {
				left++;
			}else if(sum > target) {
				right--;
			}else {
				return new int[] {left+1, right+1};
			}
		}
		throw new Exception("Error");
	}

}
