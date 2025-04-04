import java.io.*;
import java.util.*;

// 수열
public class Main {

    // 조건 : 전체 N일 동안의 온도가 주어지고, 그 중 연속적인 K일 씩의 온도 합 중 최대값을 반환하는 문제이다.
    // 온도 리스트에서 연속적인 K일 씩 묶었을 때의 값을 도출해내야 한다.
    // 그리고 그 값을 비교했을 때 가장 큰 값을 반환!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temperature = new int[N];
        int num = 0;
        while(st.hasMoreTokens()){
            temperature[num++] = Integer.parseInt(st.nextToken());
        }

        int maxTemp = Integer.MIN_VALUE;
        for(int i = 0; i <= (N-K); i++){
           int sum = 0;
           for(int j = i; j < i+K ; j++){
               sum +=temperature[j];
           }
            maxTemp = Math.max(maxTemp, sum);
        }
        
        bw.write(maxTemp + "\n");
        bw.flush();
        bw.close();


    }
}
