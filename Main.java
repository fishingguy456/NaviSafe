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
        public static ArrayList<Node> graph[] = new ArrayList[2001];
        for(int i = 0; i < 2001; i++) {
            graph[i] = new ArrayList<Node>();
        }
        readFile("data")
	PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int distance[] = new int[140];
        String route[] = new String[140];
        Arrays.fill(route, "")
        boolean visited[] = new boolean[140];
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

public static void readFile(String fileName) {
	//the program will try to find the file data which is saved as a text file
	//if the file does not exist, it will generate a new file with this name
	
	//initiates the file
	File textFile = new File(fileName + ".csv");

	//********If a file is found**************
	if (textFile.exists() && !textFile.isDirectory()) {
		//reading from the file to fill variables
		System.out.println("file successfully found... collecting data");
		try {
			//creates the writer for the file
			FileReader MyReader = new FileReader(fileName + ".csv");
			BufferedReader MyBuffer = new BufferedReader(MyReader);

			//reading the file and adding the strings to the student list
			//Need to read first line in order to remove titles from data
			String nextLine = MyBuffer.readLine();
			//other temporary variables used
			String[] tmpStrings;
			String title;
			int area;
			double rate;
			while ((nextLine = MyBuffer.readLine()) != null) {
				tmpStrings = nextLine.split("\t");

				//trims off spaces of each variable that may have been entered
				for (int i=0; i<tmpStrings.length; i++) {
					tmpStrings[i] = tmpStrings[i].trim();
				}
				
				//do something to make the second veriable an int 
				int tmpInt = Integer.parseInt(tmpStrings[1])
		
				//do something to make the third veriable a double
				double tmpDouble = Double.parseDouble(tmpStrings[2])
				
				//adds the student to the master list
				Node node = new Node(tmpStrings[0], tmpInt, tmpDouble);
				graph.add(node);
				if (a<138) {
                			graph[a].add(new Node(a+1, t, r));
					if (a<139) {
						graph[a].add(new Node(a+2, t, r));
					}
            			}
			    	if (a>0) {
					graph[a].add(new Node(a-1, t, r));
					if (a>1) {
						graph[a].add(new Node(a-2, t, r));
					}
			    	}

			}//end while loop for reading info


			MyBuffer.close();//closes buffer so file does not corrupt

		} catch (IOException e) {
			System.out.println("error while reading file");
		}


		//********If no file of that name is found***************
	} else {
		//creating the event with the input event name
		System.out.println("no file of that name found... generating new file");
		try {
			//creates the writer for the file; creating the file
			FileWriter MyWriter = new FileWriter(eventName + ".csv");
			MyWriter.close();
		} catch (IOException e) {
			System.out.println("error while writing file");
		}

	}


}//end of function






