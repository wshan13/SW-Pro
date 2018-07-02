import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * N���� ���ð� �ִ�. �� ���ô� 1������ N������ ��ȣ�� �Ű����ִ�. �׸��� ���� �ٸ� �� ���ø� �մ� M���� ���ΰ� �ִ�. 
 * ���θ��� ���̰� �ٸ� �� ������, ��� �� ���ô� ���� ���� ���η� �̾��� ���� �� �ִ�.
 * �¾����� ���� 1�� ���ÿ� �ְ�, ����� ���� N�� ���ÿ� �ִ�. �¾��̴� �ڽ��� ������ ����� ������ ������� �Ѵ�. 
 * ��, �����̶� ���� ��츦 ���� �;��ϴ� ������ �ִ��� ������ �̵��Ϸ��� �Ѵ�.
 * �¾��̸� ���� 1�� ���ÿ��� N�� ���÷� ���� �ִ� �Ÿ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �� ���ͽ�Ʈ�� �˰���
 */
public class pro_07_4_SHORTEST_PATH {

	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_07_4_SHORTEST_PATH.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // ������ �� N
		M = Integer.parseInt(st.nextToken()); // ������ ���� M

		ArrayList<Integer>[] adjList = new ArrayList[N+1];	// ���ú� ��������Ʈ �迭
		
		int[][] distanceInfo = new int[M+1][3];
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			distanceInfo[i][0] = Integer.parseInt(st.nextToken());	// a�� ����
			distanceInfo[i][1] = Integer.parseInt(st.nextToken());	// b�� ����
			distanceInfo[i][2] = Integer.parseInt(st.nextToken());	// a-b ���ð� ���� ����
			
			if(adjList[distanceInfo[i][0]] == null) { adjList[distanceInfo[i][0]] = new ArrayList<Integer>(); }
            if(adjList[distanceInfo[i][1]] == null) { adjList[distanceInfo[i][1]] = new ArrayList<Integer>(); }
              
            adjList[distanceInfo[i][0]].add(distanceInfo[i][1]);
            adjList[distanceInfo[i][1]].add(distanceInfo[i][0]);
		}
		
        for(int i = 1 ; i <= N ; i++) {
            System.out.println(i + " �� " + adjList[i]);
        }
        System.out.println("");		
		
		int[] shortestPath = new int[M+1];		// Ư�� �������� �ִܰŸ� �迭
		for(int i = 0 ; i <= M ; i++) {
			shortestPath[i] = Integer.MAX_VALUE;
		}
		
		boolean[] isVisited = new boolean[M+1];	// �湮���� üũ�� �迭
		
		// ���۳�� �۾�
		shortestPath[0] = 0;	shortestPath[1] = 0;
		isVisited[0] = true;	isVisited[1] = true;
		
		for(int i = 1 ; i <= N ; i++) {
			System.out.println(i + " ���� ����");
			for (int j = 0; j < adjList[i].size() ; j++) {
				System.out.println( " ���� " + adjList[i].get(j) + " ó�� : " + i + "-" + adjList[i].get(j) + "�� �Ÿ� ");
			}
		}
		
	}
}