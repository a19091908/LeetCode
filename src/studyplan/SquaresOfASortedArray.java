package studyplan;

import java.util.ArrayList;

public class SquaresOfASortedArray {

	public static void main(String[] args) {
		int[] nums = {-4,-1};
		int[] resultArr = new SquaresOfASortedArray().sortedSquares(nums);
		for (int i = 0; i < resultArr.length; i++) {
			System.out.println(resultArr[i]);
		}
	}
	
	public int[] sortedSquares(int[] nums) {
		ArrayList<Integer> nList = new ArrayList<Integer>();
		ArrayList<Integer> pList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				nList.add(nums[i]*nums[i]);
			}else {
				pList.add(nums[i]*nums[i]);
			}
		}
		int nIndex = nList.size()-1;
		int pIndex = 0;
		int i = 0;
		while (nIndex >= 0 && pIndex < pList.size() && i < nums.length) {
			if (nList.get(nIndex) < pList.get(pIndex)) {
				nums[i++] = nList.get(nIndex--);
			}else if (nList.get(nIndex) > pList.get(pIndex)) {
				nums[i++] = pList.get(pIndex++);
			}else {
				nums[i++] = nList.get(nIndex--);
				nums[i++] = pList.get(pIndex++);
			}
		}
		
		while(nIndex >= 0) {
			nums[i++] = nList.get(nIndex--);
		}
		while(pIndex < pList.size()) {
			nums[i++] = pList.get(pIndex++);
		}
		return nums;
	}

}
