import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class pro_02_2_SDS_PRO_3_4_TOWER {
 
    static int[] postion;
    static Stack<Integer> stack_position = new Stack<Integer>();
    //static Stack<Integer> stack_height = new Stack<Integer>();
    static int min_postion;
    static int tmp;
     
    public static void main(String[] args) throws Exception {
 
    	System.setIn(new FileInputStream("pro_02_2_SDS_PRO_3_4_TOWER.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int N = Integer.parseInt(br.readLine());        // ž��  �� 
         
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        postion = new int[N];
        for(int i = 0 ; i < N ; i++) {
            postion[i] = Integer.parseInt(st.nextToken());
            // ���� ���� ���� stack������ ũ�ٸ� �������� ����
            // ������ �Ӹ� �ƴ϶� ������ stack���� ���纸�� ���� ��� ���� �����ؾ� ��
            while(!stack_position.empty() && postion[stack_position.peek()-1] < postion[i]) {
                stack_position.pop();
                //stack_height.pop();
            }
             
            //�������� ������ ���Ŀ� Queue�� ������ ���� �ε����� �ȴ�
            bw.write(stack_position.empty() ? 0 + " " : stack_position.peek() + " ");
             
            stack_position.add(i+1);
            //stack_height.add(postion[i]);
             
            //System.out.println(stack_position);
            //System.out.println(stack_height);
        }
        
        br.close();
        bw.close();
    }
 
    static int getTowerNum(int towerNum) {
 
        for(int j = towerNum-1 ; j >= 0 ; j--) {
            System.out.println(j + "(" + postion[j] + ")" + " �� " + towerNum + "(" + postion[towerNum] + ") �� ");
            if(postion[j] >= postion[towerNum]) {
                return j+1;
            } 
        }
        return 0;
    }
     
     
    static int getTowerNum2(int towerNum) {
         
        for(int j = towerNum-1 ; j >= tmp ; j--) {
            System.out.println(j + "(" + postion[j] + ")" + " �� " + towerNum + "(" + postion[towerNum] + ") �� ");
            if(postion[j] >= postion[towerNum]) {
                return j+1;
            } 
        }
        return 0;
    }
     
}
