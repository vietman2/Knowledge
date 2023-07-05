package Knowledge.DataStructure_Algorithms.GraphAlgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    public String BFS(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return sb.toString();
    }

    public String DFS_withoutStack(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();

        visited[start] = true;
        sb.append(start + " ");

        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                sb.append(DFS_withoutStack(i, graph, visited));
            }
        }

        return sb.toString();
    }
    public String DFS_withStack(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int node = stack.pop();
            sb.append(node + " ");

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }

        return sb.toString();
    }
    
    // Spanning Tree
    public void DFSTree(int start, int[][] graph, boolean[] visited) {
        visited[start] = true;

        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                DFSTree(i, graph, visited);
            }
        }
    }
    public void BFSTree(int start, int[][] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    // Minimum Spanning Tree
    // Prim's Algorithm
    // Kruskal's Algorithm
    public void Prim(int[][] graph) {
        int[] parent = new int[graph.length];
        int[] key = new int[graph.length];
        boolean[] mstSet = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < graph.length - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }
    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < key.length; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
    public void Kruskal(int[][] graph) {
        int[] parent = new int[graph.length];
        int min;
        int u = 0;
        int v = 0;
        int noOfEdges = 1;
        int total = 0;

        while(noOfEdges < graph.length) {
            min = Integer.MAX_VALUE;

            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (graph[i][j] < min) {
                        min = graph[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            while(parent[u] != 0) {
                u = parent[u];
            }
            while(parent[v] != 0) {
                v = parent[v];
            }

            if (v != u) {
                noOfEdges++;
                total += min;
                parent[v] = u;
            }

            graph[u][v] = Integer.MAX_VALUE;
            graph[v][u] = Integer.MAX_VALUE;
        }

        System.out.println("Total cost of MST: " + total);
    }

    // Topological Sort
    public void TopologicalSort(int[][] graph) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                TopologicalSortUtil(i, graph, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    private void TopologicalSortUtil(int start, int[][] graph, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;

        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] != 0 && !visited[i]) {
                TopologicalSortUtil(i, graph, visited, stack);
            }
        }

        stack.push(start);
    }

    // Shortest Path
    // Dijkstra's Algorithm
    // Bellman-Ford Algorithm
    public void Dijkstra(int[][] graph, int start) {
        int[] dist = new int[graph.length];
        boolean[] sptSet = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[start] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }
    private int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!sptSet[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
    private void printSolution(int[] dist) {
        System.out.println("Vertex \tDistance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t" + dist[i]);
        }
    }
    public void BellmanFord(int[][] graph, int start) {
        int[] dist = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            for (int u = 0; u < graph.length; u++) {
                for (int v = 0; v < graph.length; v++) {
                    if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        printSolution(dist);
    }


}
