class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        return x<10 || x==reserve(x);
    }

    public int reserve(int x){
        int rex=x%10;
        //取巧
        if(rex==0){
            return 0;
        }x=x/10;

        while(x!=0){
            rex=rex*10+x%10;
            x=x/10;
        }
        return rex;
    }
}
