package Hashing;

public class NumberofGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int[] freq=new int[101];
        for(int i : nums){
            freq[i]++;
        }
        int res=0;
        for(int i : freq){
            if(i>0){
                res+=((i-1)*(i))/2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = numIdenticalPairs(new int[]{1,2,3,1,1,3});
        System.out.println(res);
    }
}
