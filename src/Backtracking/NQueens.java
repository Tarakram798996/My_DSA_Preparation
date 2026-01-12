public class NQueens {
    static int[] loc;
    public static void nQueens(int pos,int n){
        if(pos>=n){
            write();
            return;
        }
        for(int i=0;i<n;i++){
            if(place(pos,i)){
                loc[pos]=i;
                nQueens(pos+1,n);
            }
        }
    }
    public static boolean place(int row,int col) {
        for(int i=0;i<row;i++)
            if(loc[i]==col || Math.abs(loc[i]-col)==Math.abs(i-row)) return false;

        return true;
    }
    public static void write(){
        System.out.println();
        for(int i : loc)
            System.out.print(i+" ");
    }
    public static void main(String[] args){
        int n=4;
        loc=new int[n];
        nQueens(0,n);
    }
}
