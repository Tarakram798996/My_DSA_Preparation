import java.util.*;

class Edge {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class Krushkals {
    static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int[] parent, int a, int b) {
        int x = find(parent, a);
        int y = find(parent, b);
        parent[x] = y;
    }

    public static void main(String[] args) {
        int n = 4;
        Edge[] edges = {
                new Edge(1, 2, 3),
                new Edge(1, 4, 5),
                new Edge(2, 3, 1),
                new Edge(2, 4, 4),
                new Edge(3, 4, 2)
        };

        Arrays.sort(edges, (a, b) -> a.w - b.w);

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int cost = 0, edgesUsed = 0;
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge e : edges) {
            int set1 = find(parent, e.u);
            int set2 = find(parent, e.v);
            if (set1 != set2) {
                System.out.println(e.u + " - " + e.v);
                cost += e.w;
                union(parent, set1, set2);
                edgesUsed++;
            }
            if (edgesUsed == n - 1)
                break;
        }
        System.out.println("Minimum Cost: " + cost);
    }
}
