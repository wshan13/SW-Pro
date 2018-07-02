import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class pro_10_5_FARTHEST_PAIR {
	
	static int N;
	static int[][] coordinates;
	
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("pro_10_5_FARTHEST_PAIR.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		coordinates = new int[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			coordinates[i][0] = Integer.parseInt(st.nextToken());
			coordinates[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coordinates, new Comparator<int[]>() {
			@Override
			public int compare(int[] args1, int[] args2) {
				if(args1[0] == args2[0]) {
					return args1[1] > args2[1] ? 1 : -1;
				} else {
					return args1[0] > args2[0] ? 1 : -1;
				}
			}
		});		
		long distance1 = distance_pow(new Coordinate(coordinates[0][0], coordinates[0][1]), new Coordinate(coordinates[N-1][0], coordinates[N-1][1]));
		printArray();
		
		Arrays.sort(coordinates, new Comparator<int[]>() {
			@Override
			public int compare(int[] args1, int[] args2) {
				if(args1[1] == args2[1]) {
					return args1[0] > args2[0] ? 1 : -1;
				} else {
					return args1[1] > args2[1] ? 1 : -1;
				}
			}
		});	
		long distance2 = distance_pow(new Coordinate(coordinates[0][0], coordinates[0][1]), new Coordinate(coordinates[N-1][0], coordinates[N-1][1]));
		printArray();
		
		System.out.print(Math.max(distance1, distance2));
		
	}
	
	static void sort() {
		Arrays.sort(coordinates, new Comparator<int[]>() {
			@Override
			public int compare(int[] args1, int[] args2) {
				if(args1[0] == args2[0]) {
					return args1[1] > args2[1] ? 1 : -1;
				} else {
					return args1[0] > args2[0] ? 1 : -1;
				}
			}
		});				
	}
	
	static long distance_pow(Coordinate a, Coordinate b) {
		long tmp1 = (b.x - a.x);
		long tmp2 = (b.y - a.y);
		return (tmp1*tmp1) + (tmp2*tmp2);
	}
	
	static void printArray() {
		for(int i = 0 ; i < N ; i++) {
			System.out.println(coordinates[i][0] + " " + coordinates[i][1]);
		}
		System.out.println("");
	}
}

class Coordinate {
	long x;
	long y;
	
	public Coordinate(long x, long y) {
		this.x = x;
		this.y = y;
	}
}