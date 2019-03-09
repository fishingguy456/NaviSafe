import java.io.*;
import java.util.*;
public class Main {
    public static class Node implements Comparable<Node>{
        int node;
        int dist;
        double rate;
        public Node(int _n, int _d, double _r) {
            node=_n;
            dist=_d;
            rate=_r;
        }
        public int compareTo(Node o) {
            return rate-o.rate;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int crimeRate = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node> graph[] = new ArrayList[2001];
        /*for(int i = 0; i < 2001; i++) {
            graph[i] = new ArrayList<Node>();
        }*/
        for(int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st1.nextToken());
            int t = Integer.parseInt(st1.nextToken());
            int r = Integer.parseInt(st1.nextToken());
            if (a>2) {
                graph[a].add(new Node(a+1, t, r));
            }
            graph[a].add(new Node(a-1, t, r));
            graph[a].add(new Node(a-2, t, r));
            graph[a].add(new Node(a+2, t, r));
        }PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int distance[] = new int[2001];
        String route[] = new String[2001];
        Arrays.fill(route, "")
        boolean visited[] = new boolean[2001];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Node(a, 0, 0));
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int N = curr.node;
            int D = curr.dist;
            int H = curr.height;
            if(H < k && distance[N] > D) {
                distance[N] = D;
                String[N] += "\n"+N;
                for(int i = 0; i < graph[N].size(); i++) {
                    int time = graph[N].get(i).dist;
                    int damage = graph[N].get(i).height;
                    int node = graph[N].get(i).node;
                    if(H+damage<k) {
                        pq.add(new Node(node, time+D, damage+H));
                    }
                }
            }
        }if (distance[b]!=Integer.MAX_VALUE) {
            System.out.println(distance[b]);
        } else {
            System.out.println(-1);
        }
    }
}






