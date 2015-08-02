package basicCalculator;

import java.util.*;

public class SolutionII {
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;

		s = s.replace(" ", "");
		int i = 0, n = s.length();

		List<String> stack = new ArrayList<String>(); 
		StringBuilder sb = new StringBuilder();

		int result = 0;

		while (i < n) {

			char tmp = s.charAt(i);
			if (Character.isDigit(tmp)) {
				sb.append(tmp);

			} else {
				if (sb.length() > 0) {
					stack.add(sb.toString());
					sb = new StringBuilder();
				}

				if (tmp == '+' || tmp == '-')
					stack.add(String.valueOf(tmp));
				else if (tmp == '*' || tmp == '/') {
					String arg = stack.remove(stack.size() - 1);
					i++;
					while (i < n && Character.isDigit(s.charAt(i))) {
						sb.append(s.charAt(i));
						i++;
					}
					if (tmp == '*')
						arg = String.valueOf((Integer.valueOf(arg))
								* (Integer.valueOf(sb.toString())));
					else if (tmp == '/')
						arg = String.valueOf((Integer.valueOf(arg))
								/ (Integer.valueOf(sb.toString())));

					stack.add(arg);
					sb = new StringBuilder();
					i--;
				}

			}
			i++;

		}
		if (sb.length() > 0) {
			stack.add(sb.toString());
			sb = new StringBuilder();
		}

		for (i = stack.size() - 1; i > 0; i = i - 2) {
			if (stack.get(i - 1).equals("-"))
				result += 0 - Long.valueOf(stack.get(i));
			else
				result += Long.valueOf(stack.get(i));
		}
		

		result +=  Long.valueOf(stack.get(0));

		return result;
	}

	public static void main(String[] arg) {
		SolutionII s = new SolutionII();

		System.out.println(s.calculate("1-1"));
	}
}
