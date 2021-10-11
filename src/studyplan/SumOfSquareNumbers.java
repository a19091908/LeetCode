//Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
//Constraints:
//0 <= c <= 231 - 1

package studyplan;

public class SumOfSquareNumbers {

	public static void main(String[] args) {
		int c = 2147483600;
		boolean result = new SumOfSquareNumbers().judgeSquareSum(c);
		System.out.println(result);
	}
	
	public boolean judgeSquareSum(int c) {
		int left = 0, right = (int)Math.sqrt(c);
		while(left <= right) {
			int lVal = left*left;
			int rVal = right*right;
			int sub = c - rVal;
			if (sub > lVal) {
				left++;
			}else if(sub < lVal) {
				right--;
			}else {
				return true;
			}
		}
		return false;
	}

}
