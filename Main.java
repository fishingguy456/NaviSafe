import java.io.*;
import java.util.*;
public class Main {
    public static class Node implements Comparable<Node>{
        int node;
        int dist;
        int height;
        public Node(int _n, int _d, int _h) {
            node=_n;
            dist=_d;
            height=_h;
        }
        public int compareTo(Node o) {
            return dist-o.dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node> graph[] = new ArrayList[2001];
        for(int i = 0; i < 2001; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int t = Integer.parseInt(st1.nextToken());
            int h = Integer.parseInt(st1.nextToken());
            graph[a].add(new Node(b, t, h));
            graph[b].add(new Node(a, t, h));
        }PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int distance[] = new int[2001];
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
Collapse



