package containerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
        if (height == null || height.length == 0)
        	return 0;
        
        int left = 0;
        int right = height.length -1;
        int maxArea = 0;

        while (left < right){
        	int tmpArea = Math.min(height[left], height[right]) * (right - left);
        	maxArea = Math.max(tmpArea, maxArea);
        	
        	if (height[left] < height[right])
        		left ++;
        	else
        		right--;
        }
        
        return maxArea;
    }
}
