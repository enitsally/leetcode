package differentWaystoAddParentheses;

import java.util.*;

public class Solution {
	public List<Integer> diffWaysToCompute(String input) {

		List<Integer> result = new ArrayList<Integer>();
		if (input == null || input.length() == 0)
			return result;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '+' && input.charAt(i) != '-'
					&& input.charAt(i) != '*')
				continue;

			List<Integer> leftPart = diffWaysToCompute(input.substring(0, i));
			List<Integer> rightPart = diffWaysToCompute(input.substring(i + 1,
					input.length()));

			for (int left : leftPart) {
				int tmp = 0;
				for (int right : rightPart) {
					if (input.charAt(i) == '+')
						tmp = left + right;
					else if (input.charAt(i) == '-')
						tmp = left - right;
					else if (input.charAt(i) == '*')
						tmp = left * right;
					result.add(tmp);
				}
			}
		}

		if (result.size() == 0)
			result.add(Integer.valueOf(input));

		return result;
	}
}
