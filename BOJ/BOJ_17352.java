import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;


public class BOJ_17352 {
    static int[] parent;
    static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[y] = x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashSet<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int ans_from = -1, ans_to = -1;
        parent = new int[N+1];
        for(int i=1;i<=N;i++)
            parent[i] = i;
        for(int i=0;i<N-2;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from,to);
        }
        for(int i=1;i<=N;i++)
            set.add(find(i));
        for(int snum : set)
            sb.append(snum+" ");
        System.out.println(sb);
    }
}
