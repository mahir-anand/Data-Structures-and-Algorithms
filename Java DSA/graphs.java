import java.util.*;
import java.util.LinkedList;

public class graphs {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }

    }

    static void createGraph(ArrayList<Edge> edges) {

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

    }

    static int n = 4;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    // static void createGraph2(ArrayList<Edge> graph) {

    // graph.add(new Edge(0, 1, 2));
    // graph.add(new Edge(0, 2, 4));
    // graph.add(new Edge(1, 2, -4));
    // graph.add(new Edge(2, 3, 2));
    // graph.add(new Edge(3, 4, 4));
    // graph.add(new Edge(4, 1, -1));

    // }

    // public static void bfs(ArrayList<Edge>[] graph) {
    // boolean[] vis = new boolean[graph.length];
    // for (int i = 0; i < graph.length; i++) {
    // if (!vis[i]) {
    // bfsUtil(graph, vis);
    // }
    // }
    // }

    // public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
    // Queue<Integer> q = new LinkedList<>();
    // q.add(0); // source: 0

    // while (!q.isEmpty()) {

    // int curr = q.remove();

    // if (!vis[curr]) {
    // vis[curr] = true;
    // System.out.print(curr + " ");
    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // q.add(e.dest);
    // }
    // }

    // }

    // }

    // public static void dfs(ArrayList<Edge>[] graph) {
    // boolean[] vis = new boolean[graph.length];
    // for (int i = 0; i < graph.length; i++) {
    // dfsUtil(graph, i, vis);
    // }
    // }

    // public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis)
    // {
    // // visit
    // System.out.print(curr + " ");
    // vis[curr] = true;

    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // if (!vis[e.dest]) {
    // dfsUtil(graph, e.dest, vis);
    // }
    // }

    // }

    // public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest,
    // boolean[] vis) {

    // if (src == dest) {
    // return true;
    // }

    // vis[src] = true;
    // for (int i = 0; i < graph[src].size(); i++) {
    // Edge e = graph[src].get(i);
    // if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
    // return true;
    // }
    // }

    // return false;

    // }

    // public static boolean detectCycle(ArrayList<Edge>[] graph) {
    // boolean[] vis = new boolean[graph.length];
    // for (int i = 0; i < graph.length; i++) {
    // if (!vis[i]) {
    // if (detectCycleUtil(graph, vis, i, -1)) {
    // return true;
    // }
    // }
    // }

    // return false;

    // }

    // public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis,
    // int curr, int par) {
    // vis[curr] = true;

    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // // case 3
    // if (!vis[e.dest]) {
    // if (detectCycleUtil(graph, vis, e.dest, curr)) {
    // return true;
    // }
    // }
    // // case 1
    // else if (vis[e.dest] && e.dest != par) {
    // return true;
    // }
    // // case 2 -> do nothing so that we can continue
    // }

    // return false;

    // }

    // public static boolean isBipartite(ArrayList<Edge>[] graph) {
    // int[] color = new int[graph.length];
    // for (int i = 0; i < color.length; i++) {
    // color[i] = -1; // no color
    // }

    // Queue<Integer> q = new LinkedList<>();

    // for (int i = 0; i < graph.length; i++) {
    // if (color[i] == -1) {
    // q.add(i);
    // color[i] = 0;
    // while (!q.isEmpty()) {
    // int curr = q.remove();
    // for (int j = 0; j < graph[curr].size(); j++) {
    // Edge e = graph[curr].get(j);
    // if (color[e.dest] == -1) {
    // int nextColor = color[curr] == 0 ? 1 : 0;
    // color[e.dest] = nextColor;
    // q.add(e.dest);
    // } else if (color[e.dest] == color[curr]) {
    // return false;
    // }
    // }
    // }
    // }
    // }

    // return true;

    // }

    // public static boolean isCycle(ArrayList<Edge>[] graph) {
    // boolean[] vis = new boolean[graph.length];
    // boolean[] stack = new boolean[graph.length];

    // for (int i = 0; i < graph.length; i++) {
    // if (!vis[i]) {
    // if (isCycleUtil(graph, i, vis, stack)) {
    // return true;
    // }
    // }
    // }

    // return false;

    // }

    // public static boolean isCycleUtil(ArrayList<Edge>[] graph, int cur, boolean[]
    // vis, boolean[] stack) {
    // vis[cur] = true;
    // stack[cur] = true;

    // for (int i = 0; i < graph[cur].size(); i++) {
    // Edge e = graph[cur].get(i);
    // if (stack[e.dest]) {
    // return true;
    // }

    // if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
    // return true;
    // }
    // }

    // stack[cur] = false;

    // return false;

    // }

    // public static void topSort(ArrayList<Edge>[] graph) {
    // boolean[] vis = new boolean[graph.length];
    // Stack<Integer> s = new Stack<>();

    // for (int i = 0; i < graph.length; i++) {
    // if (!vis[i]) {
    // topSortUtil(graph, i, vis, s);
    // }
    // }

    // while (!s.isEmpty()) {
    // System.out.print(s.pop() + " ");
    // }

    // }

    // public static void topSortUtil(ArrayList<Edge>[] graph, int cur, boolean[]
    // vis, Stack<Integer> s) {
    // vis[cur] = true;
    // for (int i = 0; i < graph[cur].size(); i++) {
    // Edge e = graph[cur].get(i);
    // if (!vis[e.dest]) {
    // topSortUtil(graph, e.dest, vis, s);
    // }
    // }
    // s.push(cur);
    // }

    // public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg) {
    // for (int i = 0; i < graph.length; i++) {
    // int v = i;
    // for (int j = 0; j < graph[v].size(); j++) {
    // Edge e = graph[v].get(j);
    // indeg[e.dest]++;
    // }
    // }
    // }

    // public static void topSort(ArrayList<Edge>[] graph) {
    // int[] indeg = new int[graph.length];
    // calcIndeg(graph, indeg);
    // Queue<Integer> q = new LinkedList<>();

    // for (int i = 0; i < indeg.length; i++) {
    // if (indeg[i] == 0) {
    // q.add(i);
    // }
    // }

    // while (!q.isEmpty()) {
    // int cur = q.remove();
    // System.out.print(cur + " ");
    // for (int i = 0; i < graph[cur].size(); i++) {
    // Edge e = graph[cur].get(i);
    // indeg[e.dest]--;
    // if (indeg[e.dest] == 0) {
    // q.add(e.dest);
    // }
    // }
    // }

    // }

    // public static void allPath(ArrayList<Edge>[] graph, int src, int dest, String
    // path) {

    // if (src == dest) {
    // System.out.println(path + dest);
    // return;
    // }

    // for (int i = 0; i < graph[src].size(); i++) {
    // Edge e = graph[src].get(i);
    // allPath(graph, e.dest, dest, path + src);
    // }

    // }

    // static class Pair implements Comparable<Pair> {

    // int n;
    // int path;

    // public Pair(int n, int path) {
    // this.n = n;
    // this.path = path;
    // }

    // @Override
    // public int compareTo(Pair p2) {
    // return this.path - p2.path;
    // }
    // }

    // public static void dijkstra(ArrayList<Edge>[] graph, int src) {
    // int[] dist = new int[graph.length];
    // for (int i = 0; i < graph.length; i++) {
    // if (i != src) {
    // dist[i] = Integer.MAX_VALUE;
    // }
    // }

    // boolean[] vis = new boolean[graph.length];
    // PriorityQueue<Pair> pq = new PriorityQueue<>();
    // pq.add(new Pair(src, 0));

    // while (!pq.isEmpty()) {
    // Pair cur = pq.remove();
    // if (!vis[cur.n]) {
    // vis[cur.n] = true;
    // for (int i = 0; i < graph[cur.n].size(); i++) {
    // Edge e = graph[cur.n].get(i);
    // int u = e.src;
    // int v = e.dest;
    // int wt = e.wt;

    // if (dist[u] + wt < dist[v]) {
    // dist[v] = dist[u] + wt;
    // pq.add(new Pair(v, dist[v]));
    // }
    // }
    // }
    // }

    // for (int i = 0; i < dist.length; i++) {
    // System.out.print(dist[i] + " ");
    // }

    // }

    // public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
    // int[] dist = new int[V];
    // for (int i = 0; i < dist.length; i++) {
    // if (i != src) {
    // dist[i] = Integer.MAX_VALUE;
    // }
    // }

    // for (int i = 0; i < V - 1; i++) {
    // for (int j = 0; j < graph.size(); j++) {
    // Edge e = graph.get(j);
    // int u = e.src, v = e.dest, wt = e.wt;
    // if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
    // dist[v] = dist[u] + wt;
    // }
    // }
    // }

    // for (int i = 0; i < dist.length; i++) {
    // System.out.print(dist[i] + " ");
    // }

    // }

    // static class Pair implements Comparable<Pair> {
    // int v;
    // int cost;

    // public Pair(int v, int c) {
    // this.v = v;
    // this.cost = c;
    // }

    // @Override
    // public int compareTo(Pair p2) {
    // return this.cost - p2.cost;
    // }

    // }

    // public static void prims(ArrayList<Edge>[] graph) {

    // boolean vis[] = new boolean[graph.length];
    // PriorityQueue<Pair> pq = new PriorityQueue<>();
    // pq.add(new Pair(0, 0));
    // int finalCost = 0;

    // while (!pq.isEmpty()) {

    // Pair curr = pq.remove();

    // if (!vis[curr.v]) {
    // vis[curr.v] = true;
    // finalCost += curr.cost;

    // for (int i = 0; i < graph[curr.v].size(); i++) {
    // Edge e = graph[curr.v].get(i);
    // pq.add(new Pair(e.dest, e.wt));
    // }
    // }
    // }

    // System.out.println(finalCost);

    // }

    public static void kruskals(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);
        int count = 0;
        int cost = 0;

        for (int i = 0; count < V - 1; i++) {
            Edge e = edges.get(i);

            int parA = e.src;
            int parB = e.dest;

            if (parA != parB) {
                union(parA, parB);
                cost += e.wt;
                count++;
            }
        }

        System.out.println(cost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskals(edges, V);
    }

}
