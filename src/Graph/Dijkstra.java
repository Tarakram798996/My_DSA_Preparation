import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    static int[] dist;
    static boolean[] visited;
    public static void dijkstra(int[][] graph,int st){
        Arrays.fill(dist,999);
        dist[st]=0;

        for(int i=1;i<graph.length;i++){
            int next=nextNode();
            visited[next]=true;
            for(int j=1;j<dist.length;j++){
                if(!visited[j] && graph[next][j]!=999 && dist[next]+graph[next][j]<dist[j]){
                    dist[j]=dist[next]+graph[next][j];
                }
            }
        }
        System.out.println("\nShortest distances from source " + st + ":");
        for (int i = 1; i < dist.length; i++)
            System.out.println("To vertex " + i + " = " + dist[i]);
    }
    public static int nextNode(){
        int max=999;
        int idx=0;
        for(int i=1;i<dist.length;i++){
            if(!visited[i] && max>=dist[i]){
                max=dist[i]; idx=i;
            }
        }
        return idx;
    }
    public static void main(String[] args){
        Scanner sc  =new Scanner(System.in);
        int n=sc.nextInt();
        int[][] graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                graph[i][j]=sc.nextInt();
        dist=new int[n+1];
        visited=new boolean[n+1];
        dijkstra(graph,1);
    }
}
