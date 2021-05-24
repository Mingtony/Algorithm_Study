import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;


public class BOJ_4659 {
    static boolean chk_moem_ch(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }
    static boolean chk_moem(String tmp){
        for(int i=0;i<tmp.length();i++){
            char cmp = tmp.charAt(i);
            if(chk_moem_ch(cmp))
                return true;
        }
        return false;
    }
    static boolean chk_three(String tmp){
        for(int i=0;i<tmp.length()-2;i++){
            String str = tmp.substring(i,i+3);
            boolean chk = true;
            int mcnt=0, jcnt=0;
            for(int j=0;j<3;j++){
                if(chk_moem_ch(str.charAt(j)))
                    mcnt++;
                else
                    jcnt++;
            }
            if(mcnt==3 || jcnt==3)
                return true;
        }
        return false;
    }
    static boolean chk_cons_two(String tmp){
        for(int i=0;i<tmp.length()-1;i++){
            String str = tmp.substring(i,i+2);
            if(str.charAt(0)==str.charAt(1)){
                if(!str.equals("ee") && !str.equals("oo"))
                    return false;
            }
        }
        return true;
    }
    static boolean chk_password(String tmp){
        if(chk_moem(tmp)){
            if(!chk_three(tmp)){
                if(chk_cons_two(tmp))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String tmp = "";
        while(!(tmp = br.readLine()).equals("end")){
            if(chk_password(tmp))
                sb.append("<"+tmp+">"+" is acceptable.\n");
            else
                sb.append("<"+tmp+">"+" is not acceptable.\n");
        }
        System.out.println(sb);
    }
}
