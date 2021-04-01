import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_15650 {
    static int[] tmp;
    static StringBuilder sb;
    static void backtracking(int st,int depth, int N, int std){
        if(depth == std){
            for(int n : tmp)
                sb.append(n+" ");
            sb.append("\n");
            return;
        }
        for(int i=st;i<=N;i++){
            tmp[depth] = i;
            backtracking(i,depth+1,N,std);
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        tmp = new int[M];

        backtracking(1,0,N,M);
        System.out.println(sb);
    }
}