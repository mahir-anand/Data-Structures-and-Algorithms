class Solution {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge (int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info (int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public void createGraph (int[][] flights, ArrayList<Edge> graph[]) {
        
        for (int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge (src, dest, wt);
            graph[src].add(e);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        for (int i = 0 ; i < n ; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            } 
            for (int i = 0 ; i < graph[curr.v].size() ; i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dst];
        }

    }
}