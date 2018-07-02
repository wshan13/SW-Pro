import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;
  
public class pro_07_1_SDS_PRO_10_1 {
  
    static int V ;
    static int E ;
    static int S ;
    static boolean[] visited;
  
    public static void main(String[] args) throws Exception {
  
		System.setIn(new FileInputStream("pro_07_1_SDS_PRO_10_1.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());       // ������ ����
        E = Integer.parseInt(st.nextToken());       // ������ ����
        S = Integer.parseInt(st.nextToken());       // ���� ������ ��ȣ
          
        ArrayList<Integer>[] order = new ArrayList[V+1];
          
        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
              
            if(order[i1] == null) { order[i1] = new ArrayList<Integer>(); }
            if(order[i2] == null) { order[i2] = new ArrayList<Integer>(); }
              
            order[i1].add(i2);
            order[i2].add(i1);
        }
          
        //for(int i = 1 ; i <= V ; i++) {
        //    System.out.println(i + " �� " + order[i]);
        //}
        //System.out.println("");
          
        for(int i=1; i<=V ; i++) {
            Collections.sort(order[i]);
        }
          
        visited = new boolean[V+1]; 
        dfs(S, order);
        System.out.println("");
         
        visited = new boolean[V+1]; 
        bfs(S, order);
    }
      
    static void bfs(int s, ArrayList<Integer>[] source) {
          
        visited[s] = true;
          
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(s);
          
        while(queue.size() > 0) {
            int node = queue.poll();    // queue���� �۾��� ���� ������.
            System.out.print(node + " ");
            for(int i = 0 ; i < source[node].size() ; i++) {
                int _i_find_num = source[node].get(i);
                if(visited[_i_find_num] == false) {     // �湮���� �ʾ��� ���
                    visited[_i_find_num] = true;            // �湮�ߴٰ� ǥ���ϰ�,
                    queue.add(_i_find_num);
                }
            }
        }
    }
      
    static void dfs(int s, ArrayList<Integer>[] source) {
         
        System.out.print(s + " ");
        visited[s] = true;
         
        for(int i = 0 ; i < source[s].size() ; i++) {    // ������ ��� ��������Ʈ�� ���� �湮
            int next = source[s].get(i);
            if(visited[next] == false){ 
                visited[next] = true;
                dfs(next, source);
            }
        }
    }
}