import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temperature[i];
        }

        int maxTemp = sum;

        for (int i = K; i < N; i++) {
            sum = sum - temperature[i - K] + temperature[i];
            maxTemp = Math.max(maxTemp, sum);
        }

        bw.write(maxTemp + "\n");
        bw.flush();
        bw.close();
    }
}
