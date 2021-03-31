import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_15649 {
    static int[] arr;
    static int[] tmp;
    static boolean[] visited;
    static StringBuilder sb;
    static void backtracking(int st, int depth, int N, int std){
        if(depth == std){
            for(int n : tmp)
                sb.append(n+" ");
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = arr[i];
                backtracking(i+1,depth+1,N,std);
                visited[i] = false;
            }

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
        arr = new int[N];
        tmp = new int[M];
        visited = new boolean[N];
        for(int i=1;i<=N;i++)
            arr[i-1] = i;

        backtracking(0,0,N,M);
        System.out.println(sb);
    }
}


