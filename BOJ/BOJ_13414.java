import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;

public class BOJ_13414 {
    static ArrayList<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(L);
        HashSet<String> hs = new LinkedHashSet<>();
        //수강 신청 버튼 활성화 후 빨리 누른 학생 순으로 대기목록에 들어간다.
        //이미 대기열에 들어가 있는 상태에서 다시 수강신청 누르면 맨 뒤로 간다.
        //수강 신청 버튼 비활성화되면 대기목록 맨 앞 학생부터 자동으로 수강신청 완료
        //수강 가능 인원 꽉찰 경우 나머지 대기목록은 무시하고 수강신청 종료
        for(int i=0;i<L;i++){
            String tmp = br.readLine();
            if(!hs.add(tmp)){
                hs.remove(tmp);
                hs.add(tmp);
            }
        }
        Iterator<String> it = hs.iterator();
        while(K-->0 && it.hasNext())
            sb.append(it.next()+"\n");
        System.out.print(sb);

    }
}
