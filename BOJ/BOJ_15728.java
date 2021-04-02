import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_15728 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] btn = new int[N+2];
        int cnt=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            btn[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            if(btn[i]==1) {
                cnt++;
                if(btn[i+1]==0)
                    btn[i+1] = 1;
                else
                    btn[i+1]=0;
                if(btn[i+2]==0)
                    btn[i+2] = 1;
                else
                    btn[i+2]=0;
            }
        }
        System.out.println(cnt);
    }
}


