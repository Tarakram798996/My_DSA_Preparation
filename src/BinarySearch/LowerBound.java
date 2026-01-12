package BinarySearch;

public class LowerBound {
    public static int lowerBound(int[] nums,int x){
        int left=0,right=nums.length-1;
        int ans=0;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid]>=x){
                ans=mid;
                right=mid-1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums= new int[]{3,3,3,3,3,3,3,4,5,6,7};
        int x=2;
        System.out.println(lowerBound(nums,x));
    }
}
