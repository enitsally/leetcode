package simplifyPath;

import java.util.*;

public class Solution {
	public String simplifyPathA(String path) {
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();

		int i = 1, n = path.length();

		while (i < n) {

			while (i < n && path.charAt(i) != '/') {
				sb.append(path.charAt(i));
				i++;
			}

			if (i == n || sb.length() > 0) {
				stack.push(sb.toString());
			}

			if ((i < n && path.charAt(i) == '/') || i == n) {

				if (sb.toString().equals(".") && !stack.isEmpty())
					stack.pop();
				else if (sb.toString().equals("..") && !stack.isEmpty()) {
					stack.pop();
					if (!stack.isEmpty())
						stack.pop();
				}
				i++;
				sb = new StringBuilder();
			}

		}

		List<String> result = new ArrayList<String>();

		while (!stack.isEmpty()) {
			String tmp = stack.peek();
			result.add(0, tmp);
			stack.pop();
		}

		String r = "/";

		if (result.size() == 0)
			r = r + "/";
		else {
			for (String s : result) {
				r = r + s + "/";
			}

		}

		return r.substring(0, r.length() - 1);
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] split = path.split("/");

		for (int i = 0; i < split.length; i++) {

			String tmp = split[i];

			if (tmp.equals("") || tmp.equals("."))
				continue;
			else if (tmp.equals("..")){
				if(!stack.isEmpty())
					stack.pop();				
			}				
			else
				stack.push(tmp);
		}

		List<String> result = new ArrayList<String>();

		while (!stack.isEmpty()) {
			String tmp = stack.peek();
			result.add(0, tmp);
			stack.pop();
		}

		String r = "/";

		if (result.size() == 0)
			r = r + "/";
		else {
			for (String s : result) {
				r = r + s + "/";
			}

		}

		return r.substring(0, r.length() - 1);
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.simplifyPath("/.."));
	}
}
