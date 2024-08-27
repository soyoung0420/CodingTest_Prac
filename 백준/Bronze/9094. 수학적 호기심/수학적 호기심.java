import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();
        // 0 < a < b < n ,  (a2+b2+m)/(ab)가 정수가 되려면 나머지가 0
        while(t-- > 0 ){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;
           //a, b 쌍을 찾아 순회
            for(int a = 1; a < n; a++){
                for(int b = a+1; b < n; b++){
                    if((a * a + b * b + m) % (a * b) == 0){
                        cnt++;
                    }
                }
            }
            result.add(cnt);
        }
        for(int num : result){
            bw.write(num +"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
