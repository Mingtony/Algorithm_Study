import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1157 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] cnt = new int[26];
        Stack<Integer> stack = new Stack<Integer>();
        char[] arr = br.readLine().toUpperCase().toCharArray();
        for(int i=0;i<arr.length;i++)
            cnt[arr[i]-'A']++;
        int max = cnt[0];
        stack.add(0);
        for(int i=1;i<26;i++){
            if(max == cnt[i])
                stack.push(i);
            if(max < cnt[i] && cnt[i]!=0){
                max = cnt[i];
                while(!stack.isEmpty())
                    stack.pop();
                stack.push(i);
            }
        }
        if(stack.size()>1)
            System.out.println("?");
        else
            System.out.println((char)('A'+stack.pop()));
    }
}