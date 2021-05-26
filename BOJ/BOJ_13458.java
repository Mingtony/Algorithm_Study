import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;


public class BOJ_13458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] classes = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            classes[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        //총감독관 들어가는 경우
        long cnt = N;
        for(int i=0;i<N;i++){
            if(classes[i]-B>0){
                int tmp = (classes[i]-B)%C;
                if(tmp==0)
                    cnt+=((classes[i]-B)/C);
                else
                    cnt+=((classes[i]-B)/C +1);
            }
        }
        System.out.println(cnt);
    }
}
