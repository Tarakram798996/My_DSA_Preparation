import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {

    static int[] dist;

    public static void bellmanFord(int[][] edges,int v){

        for(int i=1;i<v;i++){
            for(int j=0;j<edges.length;j++){
                int u=edges[j][0];
                int ve=edges[j][1];
                int w=edges[j][2];
                if(dist[u]!=99 && dist[ve]>dist[u]+w){
                    dist[ve]=dist[u]+w;
                }
            }
        }
        boolean negCycle=false;
        for(int j=0;j<edges.length;j++){
            int u=edges[j][0];
            int ve=edges[j][1];
            int w=edges[j][2];
            if(dist[u]!=99 && dist[ve]>dist[u]+w){
                negCycle=true;
            }
        }
        if(negCycle){
            System.out.println("Graph has Neg (-ve) cycle");
        }else{
            for(int i=1;i<=v;i++) System.out.println("to "+i+" : "+dist[i]+" ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of vertex : ");
        int v=sc.nextInt();

        System.out.println("Enter no of edges : ");
        int e=sc.nextInt();

        int[][] edges=new int[e][3];
        dist=new int[v+1];
        Arrays.fill(dist,999);

        for(int i=0;i<e;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
            edges[i][2]=sc.nextInt();
        }
        System.out.println("Enter src vertex");
        int s = sc.nextInt();

        dist[s]=0;

        bellmanFord(edges,v);
    }
}
