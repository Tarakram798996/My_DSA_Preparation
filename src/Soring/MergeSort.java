public class MergeSort {

    static int[] arr;

    public static void mergeSort(int left,int right){

        if(left<right){
            int mid = left + (right-left)/2;

            mergeSort(left,mid);
            mergeSort(mid+1,right);

            merge(left,mid,right);
        }
    }
    public static void merge(int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] left=new int[n1];
        int[] right=new int[n2];
        for(int i=0;i<n1;i++) left[i]=arr[l+i];
        for(int i=0;i<n2;i++) right[i]=arr[m+1+i];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2){
            if(left[i]<=right[j])
                arr[k++]=left[i++];
            else
                arr[k++]=right[j++];
        }

        while(i<n1) arr[k++]=left[i++];
        while(j<n2) arr[k++]=right[j++];

    }

    public static void main(String args[]){
        arr=new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        mergeSort(0,arr.length-1);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
