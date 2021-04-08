import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_9996 {
    static boolean is_correct(String str, String front, String rear){
        int fLen = front.length(), rLen = rear.length();
        if(str.length() < fLen+rLen)
            return false;
        String s_front = str.substring(0,fLen);
        String s_rear = str.substring(str.length()-rLen,str.length());
        //System.out.println("s_front : "+s_front+", s_rear : "+s_rear);
        if(front.equals(s_front) && rear.equals(s_rear))
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer pattern = new StringTokenizer(br.readLine(),"*");
        String front = pattern.nextToken(), rear = pattern.nextToken();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(is_correct(str,front, rear))
                sb.append("DA\n");
            else
                sb.append("NE\n");
        }
        System.out.println(sb);
    }
}