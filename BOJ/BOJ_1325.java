import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1325{
    static int N,M, cc,max = Integer.MIN_VALUE;
    static HashMap<Integer, ArrayList<Integer>> trust;
    static boolean[] visited;
    static int[] cnt;
    static int BFS(int idx){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N+1];
        queue.add(idx);
        visited[idx] = true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            ArrayList<Integer> list = trust.get(tmp);
            for(int n : list){
                if(!visited[n]){
                    visited[n] = true;
                    cnt[idx]++;
                    queue.add(n);
                }
            }
        }
        return cnt[idx];
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trust = new HashMap<>();
        cnt = new int[N+1];
        for(int i=1;i<=N;i++)
            trust.put(i,new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            trust.get(B).add(A);
        }

        //계산
        for(int i=1;i<=N;i++){
            int n = BFS(i);
            max = max < n ? n : max;
        }
        for(int i=1;i<=N;i++){
            if(max == cnt[i])
                sb.append(i+" ");
        }
        System.out.println(sb);
    }
}