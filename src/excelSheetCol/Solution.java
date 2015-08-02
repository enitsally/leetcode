package excelSheetCol;

public class Solution {
	public int titleToNumber(String s) {

		if (s == null || s.length() == 0)
			return -1;

		int index = 0;
		int result = 0;

		for (int i = s.length() - 1; i >= 0; i--) {

			result += (s.charAt(i) - 'A' + 1) * Math.pow(26, index);
			index++;
		}

		return result;

	}

	public String convertToTitle(int n) {
		if (n == 0)
			return null;
		StringBuffer result = new StringBuffer();

		int index = n % 26;
		if (index == 0)
			index = 26;
		result.append(Character.toChars('A' + index - 1));
		n = n - index;
		while (n >= 26) {
			n = n / 26;
			index = n % 26;
			if (index == 0)
				index = 26;
			n = n - index;
			result.append(Character.toChars('A' + index - 1));

		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.convertToTitle(701));
	}
}
