import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;

public class BOJ_2470 {
    static int N;
    static long min = Long.MAX_VALUE;
    static long[] samples;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        samples = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            samples[i] = Long.parseLong(st.nextToken());

        Arrays.sort(samples);
        int front=0, rear = N-1, left=-1,right=-1;
        while(front<rear){
            long sum = samples[front]+samples[rear];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                left = front;
                right = rear;
            }
            if(sum>0)
                rear--;
            else
                front++;

        }
        System.out.println(samples[left]+" "+samples[right]);
        System.out.println(min);
    }
}
