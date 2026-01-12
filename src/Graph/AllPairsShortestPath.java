public class AllPairsShortestPath {
    static int INF = Integer.MAX_VALUE;
    public static void apsp(int[][] graph){
        int n=graph.length;

        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    if(graph[i][k] != INF && graph[k][j] != INF && graph[i][j]>graph[i][k]+graph[k][j])
                        graph[i][j]=graph[i][k]+graph[k][j];

        System.out.println("All pairs shortest Path :: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(graph[i][j]+" ");
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] graph = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };
        apsp(graph);
    }
}
