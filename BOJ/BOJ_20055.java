import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;

public class BOJ_20055 {

    static boolean isPossible(int[] remain, int K){
        int cnt=0;
        for(int i=0;i<remain.length;i++){
            if(remain[i]==0)
                cnt++;
            if(cnt==K)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] remain = new int[2*N];
        boolean[] robot= new boolean[N];
        int level=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++)
            remain[i] = Integer.parseInt(st.nextToken());

        //1번 : 올라가는 위치, N번 : 내려가는 위치
        //로봇이 어떤 칸에 올라가거나 이동하면 내구도 1 감소
        //내구도 0 칸에 로봇 올라갈 수 없다.
        while(isPossible(remain,K)){
            int tmp = remain[2*N-1];
            //벨트 회전
            for(int i=2*N-1;i>0;i--)
                remain[i] = remain[i-1];
            remain[0] = tmp;
            //로봇 회전
            for(int i=N-1;i>0;i--)
                robot[i] = robot[i-1];
            robot[0] = false;
            //끝 로봇 내리기
            robot[N-1] = false;
            //로봇 이동
            for(int i=N-1;i>0;i--){
                if(robot[i-1] && !robot[i] && remain[i]>=1){
                    robot[i] = robot[i-1];
                    robot[i-1] = false;
                    robot[i] = true;
                    remain[i]--;
                }
            }
            //올라가는 위치 로봇 올리기
            if(!robot[0] && remain[0]>=1){
                robot[0] = true;
                remain[0]--;
            }
            level++;
        }
        System.out.println(level);
    }
}
