public class EllysPalMulDiv2 {

	public int getMin(int X) {
		for (long i = 1; i <= 1000; i++) {
			if (isPalindrome(i * X)) {
				return (int) i;
			}
		}
		return -1;
	}

	private boolean isPalindrome(long n) {
		String s = String.valueOf(n);
		if (s.charAt(s.length()-1) == '0') {
			return false;
		}
		for (int i = 0, j = s.length()-1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
