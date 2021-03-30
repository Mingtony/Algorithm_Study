import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Point{
    int r,c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Direction{
    int time;
    String dir;
    public Direction(int time, String dir){
        this.time = time;
        this.dir = dir;
    }
}
public class BOJ_3190 {
    static int N, apple, L;
    static int[] rc = {-1,1,0,0};
    static int[] cc = {0,0,-1,1};
    static int dir = 3;
    static boolean[] info;
    static Point start;
    static boolean chkBorder(){
        int r = start.r+rc[dir], c = start.c+cc[dir];
        if((r<=0 || r>N)||(c<=0 || c>N))
            return true;
        return false;
    }
    static boolean chkTouched(Queue<Point> queue){
        int r = start.r+rc[dir], c = start.c+cc[dir];
        for(Point p : queue){
            if(p.r == r && p.c == c)
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Point> queue = new LinkedList<>();
        Queue<Direction> dir_info = new LinkedList<>();
        ArrayList<Point> apples = new ArrayList<>();

        start = new Point(1,1);
        int time = 0;
        N = Integer.parseInt(br.readLine());
        apple = Integer.parseInt(br.readLine());
        info = new boolean[10001];
        //사과 위치
        for(int i=0;i<apple;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apples.add(new Point(r,c));
        }
        //방향 정보
        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            dir_info.add(new Direction(t,d));
        }
        //계산
        queue.add(new Point(1,1));
        while(true){
            if(!chkBorder() && !chkTouched(queue)){
                boolean ap_chk = false;
                start.r+=rc[dir];
                start.c+=cc[dir];
                //System.out.println("r : "+start.r+", c : "+start.c);
                time++;
                queue.add(new Point(start.r,start.c));
                for(int i=0;i<apples.size();i++){
                    if(apples.get(i).r==start.r &&apples.get(i).c==start.c){
                        apples.remove(i);
                        ap_chk = true;
                        break;
                    }
                }
                //사과 없다.
                if(!ap_chk)
                    queue.remove();

                if(!dir_info.isEmpty()){
                    Direction tmp = dir_info.peek();
                    if(time == tmp.time){
                        dir_info.remove();
                        switch(dir){
                            case 0:{
                                if(tmp.dir.equals("D"))
                                    dir = 3;
                                else
                                    dir = 2;
                                break;
                            }
                            case 1:{
                                if(tmp.dir.equals("D"))
                                    dir = 2;
                                else
                                    dir = 3;
                                break;
                            }case 2:{
                                if(tmp.dir.equals("D"))
                                    dir = 0;
                                else
                                    dir = 1;
                                break;
                            }case 3:{
                                if(tmp.dir.equals("D"))
                                    dir = 1;
                                else
                                    dir = 0;
                                break;
                            }


                        }
                    }
                }
            }
            else{
                time++;
                break;
            }

        }

        //출력
        System.out.println(time);
    }
}
