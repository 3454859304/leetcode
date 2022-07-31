/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月30日 12:03
 */
public class Solution {
    public String intToRoman(int num) {

        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(rom[i]);
                num-=values[i];
            }
        }

        return sb.toString();
    }

    public int romanToInt1(String s) {

        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int num = 0;
        int flag=0;
        for(int i=0;i<values.length;i++){
            if (rom[i].length()>1 && flag<s.length()-1 && rom[i].equals(s.substring(flag,flag+2))){
                num+=values[i];
                flag+=2;
            }else{
                while(flag<s.length() && rom[i].equals(s.substring(flag,flag+1))){
                    num+=values[i];
                    flag++;
                }
            }
        }
        return num;
    }


    public int romanToInt(String s) {
        int sum = 0;
         char[] sc=s.toCharArray();
        int preNum = -1;
        for(int i = s.length()-1; i >-1; i--) {
            int num = getValue(sc[i]);
            if( num<preNum) {
                sum -= num;
            } else {
                sum += num;
            }
            preNum = num;
        }
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }



    public static void main(String[] args) {
        new Solution().romanToInt("III");
    }
}
