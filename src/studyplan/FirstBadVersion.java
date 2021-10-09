//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

// Constraints: 1 <= bad <= n <= 2^31 - 1
package studyplan;

public class FirstBadVersion {
	final private static int N = 1;
	final private static int IND_FIRST_BAD = 1;
	boolean[] isVersionBad = null;

	public static void main(String[] args) {
		
		int result = new FirstBadVersion().firstBadVersion(N);
		System.out.println(result);
	}
	
	FirstBadVersion(){
		isVersionBad = new boolean[N+1];
		for (int i = IND_FIRST_BAD; i < isVersionBad.length; i++) {
			isVersionBad[i] = true;
		}
	}

	private int firstBadVersion(int n) {
		if (n == 0) {
			return -1;
		}
		
		return perform(1, n);
	}
	
	private int perform(int i, int j) {
		if (i == j) {
			return isBadVersion(i) ? i : -1;
		}
		int mid = i + (j-i+1)/2;
		if (isBadVersion(mid)) {
			if ( mid-1 >= 0 && isBadVersion(mid-1) == false) {
				return mid;
			}else {
				return perform(i, mid-1);
			}
			
		}else {
			return perform(mid+1, j);
		}
	}

	private boolean isBadVersion(int version){
		return isVersionBad[version];
	}

}
