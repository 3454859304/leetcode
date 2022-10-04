import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年10月03日 21:00
 */
public class Solution {



    public List<Integer> spiralOrder(int[][] matrix) {
        int cur=matrix.length*matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>(cur);
        int bottom=matrix.length-1;int right=matrix[0].length-1;int left=0;int top=0;
        int row =0; int column =0;
        while(cur>0){
            //右
            for (int i = left; i <= right; i++,cur--) res.add(matrix[top][i]);
            if(cur==0) break;
            top++;
            //下
            for (int i = top; i <= bottom; i++,cur--) res.add(matrix[i][right]);
            if(cur==0) break;
            right--;
            //左
            for (int i = right; i >= left; i--,cur--) res.add(matrix[bottom][i]);
            if(cur==0) break;
            bottom--;
            //上
            for (int i = bottom; i >= top; i--,cur--) res.add(matrix[i][left]);
            if(cur==0) break;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.spiralOrder(new int[][]{{1,2,3}, {4,5,6},{7,8,9}});
        System.out.println("1");
    }

}
