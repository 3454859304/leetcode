/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月14日 18:56
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int start1=-1;int start2=-1;
        int k = len/2;
        int left=0;
        int right;
        boolean flag=false;
        //nums1为短数组
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1=nums2;
            nums2=temp;
        }
        //寻找第k个数
        while(k>=1){

            //nums1为短数组
            if(nums1.length-start1>nums2.length-start2){
                int[] temp = nums1;
                nums1=nums2;
                nums2=temp;
                int s= start1;
                start1=start2;
                start2=s;
            }

            //nums1数组为空
            if(start1==nums1.length-1) {
                if(flag) {
                    right=nums2[len/2-nums1.length];
                }else {
                    left=nums2[len/2-1-nums1.length];
                    right=nums2[len/2-nums1.length];
                }

                if((len&1)==0){
                        return (left+right)/2.0;
                    }else{
                        return right;
                }

            }
            else if(k==1){
                if(nums1[start1+1]<=nums2[start2+1]){
                    right=nums1[start1+1];
                    start1+=1;
                }else{
                    right=nums2[start2+1];
                    start2+=1;
                }

                if(flag) {
                    if((len&1)==0){
                        return (left+right)/2.0;
                    }else{
                        return right;
                    }
                }else {
                    left=right;
                    flag=!flag;
                }
            }

            else if(start1+k/2>= nums1.length-1 ){
                if(nums1[nums1.length-1]<nums2[start2+k/2]){
                    start1= nums1.length-1;
                    k=k-(nums1.length-1-start1);
                }
                else {
                    start2+=k/2;
                    k=k-k/2;
                }
            }
            else if(start1+k/2>= nums1.length-1||nums1[start1+k/2]>=nums2[start2+k/2]){
                start2+=k/2;
                k=k-k/2;
            }else{
                start1+=k/2;
                k=k-k/2;
            }
        }
        return nums2[0];
    }

    public static void main(String[] args) {
        int[] i= {3};
        int[] j={1,2,4,5,6,7,8};
        System.out.println(new Solution().findMedianSortedArrays(i, j));
    }
}
