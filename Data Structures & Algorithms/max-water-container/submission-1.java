class Solution {
    public int maxArea(int[] heights ) {
        int index1 = 0;
        int index2 = heights.length - 1;
        int width = 0;
        int max = 0;
        int area = 0;
        
        while(index1 < index2){
            width = index2 - index1;
            area = width * Math.min(heights[index1], heights[index2]);
            if(area > max){
                max = area;
            }
            if(heights[index1] <= heights[index2]){

                index1++;
            }
            else{
                index2--;
            }
        }
        return max;
    }
}
