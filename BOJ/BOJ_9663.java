import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_9663 {
    static int N,answer;
    static int[] chessPane;
    static int cnt;
    static boolean isPossible(int col){
        for(int i=0;i<col;i++){
            if(chessPane[col] == chessPane[i])
                return false;
            else if(Math.abs(col-i) == Math.abs(chessPane[col]-chessPane[i]))
                return false;
        }
        return true;
    }
    static void backtracking(int depth){
        if(depth == N){
            cnt++;
            return;
        }
        for(int i=0;i<N;i++){
            chessPane[depth] = i;
            if(isPossible(depth)){
                backtracking(depth+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        chessPane = new int[N];
        backtracking(0);
        System.out.println(cnt);
    }
}


