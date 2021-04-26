import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Map.*;

class KeyPoint{
    int x, y;
    public KeyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ_20436 {
    static HashMap<String,KeyPoint> jkb;
    static HashMap<String,KeyPoint> mkb;
    static int min = Integer.MAX_VALUE;
    static int result;

    static void calcTime(String str,String sl, String sr){
        String ltmp = sl, rtmp = sr;
        for(int i=0;i<str.length();i++){
            if(jkb.containsKey(str.charAt(i)+"")){
                KeyPoint k1 = jkb.get(sl);
                KeyPoint k2 = jkb.get(str.charAt(i)+"");
                result+=(Math.abs(k1.x-k2.x)+Math.abs(k1.y-k2.y));
                result++;
                sl = str.charAt(i)+"";
            }
            else{
                KeyPoint k1 = mkb.get(sr);
                KeyPoint k2 = mkb.get(str.charAt(i)+"");
                result+=(Math.abs(k1.x-k2.x)+Math.abs(k1.y-k2.y));;
                result++;
                sr = str.charAt(i)+"";
            }
        }
    }
    static void makeKeyboard(){
        //1줄
        jkb.put("q",new KeyPoint(0,0));
        jkb.put("w",new KeyPoint(1,0));
        jkb.put("e",new KeyPoint(2,0));
        jkb.put("r",new KeyPoint(3,0));
        jkb.put("t",new KeyPoint(4,0));
        mkb.put("y",new KeyPoint(5,0));
        mkb.put("u",new KeyPoint(6,0));
        mkb.put("i",new KeyPoint(7,0));
        mkb.put("o",new KeyPoint(8,0));
        mkb.put("p",new KeyPoint(9,0));
        //2줄
        jkb.put("a",new KeyPoint(0,1));
        jkb.put("s",new KeyPoint(1,1));
        jkb.put("d",new KeyPoint(2,1));
        jkb.put("f",new KeyPoint(3,1));
        jkb.put("g",new KeyPoint(4,1));
        mkb.put("h",new KeyPoint(5,1));
        mkb.put("j",new KeyPoint(6,1));
        mkb.put("k",new KeyPoint(7,1));
        mkb.put("l",new KeyPoint(8,1));
        //3줄
        jkb.put("z",new KeyPoint(0,2));
        jkb.put("x",new KeyPoint(1,2));
        jkb.put("c",new KeyPoint(2,2));
        jkb.put("v",new KeyPoint(3,2));
        mkb.put("b",new KeyPoint(4,2));
        mkb.put("n",new KeyPoint(5,2));
        mkb.put("m",new KeyPoint(6,2));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String sl = st.nextToken(), sr = st.nextToken();
        String str = br.readLine();
        jkb = new HashMap<>();
        mkb = new HashMap<>();
        makeKeyboard();
        calcTime(str,sl,sr);
        System.out.println(result);
    }
}
