import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_15728 {
    static int N,K;
    static ArrayList<Integer> share, team;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        share = new ArrayList<>();
        team = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            share.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            team.add(Integer.parseInt(st.nextToken()));

//        //음수 * 음수 고를 경우 가장 큰 경우가 나올 수 있음(정렬 후 그리디 방식은 안됨!)
//        Arrays.sort(share);
//        Arrays.sort(team);
//        System.out.println(share[N-1]*team[N-K-1]);

        //최선의 방법 K장 골라 빼기
        int max = 0, idx = -1;
        for(int i=0;i<K;i++){
            max = Integer.MIN_VALUE;
            idx = -1;
            for(int j=0;j<N;j++){
                for(int k=0;k<team.size();k++){
                    if(max < share.get(j)*team.get(k)){
                        max = share.get(j) * team.get(k);
                        idx = k;
                    }
                }
            }
            team.remove(idx);
        }
        //max 값 찾기
        max = share.get(0)*team.get(0);
        for(int i=1;i<N;i++){
            for(int j=0;j<team.size();j++){
                max = share.get(i)*team.get(j)>max ? share.get(i)*team.get(j):max;
            }
        }
        System.out.println(max);
    }
}