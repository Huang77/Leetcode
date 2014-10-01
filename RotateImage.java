package LeetCode;

import java.util.Arrays;


/**
 * Problem: 将N*N的矩阵顺时针旋转90度，只能使用常数额外空间
 * Solution: 将矩阵按照从外到内一层一层旋转，每层从left->top, bottom->left, right->bottom, top->right替换
 * @author HXX
 *
 */

public class RotateImage {
	public static void main (String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate(matrix);
		System.out.print(Arrays.toString(matrix[0]));
		System.out.print(Arrays.toString(matrix[1]));
		System.out.print(Arrays.toString(matrix[2]));
		System.out.print(Arrays.toString(matrix[3]));
	}
	
	
    public static void rotate(int[][] matrix) {
        if (matrix == null) {
        	return ;
        }
        
        int first, last;
        int offset;
        int topValue;
        
        for (first = 0; first < matrix.length / 2; first++) {
        	last = matrix.length - 1 - first;
        	for (int j = first; j < last; j++) {
        		// store top values
        		offset = j - first;
        		topValue = matrix[first][j];
        		// left -> top
        		matrix[first][j] = matrix[last - offset][first];
        		// bottom -> left
        		matrix[last - offset][first] = matrix[last][last - offset];
        		// right -> bottom
        		matrix[last][last - offset] = matrix[j][last];
        		// top -> right
        		matrix[j][last] = topValue;
        	}
        }
    }
}
