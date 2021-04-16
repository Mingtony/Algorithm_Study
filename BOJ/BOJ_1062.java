import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;

public class BOJ_1062
{
    static ArrayList<String> list;
    static boolean[] visited;
    static int limit = 5, max = Integer.MIN_VALUE;
    static void backtracking(int st, int depth, int std){
        if(depth == std){
            int possible=0;
            for(String str : list){
                boolean chk = true;
                for(int i=0;i<str.length();i++){
                    if(!visited[str.charAt(i)-'a']){
                        chk = false;
                        break;
                    }
                }
                if(chk)
                    possible++;
            }
            max = possible > max ? possible : max;
            return;
        }
        for(int i=st;i<26;i++){
            if(!visited[i]){
                visited[i] = true;
                backtracking(i+1,depth+1,std);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[26];
        if(K<limit)
            System.out.println(0);
        else if(K==26)
            System.out.println(N);
        else{
            K-=limit;
            list = new ArrayList<>();
            //a,c,i,n,t 방문 표시
            int[] fore = {'a'-'a','c'-'a','i'-'a','n'-'a','t'-'a'};
            for(int i=0;i<fore.length;i++)
                visited[fore[i]] = true;

            //단어 입력 및 카운팅
            for(int i=0;i<N;i++){
                String word = br.readLine();
                String cutted = word.substring(3,word.length()-4);
                list.add(cutted);
            }
            backtracking(0,0,K);
            if(max==0)
                System.out.println(0);
            else
                System.out.println(max);
        }
    }
}
