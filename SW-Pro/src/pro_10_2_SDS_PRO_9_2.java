import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_10_2_SDS_PRO_9_2 {
	
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("pro_10_2_SDS_PRO_9_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());		// 다각형을 이루는 점의 갯수
		int[][] postion = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			postion[i][0] = Integer.parseInt(st.nextToken());
			postion[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		Point P1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine(), " ");
		Point P2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));		
		
		Point P3 = new Point(postion[0][0], postion[0][1]);
		Point P4 = new Point(postion[1][0], postion[1][1]);
		
		isCross(P1, P2, P3, P3);
	}
	
	static boolean isCross(Point p1, Point p2, Point p3, Point p4) {
		return ccw(p1, p2, p3) * ccw(p1, p2, p4) < 0 && ccw(p3, p4, p1) * ccw(p3, p4, p2) < 0;
	}
	
	static int ccw(Point a, Point b, Point c) {
		long tmp = a.x*b.y + b.x*c.y + c.x*a.y -a.y*b.x - b.y*c.x - c.y*a.x;
		if(tmp < 0) {
			return -1;
		}
		if(tmp > 0) {
			return 1;
		}
		return 0;
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}