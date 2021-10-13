//Given a string s, find the length of the longest substring without repeating characters.
//Constraints:
//
//0 <= s.length <= 5 * 104
//s consists of English letters, digits, symbols and spaces.
package studyplan;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
//		String s = "abcabcbb";
//		String s = "bbbbb";
		String s = "grnagnkrm";
		int ans = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
		System.out.println(ans);
	}
	
	/**
	 * The time complexity is O(n) and the space complexity is O(s.length)
	 * @param s
	 * @return
	 */
    int lengthOfLongestSubstring(String s) {
    	char[] charArr = s.toCharArray();
    	int left = 0, right = 0, max = 0;
    	Set<Character> set = new HashSet<Character>();
    	while(right < charArr.length){
    		if (set.contains(charArr[right]) == false) {
    			set.add(charArr[right]);
    			right++;
    			max = Math.max(max, right-left);
    		}else{
    			set.remove(charArr[left]);
    			left++;
    		}
    	}
    	return max;
    }
}
