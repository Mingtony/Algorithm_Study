import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_2659 {
    static int get_clock_num(int std){
        char[] num = (std+"").toCharArray();
        int min = std;
        //시계수 구하기
        String str = "";
        for(int i=1;i<4;i++){
            str+=num[i%4];
            str+=num[(i+1)%4];
            str+=num[(i+2)%4];
            str+=num[(i+3)%4];
            int tMin = Integer.parseInt(str);
            min =  tMin < min ? tMin : min;
            str = "";
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[4];
        String str = "";
        int min=-1;
        for(int i=0;i<4;i++){
            num[i] = Integer.parseInt(st.nextToken());
            str+=num[i];
        }
        min = Integer.parseInt(str);
        str = "";
        //시계수 구하기
        for(int i=1;i<4;i++){
            str+=num[i%4];
            str+=num[(i+1)%4];
            str+=num[(i+2)%4];
            str+=num[(i+3)%4];
            int tMin = Integer.parseInt(str);
            min =  tMin < min ? tMin : min;
            str = "";
        }
        //몇 번째 시계수인지 구하기
        int n = 1111, cnt=0;
        while((n++)!=min){
            if(n == get_clock_num(n))
                cnt++;
        }
        System.out.println(cnt+1);
    }
}