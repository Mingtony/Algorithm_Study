import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_17471 {
    static int N, min = Integer.MAX_VALUE;
    static int[] human;
    static boolean[][] inc;
    static int[] tmp;
    static int[] area;
    static boolean[] visited;
    static boolean chk;

    static int get_human(int[] arr, int len){
        int cnt=0;
        for(int i=0;i<len;i++){
            cnt+=human[arr[i]-1];
        }
        return cnt;
    }
    static boolean is_contains(int[] arr, int num, int len){
        for(int i=0;i<len;i++){
            if(arr[i]==num)
                return true;
        }
        return false;
    }
    static boolean is_possible(int[] bArr, int aLen, int bLen){
        //A
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visit = new boolean[N+1];
        queue.add(tmp[0]);
        while(!queue.isEmpty()){
            int n = queue.poll();
            visit[n] = true;
            for(int i=1;i<=N;i++) {
                if (!visit[i] && inc[n][i] && is_contains(tmp, i, aLen))
                    queue.add(i);
            }
        }
        for(int i=0;i<aLen;i++){
            if(!visit[tmp[i]])
                return false;
        }
        //B
        Arrays.fill(visit,false);
        queue.add(bArr[0]);
        while(!queue.isEmpty()){
            int n = queue.poll();
            visit[n] = true;
            for(int i=1;i<=N;i++) {
                if (!visit[i] && inc[n][i] && is_contains(bArr, i, bArr.length))
                    queue.add(i);
            }
        }
        for(int i=0;i<bLen;i++){
            if(!visit[bArr[i]])
                return false;
        }
        return true;
    }
    static void comb(int st, int depth, int std){
        if(depth == std){
            int[] bArr = new int[N-std];
            int idx=0;
            Arrays.fill(visited,false);
            //System.out.print("A : ");
            for(int i=0;i<std;i++){
                visited[tmp[i]] = true;
                //System.out.print(tmp[i]+" ");
            }
            //System.out.println();
            //System.out.println("B 크기 : "+(N-std));
            for(int i=0;i<N;i++){
                if(!visited[area[i]]){
                    //System.out.println(area[i]);
                    bArr[idx++] = area[i];
                }

            }
            if(is_possible(bArr,std,N-std)){
                chk = true;
                int A = get_human(tmp,std);
                int B = get_human(bArr,N-std);
                int comp = Math.abs(A-B);
                min = min > comp ? comp : min;
            }
            return;
        }
        for(int i=st;i<N;i++){
            tmp[depth] = area[i];
            comb(i+1,depth+1,std);
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        area = new int[N];
        human = new int[N];
        tmp = new int[N];
        visited = new boolean[N+1];
        inc = new boolean[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        //입력
        for(int i=0;i<N;i++){
            human[i] = Integer.parseInt(st.nextToken());
            area[i] = i+1;
        }

        //인접 리스트 생성
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken());
                inc[i][to] = true;
                //inc[to][i] = true;
            }
        }
        //계산
        for(int i=1;i<=N/2;i++){
            comb(0,0,i);
        }
        if(chk)
            System.out.println(min);
        else
            System.out.println("-1");
    }
}
