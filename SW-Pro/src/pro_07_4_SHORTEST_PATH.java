import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * N개의 도시가 있다. 각 도시는 1번부터 N번까지 번호가 매겨져있다. 그리고 서로 다른 두 도시를 잇는 M개의 도로가 있다. 
 * 도로마다 길이가 다를 수 있으며, 어떠한 두 도시는 여러 개의 도로로 이어져 있을 수 있다.
 * 태양이의 집은 1번 도시에 있고, 명우의 집은 N번 도시에 있다. 태양이는 자신의 집에서 명우의 집으로 놀러가려고 한다. 
 * 단, 조금이라도 빨리 명우를 보고 싶어하는 마음에 최대한 빠르게 이동하려고 한다.
 * 태양이를 도와 1번 도시에서 N번 도시로 가는 최단 거리를 구하는 프로그램을 작성하시오.
 * 
 * → 다익스트라 알고리즘
 */
public class pro_07_4_SHORTEST_PATH {

	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_07_4_SHORTEST_PATH.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 도시의 수 N
		M = Integer.parseInt(st.nextToken()); // 도로의 개수 M

		ArrayList<Integer>[] adjList = new ArrayList[N+1];	// 도시별 인접리스트 배열
		
		int[][] distanceInfo = new int[M+1][3];
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			distanceInfo[i][0] = Integer.parseInt(st.nextToken());	// a번 도시
			distanceInfo[i][1] = Integer.parseInt(st.nextToken());	// b번 도시
			distanceInfo[i][2] = Integer.parseInt(st.nextToken());	// a-b 도시간 도로 길이
			
			if(adjList[distanceInfo[i][0]] == null) { adjList[distanceInfo[i][0]] = new ArrayList<Integer>(); }
            if(adjList[distanceInfo[i][1]] == null) { adjList[distanceInfo[i][1]] = new ArrayList<Integer>(); }
              
            adjList[distanceInfo[i][0]].add(distanceInfo[i][1]);
            adjList[distanceInfo[i][1]].add(distanceInfo[i][0]);
		}
		
        for(int i = 1 ; i <= N ; i++) {
            System.out.println(i + " → " + adjList[i]);
        }
        System.out.println("");		
		
		int[] shortestPath = new int[M+1];		// 특정 정점까지 최단거리 배열
		for(int i = 0 ; i <= M ; i++) {
			shortestPath[i] = Integer.MAX_VALUE;
		}
		
		boolean[] isVisited = new boolean[M+1];	// 방문여부 체크용 배열
		
		// 시작노드 작업
		shortestPath[0] = 0;	shortestPath[1] = 0;
		isVisited[0] = true;	isVisited[1] = true;
		
		for(int i = 1 ; i <= N ; i++) {
			System.out.println(i + " 정점 선택");
			for (int j = 0; j < adjList[i].size() ; j++) {
				System.out.println( " 인접 " + adjList[i].get(j) + " 처리 : " + i + "-" + adjList[i].get(j) + "간 거리 ");
			}
		}
		
	}
}