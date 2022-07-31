/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月28日 11:08
 */
public class Solution {
    public String convert1(String s, int numRows) {
        if(s.length()<2||numRows<2){
            return s;
        }
        int numCols= s.length()/(numRows * 2 - 2)*(numRows-1) +
                s.length() % (numRows * 2 - 2);
        char[][] map= new char[numRows][numCols];
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++) {
            int m = (i + 1 - 1 ) / (numRows * 2 - 2) ;
            int n = (i + 1 - 1 ) % (numRows * 2 - 2) + 1;
            int col = -1;
            int row = -1;
            if (n <= numRows) {
                col = m * (numRows - 1) + 1;
                row = n;
            } else {
                col = m * (numRows - 1) + 1 + (n - numRows);
                row = numRows - (n - numRows);
            }
            map[row - 1][col - 1] = cs[i];
        }
        int num=0;
        for(int i = 0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                if(map[i][j]!=0){
                    cs[num++]=map[i][j];
                }
            }
        }
        return new String(cs);
    }


    public String convert(String s, int numRows) {
        if(numRows==1||numRows>s.length()){
            return s;
        }
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; ++i) {
            sb[i] = new StringBuffer();
        }
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++) {
            int n = i % (numRows * 2 - 2);
            int row = -1;
            if (n < numRows) {
                row = n;
            } else {
                row = 2 * numRows - n - 2;
            }
            sb[row].append(cs[i]);
        }
        StringBuffer result = new StringBuffer();

        for(int i=0;i<numRows;i++){
            result.append(sb[i]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING",3));
    }
}
