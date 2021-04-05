import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1325{
    static int N,M, max = Integer.MIN_VALUE;
    static ArrayList<Integer> trust[];
    static boolean[] visited;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trust = new ArrayList[N+1];
        cnt = new int[N+1];
        for(int i=1;i<=N;i++)
            trust[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            trust[A].add(B);
        }
        //계산
        for(int i=1;i<=N;i++){
            queue.add(i);
            visited = new boolean[N+1];
            visited[i] = true;
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                for(int j=0;j<trust[tmp].size();j++){
                    if(!visited[trust[tmp].get(j)]){
                        visited[trust[tmp].get(j)] = true;
                        queue.add(trust[tmp].get(j));
                        cnt[trust[tmp].get(j)]++;
                    }
                }
            }
        }
        for(int i=1;i<=N;i++){
            max = cnt[i] > max ? cnt[i] : max;
        }
        for(int i=1;i<=N;i++){
            if(cnt[i]==max)
                sb.append(i+" ");
        }
        System.out.println(sb);
    }
}