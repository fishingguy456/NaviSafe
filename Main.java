import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Node> graph[] = new ArrayList[140];

	public static class Node implements Comparable<Node>{
		int node;
		double rate;
		public Node(int _n, double _r) {
			node=_n;
			rate=_r;
		}
		public int compareTo(Node o) {
			return (int) (rate-o.rate);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());
		
		readFile();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		double rate[] = new double[140];
		String route[] = new String[140];
		Arrays.fill(route, "");
		Arrays.fill(rate, Integer.MAX_VALUE);

		
		pq.add(new Node(a, 0));
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int N = curr.node;
			double R = curr.rate;
			if(rate[N] > R) {
				rate[N] = R;
				route[N] += "\n"+N;
				for(int i = 0; i < graph[N].size(); i++) {
					double risk = graph[N].get(i).rate;
					int node = graph[N].get(i).node;
					pq.add(new Node(node, risk+R));
					
				}
			}
		}if (rate[b]!=Integer.MAX_VALUE) {
			System.out.println(rate[b]+" "+route[b]);
		} else {
			System.out.println("Not possible");
		}
	}

	public static void readFile() {
		//the program will try to find the file data which is saved as a text file
		//if the file does not exist, it will generate a new file with this name

		//initiates the file
		File textFile = new File("data.csv");

		//********If a file is found**************
		if (textFile.exists() && !textFile.isDirectory()) {
			//reading from the file to fill variables
			System.out.println("file successfully found... collecting data");
			try {
				//creates the writer for the file
				FileReader MyReader = new FileReader("data.csv");
				BufferedReader MyBuffer = new BufferedReader(MyReader);

				//reading the file and adding the strings to the student list
				//Need to read first line in order to remove titles from data
				String nextLine = MyBuffer.readLine();
				//other temporary variables used
				String[] tmpStrings;
				
				for(int i = 0; i < 140; i++) {
					graph[i] = new ArrayList<Node>();
				}
				
				while ((nextLine = MyBuffer.readLine()) != null) {
					tmpStrings = nextLine.split("\t");

					//trims off spaces of each variable that may have been entered
					for (int i=0; i<tmpStrings.length; i++) {
						tmpStrings[i] = tmpStrings[i].trim();
					}

					//do something to make the second veriable an int 
					int tmpInt = Integer.parseInt(tmpStrings[1]);

					//do something to make the third veriable a double
					double tmpDouble = Double.parseDouble(tmpStrings[2]);
					
					System.out.println(tmpInt+" "+tmpDouble);


					//adds the student to the master list
					graph[tmpInt].add(new Node(tmpInt, tmpDouble));
					
					if (tmpInt<138) {
						System.out.println(tmpInt+" "+tmpDouble);
						graph[tmpInt].add(new Node(tmpInt+1, tmpDouble));
						if (tmpInt<139) {
							graph[tmpInt].add(new Node(tmpInt+2, tmpDouble));
						}
					}
					else if (tmpInt>0) {
						System.out.println(tmpInt+" "+tmpDouble);
						graph[tmpInt].add(new Node(tmpInt-1, tmpDouble));
						if (tmpInt>1) {
							graph[tmpInt].add(new Node(tmpInt-2, tmpDouble));
						}
					}

				}//end while loop for reading info


				MyBuffer.close();//closes buffer so file does not corrupt

			} catch (IOException e) {
				System.out.println("error while reading file");
			}


			//********If no file of that name is found***************
		} else {
			System.out.println("Humber Summit: 21\nBlack Creek: 24\nYork University Heights: 27\nBathurst Manor: 34");
		}

	}//end of 

}
