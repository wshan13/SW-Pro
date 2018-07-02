import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class pro_07_2_SDS_PRO_10_2 {
 
    static int V;
    static int E;
    static int[][] indegree;
 
    public static void main(String[] args) throws Exception {
 
    	System.setIn(new FileInputStream("pro_07_2_SDS_PRO_10_2.txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
 
        ArrayList<Integer>[] order = new ArrayList[V + 1];
        indegree = new int[V][2];
        for (int i = 0; i < V; i++) {
            indegree[i][0] = i+1;
        }
 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            if (order[x] == null) {
                order[x] = new ArrayList<Integer>();
            }
 
            order[x].add(y);
            indegree[y-1][1]++;
        }
 
        //for (int i = 1; i <= V; i++) {
        //  System.out.println(i + " → " + order[i]);
        //}
        //System.out.println("");
 
        //sort_IndegreeArray();
        //print_IndegreeArray();
         
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if(indegree[i][1] == 0){
                stack.push(indegree[i][0]);             
            }
        }
        
        System.out.println(indegree[1][0] + " unique");
         
        while (!stack.empty()) {    // 스택이 비어 있을때까지 계속
            int vertexNum = stack.pop();    // 스택에서 정점의 번호를 가져오고
            //System.out.print(vertexNum + " ");
            if(order[vertexNum] != null){
                for(int i = 0 ; i < order[vertexNum].size() ; i++){  // 정점의 인접리스트를 모두 체크
                    int nextNum = order[vertexNum].get(i);          // 다음번호
                    //System.out.println("다음번호 : "+ nextNum + ", indegree[" + (nextNum-1) + "][1] : " + indegree[nextNum-1][1] + ", " + indegree[nextNum-1][0]);
                    if(--indegree[nextNum-1][1] == 0){
                        stack.push(indegree[nextNum-1][0]);
                    }
                }
            }
        }
        
    }
     
    static void sort_IndegreeArray(){
        Arrays.sort(indegree, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[1] == arr2[1]){
                    return arr1[0] > arr2[0] ? 1 : -1;
                } else {
                    return arr1[1] > arr2[1] ? 1 : -1;
                }
            }
        });
    }
     
    static void print_IndegreeArray(){
        System.out.println("indegree { ");
        for (int i = 0; i < V; i++) {
            System.out.println( " [ " + indegree[i][0] + " , " + indegree[i][1] + " ]");
        }
        System.out.println("}");
    }   
}
