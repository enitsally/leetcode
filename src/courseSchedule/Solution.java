package courseSchedule;

import java.util.LinkedList;

public class Solution {

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequistes array");
		}

		int len = prerequisites.length;

		if (numCourses == 0 || len == 0) {
			return true;
		}

		// counter for each course prerequisites course
		int[] pCounter = new int[numCourses];

		for (int i = 0; i < len; i++) {
			int current_course = prerequisites[i][0];
			pCounter[current_course]++;
		}

		// store courses that have no prerequisites, or the prerequisites have
		// no prerequisites
		LinkedList<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < numCourses; i++) {
			if (pCounter[i] == 0) {
				queue.add(i);
			}

		}

		// number of course that have no prerequisites
		int numNoPre = queue.size();

		while (!queue.isEmpty()) {
			int top = queue.remove();

			for (int i = 0; i < len; i++) {
				int pre = prerequisites[i][1];
				int course = prerequisites[i][0];
				if (top == pre) {
					pCounter[course]--;
					if (pCounter[course] == 0) {
						queue.add(course);
						numNoPre++;
					}
				}
			}
		}

		return numNoPre == numCourses;

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		
		int[] order = new int[numCourses];
		int len = prerequisites.length;
		
		if (prerequisites == null || len == 0)
		{
			for (int i = 0; i< numCourses; i++)
				order[i] = i;
			return order;
		}

		int[] pCounter = new int[numCourses];

		for (int i = 0; i < len; i++) {
			int course = prerequisites[i][0];
			pCounter[course]++;
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		int numNoPre = 0;

		for (int i = 0; i < numCourses; i++) {
			if (pCounter[i] == 0) {
				queue.add(i);
			}

		}

		while (!queue.isEmpty()) {
			int top = queue.removeLast();

			order[numNoPre] = top;
			numNoPre++;

			for (int i = 0; i < len; i++) {
				int pre = prerequisites[i][1];
				int course = prerequisites[i][0];

				if (top == pre) {
					pCounter[course]--;
					if (pCounter[course] == 0) {
						queue.add(course);
					}
				}
			}
		}

		if (numNoPre == numCourses)
			return order;
		else
			return new int[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
