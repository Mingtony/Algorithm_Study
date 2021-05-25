import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;


public class BOJ_3985 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[][] want = new int[N+1][N+1];
        int[] cnt = new int[N+1];
        boolean[] visited = new boolean[L+1];
        int ori = -1, change = -1, idx1=-1, idx2=-1;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            want[i][0] = Integer.parseInt(st.nextToken());
            want[i][1] = Integer.parseInt(st.nextToken());
            if(ori<(Math.abs(want[i][0]-want[i][1])+1)){
                ori = (Math.abs(want[i][0]-want[i][1])+1);
                idx1 = i;
            }
            for(int j=want[i][0];j<=want[i][1];j++){
                if(!visited[j]){
                    cnt[i]++;
                    visited[j] = true;
                }
            }
        }
        sb.append(idx1+"\n");
        for(int i=1;i<=N;i++){
            if(change< cnt[i]){
                change = cnt[i];
                idx2 = i;
            }
        }
        sb.append(idx2+"\n");
        System.out.println(sb);
    }
}
