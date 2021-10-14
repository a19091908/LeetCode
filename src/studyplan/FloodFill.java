//An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//
//You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//
//To perform a flood fill, consider the starting pixel, 
//plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
//plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. 
//Replace the color of all of the aforementioned pixels with newColor.
//
//Return the modified image after performing the flood fill.
//
//Constraints:
//	m == image.length
//	n == image[i].length
//	1 <= m, n <= 50
//	0 <= image[i][j], newColor < 216
//	0 <= sr < m
//	0 <= sc < n
package studyplan;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		new FloodFill().floodFill(image, sr, sc, newColor);
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + ",");
			}
			System.out.println("");
		}
	}
      // version2
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//    	int sColor = image[sr][sc];
//        boolean[][] isRun = new boolean[image.length][image[0].length];
//        Queue<int[]> queue = new LinkedList<int[]>();
//        queue.add(new int[] {sr,sc});
//        while(queue.isEmpty() == false) {
//        	int[] tmpArr = queue.remove();
//        	int row = tmpArr[0];
//        	int col = tmpArr[1];
//        	if (0 <= row && row < image.length && 0 <= col && col < image[0].length && isRun[row][col] == false) {
//        		isRun[row][col] = true;
//        	    if (image[row][col] == sColor) {
//        	        image[row][col] = newColor;
//        	        queue.add(new int[] {row+1,col});
//        	        queue.add(new int[] {row-1,col});
//        	        queue.add(new int[] {row,col+1});
//        	        queue.add(new int[] {row,col-1});
//        	    }
//    	    }
//        }
//        
//        return image;
//    }
    
//    // version 1: use call stack
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	int sColor = image[sr][sc];
        boolean[][] isRun = new boolean[image.length][image[0].length];
        doSearch(sr, sc, sColor, newColor, image, isRun); 
        return image;
    }
    
    public void doSearch(int row, int col, int sColor, int newColor, int[][] image, boolean[][] isRun){
    	    if (0 > row || row >= image.length || 0 > col || col >= image[0].length || isRun[row][col]) {
    	        return;
    	    }

    	    isRun[row][col] = true;
    	    if (image[row][col] == sColor) {
    	        image[row][col] = newColor;
    	        doSearch(row-1, col, sColor, newColor, image, isRun);
    	        doSearch(row+1, col, sColor, newColor, image, isRun);
    	        doSearch(row, col-1, sColor, newColor, image, isRun);
    	        doSearch(row, col+1, sColor, newColor, image, isRun);
    	    }
    	    
    }

}
