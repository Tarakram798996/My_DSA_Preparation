import java.util.*;
public class Prims {
    public static void prims(int[][] mat,int n){
        int minCost=0;

        boolean[] visted=new boolean[n+1];
        visted[1]=true;

        for(int edge=1;edge<n;edge++){

            int minC=999,u=0,v=0;
            for(int i=1;i<=n;i++){
                if(visted[i]){
                    for(int j=1;j<=n;j++){
                        if(!visted[j] && minC>mat[i][j]){
                            minC=mat[i][j]; u=i;v=j;
                        }
                    }
                }
            }
            visted[v]=true;
            minCost+=minC;
            System.out.println(u+" - "+v);
        }
        System.out.println("Min Cost ::: "+minCost);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertex :: ");
        int n=sc.nextInt();
        int[][] matrix = new int[n+1][n+1];
        System.out.println("Enter the matrix :: ");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                matrix[i][j]=sc.nextInt();
        prims(matrix,n);
    }
}
