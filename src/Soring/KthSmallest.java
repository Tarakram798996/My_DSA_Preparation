public class KthSmallest {
    static int[] arr;
    static int k;
    static int result;

    public static void quickSelect(int left,int right){
        int j=partition(left,right);
        if(j == k-1) {
            result = arr[j];
        } else if(j > k-1) {
            quickSelect(left, j - 1);
        } else {
            quickSelect(j + 1, right);
        }
    }

    public static int partition(int i,int j){
        int p=i;
        int val=arr[p];

        i+=1;

        while(i<=j) {

            while (i <= j && arr[i] < val) i++;
            while (i <= j && arr[j] > val) j--;

            if(i<j){
                swap(i,j);
                i++;
                j--;
            }
        }
        swap(p,j);

        return j;
    }

    public static void swap(int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args){
        arr=new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        k=9;
        quickSelect(0,arr.length-1);
        System.out.println("Element :: "+result);
    }
}
