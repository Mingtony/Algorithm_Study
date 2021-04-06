import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Knight{
    int sword;
    int r,c,time;
    public Knight(int sword, int r, int c,int time){
        this.sword = sword;
        this.r = r;
        this.c = c;
        this.time = time;
    }
}
public class BOJ_17836 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Knight> queue;
    static int N, M, T, min = Integer.MAX_VALUE;

    static boolean chk_bdr(int r, int c) {
        if ((r >= 0 && r < N) && (c >= 0 && c < M))
            return true;
        return false;
    }
    static boolean bfs(int r, int c){
        queue.add(new Knight(0,r,c,0));
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            Knight kn = queue.poll();
            if(map[kn.r][kn.c]==2)
                kn.sword = 1;
            if(kn.time == T)
                break;
            for(int i=0;i<4;i++){
                int cr = kn.r+dr[i];
                int cc = kn.c+dc[i];
                if(chk_bdr(cr,cc) && !visited[kn.sword][cr][cc]){
                    if(cr == N-1 && cc == M-1){
                        min = kn.time+1;
                        return true;
                    }
                    if(map[cr][cc] == 1 && kn.sword==1){//그람 보유중인데 벽 만난 경우
                        visited[kn.sword][cr][cc] = true;
                        queue.add(new Knight(kn.sword,cr,cc,kn.time+1));
                    }
                    else if(map[cr][cc] == 0 || map[cr][cc] == 2){
                        visited[kn.sword][cr][cc] = true;
                        queue.add(new Knight(kn.sword,cr,cc,kn.time+1));
                    }
                    else
                        continue;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int g_r=-1,g_c=-1;
        map = new int[N][M];
        visited = new boolean[2][N][M];
        queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //계산
        if(bfs(0,0))
            System.out.println(min);
        else
            System.out.println("Fail");

    }
}
