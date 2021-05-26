import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;


public class BOJ_1018 {
    static int min=Integer.MAX_VALUE;
    static void calc_color(boolean[][] chess, int fr, int fc){
        boolean first = chess[fr][fc];
        int cnt=0;
        for(int i=fr;i<fr+8;i++){
            for(int j=fc;j<fc+8;j++){
                if(chess[i][j]!=first){
                    cnt++;
                }
                first = !first;
            }
            first = !first;
        }
        min = Math.min(min,Math.min(cnt,64-cnt));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] chess = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                if(str.charAt(j)=='W')
                    chess[i][j] = true;
                else
                    chess[i][j] = false;
            }
        }
        //계산
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                calc_color(chess,i,j);
            }
        }
        System.out.println(min);
    }
}
