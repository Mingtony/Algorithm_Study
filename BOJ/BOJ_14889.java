import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_14889 {
    static int N,min = Integer.MAX_VALUE;
    static int[][] S;
    static int[] start;
    static int[] tmp;
    static int sum;
    static void pair_dfs(int[] list,int st, int depth, int std){
        if(depth == std){
            sum+=(S[tmp[0]][tmp[1]] +S[tmp[1]][tmp[0]]);
            return;
        }
        for(int i=st;i<list.length;i++){
            tmp[depth] = list[i];
            pair_dfs(list,i+1,depth+1,std);
        }
    }
    static void dfs(int st, int depth, int std){
        if(depth == std){
            boolean[] chk = new boolean[N+1];
            int[] link = new int[std];
            int idx=0, s_start=0, s_link=0;
            for(int n : start){
                //System.out.println(n+" ");
                chk[n] = true;
            }
            for(int i=0;i<N;i++){
                if(!chk[i]){
                    //System.out.println(idx);
                    link[idx++] = i;
                }

            }
            tmp = new int[2];
            pair_dfs(start,0,0,2);
            s_start = sum;
            sum=0;
            tmp = new int[2];
            pair_dfs(link,0,0,2);
            s_link = sum;
            sum=0;
            min = Math.abs(s_start-s_link) < min ? Math.abs(s_start-s_link) : min;
            return;
        }
        for(int i=st;i<N;i++){
            start[depth] = i;
            dfs(i+1,depth+1,std);
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }

        start = new int[N/2];
        dfs(0,0,N/2);
        System.out.println(min);
    }
}


