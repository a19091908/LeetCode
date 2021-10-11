//Write a function that reverses a string. The input string is given as an array of characters s.
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is a printable ascii character.
package studyplan;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = "h".toCharArray();
		new ReverseString().reverseString(s);
		System.out.println(new String(s));
	}
	
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right) {
        	char tmp = s[left];
        	s[left++] = s[right];
        	s[right--] = tmp;
        }
    }

}
