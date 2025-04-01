import java.io.*;
import java.util.*;

//피보나치 비스무리한 수열
class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        long result = pivo(num);
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
       
    }

    public static long pivo(int num){
        if (num == 1 || num == 2 || num == 3) return 1;
        
        long[] pivoArr = new long[num];
        pivoArr[0] = 1;
        pivoArr[1] = 1;
        pivoArr[2] = 1;
        for(int i = 3; i < num; i++ ){
            pivoArr[i] = pivoArr[i-1] + pivoArr[i-3];
        }
        return pivoArr[num-1];
    }
}
