public class QuickSort {
    static int[] arr;
    public static void quickSort(int left,int right){

        if(left<=right){
            int j = partition(left,right);
            quickSort(left,j-1);
            quickSort(j+1,right);
        }
    }

    public static int partition(int left, int right) {
        int p=left;
        int val=arr[p];
        left+=1;
        while(left<right){
            while(left<=right && arr[left]<val) left++;
            while(left<=right && arr[right]>val) right--;

            if(left<right) swap(left,right);
        }
        swap(p,right);
        return right;
    }
    public static void swap(int i,int j){
        int temp=arr[i]; arr[i]=arr[j]; arr[j]=temp;
    }
    public static void main(String args[]){
        arr= new int[]{6,5,4,3,-10,0,-99,-02,2,1};
        quickSort(0,arr.length-1);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
