package studyplan;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {-1,-100,3,99};
		int k = 3;
		new RotateArray().rotate(nums, k);
		for(int i = 0 ;i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		
		if (k == 0) {
			return;
		}
		
		int startIndex = 0;
		int completeCnt = 0;
		int tmpIndex = 0;
		int replaceTmp = nums[tmpIndex];
		while(completeCnt < nums.length) {
			tmpIndex = (tmpIndex+k) % nums.length;
			int tmp = nums[tmpIndex];
			nums[tmpIndex] = replaceTmp;
			replaceTmp = tmp;
			completeCnt++;
			if (startIndex == tmpIndex) {
				startIndex++;
				tmpIndex = startIndex; 
				replaceTmp = nums[tmpIndex];
			}
		}
		
		
	}

}
