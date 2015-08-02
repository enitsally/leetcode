package rectangleArea;

public class Solution {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		
		if (C<E || A>G)
			return (C-A) * (D-B) + (G-E) * (H-F);
		
		if (F>D || B > H)
			return (C-A) * (D-B) + (G-E) * (H-F);
		
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		
		int top = Math.min(H,D);
		int bottom = Math.max(B, F);
		
		return (C-A) * (D-B) + (G-E) * (H-F) -  (right-left) * (top-bottom);
	}

}
