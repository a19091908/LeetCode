//Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//In other words, return true if one of s1's permutations is the substring of s2.
//		
//Constraints:
//	1 <= s1.length, s2.length <= 104
//	s1 and s2 consist of lowercase English letters.	
//Example:
//	Input: s1 = "ab", s2 = "eidbaooo"
//	Output: true
//	Explanation: s2 contains one permutation of s1 ("ba").
package studyplan;

public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab", s2 = "bca";
		boolean ans = new PermutationInString().checkInclusion(s1, s2);
		System.out.print(ans);
	}
	
	/**
	 * The time complexity is O(s2.length), and the space complexity is O(26)
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkInclusion(String s1, String s2) {
	      if(s1.length() > s2.length()) return false;

		  int[] s1EngCnts = new int[26];
		  for (int i = 0; i < s1.length() ; i++) {
		  	s1EngCnts[s1.charAt(i) - 'a']++;
		  }

		  int[] windEngCnts = new int[26];
		  int left = 0, right = 0;
		  while(right < s2.length()){
		  	if ( (right - left) == s1.length() ) {
		  		if(isTheSame(s1EngCnts, windEngCnts)){
		  			return true;
		  		}
		  		windEngCnts[s2.charAt(left) - 'a']--;
		  		left ++;
		  	}else{
		  		windEngCnts[s2.charAt(right) - 'a']++;
		  		right++;
		  	}
		  }

		  return isTheSame(s1EngCnts, windEngCnts);
    }
	
	public boolean isTheSame(int[] s1EngCnts, int[] windEngCnts){
		  for (int i = 0; i < windEngCnts.length; i++) {
		  	if (s1EngCnts[i] != windEngCnts[i]) {
		  		return false;
		  	}
		  }
		  return true;
	}

}
