package validNumber;

public class Solution {

	public boolean isNumber(String s) {
		int i = 0, n = s.length();

		while (i < n && Character.isWhitespace(s.charAt(i)))
			i++;

		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
			i++;

		boolean isNumber = false;
		int flag = -1;

		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumber = true;
		}

		if (i < n && s.charAt(i) == '.') {

			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumber = true;
			}
		}

		if (i < n && s.charAt(i) == 'e') {
			i++;
			while (i < n) {

				if (Character.isDigit(s.charAt(i)))
					flag = 1;
				else
					flag = 0;
				i++;
			}
		}

		while (i < n && Character.isWhitespace(s.charAt(i)))
			i++;

		if (flag == -1)
			return isNumber && i == n;
		else
			return isNumber && (flag == 1) && (i == n);

	}

	public boolean isNumber1(String s) {
		if (s.trim().isEmpty()) {
			return false;
		}
		String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
		if (s.trim().matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNumberF(String s) {
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i)))
			i++;

		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
			i++;

		boolean isNumeric = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}

		if (i < n && s.charAt(i) == '.') {
			i++;
			isNumeric = true;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		
		if (i < n && s.charAt(i) == 'e'){
			i++;
			
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
				i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		
		while (i < n && Character.isWhitespace(s.charAt(i)))
			i++;
		
		return isNumeric && i == n;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.isNumberF("e9"));
	}
}
