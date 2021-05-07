import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;
public class BOJ_16510 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] queue = new int[N];
        queue[0] = Integer.parseInt(st.nextToken());
        //부분합 구하기
        for(int i=1;i<N;i++)
            queue[i] = queue[i-1] + Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            int time = Integer.parseInt(br.readLine());
            int left=0, right = N-1;
            int mid = 0;
            //이진탐색
            while(left<=right){
                mid = (left+right)/2;
                if(time>=queue[mid])
                    left = mid+1;
                else
                    right = mid-1;
            }
            sb.append(left+"\n");
        }
        System.out.println(sb);
    }
}
