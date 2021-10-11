//Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//Constraints:
//
//1 <= s.length <= 5 * 104
//s contains printable ASCII characters.
//s does not contain any leading or trailing spaces.
//There is at least one word in s.
//All the words in s are separated by a single space.
package studyplan;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		s = new ReverseWordsInAString().reverseWords(s);
		System.out.println(s);
	}
	
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = -1, end = -1;
        for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ' ) {
				start += 1;
				end = i-1;
				while(start < end) {
		        	char tmp = chars[start];
		        	chars[start++] = chars[end];
		        	chars[end--] = tmp;
		        }
				start = i;
			}
		}
        start += 1;
		end = chars.length-1;
		while(start < end) {
        	char tmp = chars[start];
        	chars[start++] = chars[end];
        	chars[end--] = tmp;
        }
        return new String(chars);
    }

}
